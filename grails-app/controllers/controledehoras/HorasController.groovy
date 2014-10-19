package controledehoras

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import seguranca.Usuario
import java.text.SimpleDateFormat

@Secured("isFullyAuthenticated()")
@Transactional(readOnly = true)
class HorasController extends BaseController{

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def pdfRenderingService
	
	def index() {
		
		if(session["usuarioempresa"]){
			
			if(!params.filtromes){
				params.filtromes = formatDate(format:"MM" , date:new Date())
			}
			if(!params.filtroano){
				params.filtroano = formatDate(format:"yyyy" , date:new Date())
			}
			
			def resultado = Horas.createCriteria().list () {
					eq("usuarioempresa" , session["usuarioempresa"])
					eq("mes" , params.filtromes.toInteger())
					eq("ano" , params.filtroano.toInteger())
					order('dia', 'asc')
					order('mes', 'asc')
					order('ano', 'asc')
			}
				
				respond resultado
		}else{
			redirect(controller: "usuarioEmpresa", action: "index")
		}
		
	}
	
	def enviarpdfemail(){
		
		def usuarioEmpresaInstance=UsuarioEmpresa.get(params.usuarioempresa.toInteger())
		
		def resultado = Horas.createCriteria().list () {
			eq("usuarioempresa" , usuarioEmpresaInstance)
			eq("mes" , params.int('mes'))
			eq("ano" , params.int('ano'))
			eq("totaliza" , 1)
			order('dia', 'asc')
			order('mes', 'asc')
			order('ano', 'asc')
		}
		def nome_arquivo = "horas_" + params.mes + "_" +  params.ano + "_" + (new Date()).getTime() + ".pdf"
		
		ByteArrayOutputStream bytes = pdfRenderingService.render(template: "/horas/gerarpdf",  model: [horasInstanceList:resultado , mes: params.mes,ano:params.ano])
		def anexo = bytes.toByteArray()
		
		def assunto = "Horas do mês " + params.mes + " de " + params.ano
		def mensagem = "Favor verificar o anexo."
		def destinatario = usuarioEmpresaInstance?.usuario?.email
		//Envio E-mail
		sendMail {
			multipart true
			to destinatario
			subject assunto
			html mensagem
			attachBytes nome_arquivo,"application/pdf",anexo
		}
		
		flash.message = message(code: 'pdfenviado.label' , args: [destinatario])
		redirect action:"index", params:[filtromes: params.mes,filtroano:params.ano]
	}
	
	def imprimir(){
		
		def usuarioEmpresaInstance=UsuarioEmpresa.get(params.int('usuarioempresa'))
		def erros = []
		if(usuarioEmpresaInstance){
			if(usuarioEmpresaInstance.usuario!=usuarioLogado){
				erros[0] = message(code: 'horas.naoautorizado.message')
				flash.erros = erros
				return
			}
		}else{
			return
		}
		def resultado = Horas.createCriteria().list () {
			eq("usuarioempresa" , usuarioEmpresaInstance)
			eq("mes" , params.int('mes'))
			eq("ano" , params.int('ano'))
			eq("totaliza" , 1)
			order('dia', 'asc')
			order('mes', 'asc')
			order('ano', 'asc')
		}
		
		respond resultado, model:[mes:params.mes,ano:params.ano]
	}
	
	@Transactional
	def gerarmes(){
		def diasmes
		def i
		def mes = params.mes.toInteger()
		def usuarioEmpresaInstance=UsuarioEmpresa.get(params.int('usuarioempresa'))
		def erros = []
		if(usuarioEmpresaInstance){
			if(usuarioEmpresaInstance.usuario!=usuarioLogado){
				erros[0] = message(code: 'horas.naoautorizado.message')
				flash.erros = erros
				redirect action:"index"
			}
		}else{
			redirect action:"index"
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		def resultado = Horas.createCriteria().list () {
			eq("usuarioempresa" , usuarioEmpresaInstance)
			eq("mes" , params.int('mes'))
			eq("ano" , params.int('ano'))
			order('dia', 'asc')
			order('mes', 'asc')
			order('ano', 'asc')
		}
		if(mes==1 || mes==3 || mes==5|| mes==7 || mes==8 || mes==10 ||mes==12){
			diasmes=31
		}
		if(mes==4 || mes==6 || mes==9 || mes==11){
			diasmes=30
		}
		if(mes==2){
			diasmes=29
		}
		
		for(i=1; i <= diasmes ; i++){
			def diainsercao=i
			def dtstr = i + '/' +  params.mes + '/' + params.ano + ' 00:00'
			def dt = sdf.parse(dtstr)
			def cal = new GregorianCalendar();
			cal.setTime(dt)
			def diasemana = cal.get(Calendar.DAY_OF_WEEK)
			def k
			if(diasemana!=1 && diasemana!=7){
				def insere=1
				for(k=0 ; k < resultado.size() ; k++){
					def diabanco = resultado[k].dia
					if (diabanco==diainsercao){
						insere=0
						break
					}
				}
				if(insere){
					def horasInstance = new Horas()
					def dtstrhr = diainsercao + '/' +  params.mes + '/' + params.ano
					horasInstance.dia			=	diainsercao
					horasInstance.mes			=	params.int('mes')
					horasInstance.ano 			=	params.int('ano')
					horasInstance.usuarioempresa=	usuarioEmpresaInstance
					horasInstance.entrada1 		=   sdf.parse(dtstrhr + ' 09:00')
					horasInstance.saida1 		=   sdf.parse(dtstrhr + ' 12:00')
					horasInstance.entrada2 		=   sdf.parse(dtstrhr + ' 13:00')
					horasInstance.saida2 		=   sdf.parse(dtstrhr + ' 18:00')
					horasInstance.totaldia 		=   8
					horasInstance.clearErrors()
					horasInstance.save flush:true
				
					if (horasInstance.hasErrors()) {
						respond horasInstance.errors, view:'index'
						return
					}
				}
			}
		}
		flash.message = message(code: 'mesgerado.label')
		redirect action:"index", params:[filtromes: params.mes,filtroano:params.ano ]
	}
	
	
	def diferencaHoras(def horasInstance){
		
		def total = 0
		def differenceMilliSeconds
		def horas
		if(horasInstance.entrada1 && horasInstance.saida1){
			differenceMilliSeconds = horasInstance.saida1.getTime()-horasInstance.entrada1.getTime()
			horas=(differenceMilliSeconds/1000/60/60)
			total=total + horas
		}else{
			total=total + 0
		}
		if(horasInstance.saida2 && horasInstance.entrada2){
			differenceMilliSeconds = horasInstance.saida2.getTime()-horasInstance.entrada2.getTime()
			horas=(differenceMilliSeconds/1000/60/60)
			total=total + horas
		}else{
			total=total + 0
		}
		if(horasInstance.saida3 && horasInstance.entrada3){
			differenceMilliSeconds = horasInstance.entrada3.getTime()-horasInstance.saida3.getTime()
			horas=(differenceMilliSeconds/1000/60/60)
			total=total - horas
		}else{
			total=total + 0
		}
		if(horasInstance.saida4 && horasInstance.entrada4){
			differenceMilliSeconds = horasInstance.entrada4.getTime()-horasInstance.saida4.getTime()
			horas=(differenceMilliSeconds/1000/60/60)
			total=total - horas
		}else{
			total=total + 0
		}
		if(horasInstance.saida5 && horasInstance.entrada5){
			differenceMilliSeconds = horasInstance.entrada5.getTime()-horasInstance.saida5.getTime()
			horas=(differenceMilliSeconds/1000/60/60)
			total=total - horas
		}else{
			total=total + 0
		}
		return total
		
	}
	
	def validaHoras(def parametro, def index, def horasInstance, def mes , def ano){
		
		def i=0
		def erros=[]
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		def dia
		def entrada1,saida1,entrada2,saida2,saida3,entrada3
		def saida4,entrada4, saida5,entrada5
		def dtentrada1,dtsaida1,dtentrada2,dtsaida2,dtsaida3,dtentrada3
		def dtsaida4,dtentrada4, dtsaida5,dtentrada5
		flash.message=null
		if(index!=null){
			dia = parametro.dia[index]
			entrada1 = parametro.entrada1[index]
			saida1=parametro.saida1[index]
			entrada2=parametro.entrada2[index]
			saida2=parametro.saida2[index]
			saida3=parametro.saida3[index]
			entrada3=parametro.entrada3[index]
			saida4=parametro.saida4[index]
			entrada4=parametro.entrada4[index]
			saida5=parametro.saida5[index]
			entrada5=parametro.entrada5[index]
		}else{
			dia = parametro.dia
			entrada1=parametro.entrada1
			saida1=parametro.saida1
			entrada2=parametro.entrada2
			saida2=parametro.saida2
			saida3=parametro.saida3
			entrada3=parametro.entrada3
			saida4=parametro.saida4
			entrada4=parametro.entrada4
			saida5=parametro.saida5
			entrada5=parametro.entrada5
		}
		
		def datasemhora = dia + '/' + mes + '/' + ano
		
		if(entrada1){
			def dtentrada1str =  datasemhora + ' ' + entrada1
			dtentrada1 = sdf.parse(dtentrada1str)
		}
		if(saida1){
			def dtsaida1str = datasemhora + ' ' + saida1
			dtsaida1 = sdf.parse(dtsaida1str)
		}
		if(entrada2){
			def dtentrada2str = datasemhora + ' ' + entrada2
			dtentrada2 = sdf.parse(dtentrada2str)
		}
		if(saida2){
			def dtsaida2str = datasemhora + ' ' + saida2
			dtsaida2 = sdf.parse(dtsaida2str)
		}
		if(saida3){
			def dtsaida3str = datasemhora + ' ' + saida3
			dtsaida3 = sdf.parse(dtsaida3str)
		}
		if(entrada3){
			def dtentrada3str = datasemhora + ' ' + entrada3
			dtentrada3 = sdf.parse(dtentrada3str)
		}
		if(saida4){
			def dtsaida4str = datasemhora + ' ' + saida4
			dtsaida4 = sdf.parse(dtsaida4str)
		}
		
		if(entrada4){
			def dtentrada4str = datasemhora + ' ' + entrada4
			dtentrada4= sdf.parse(dtentrada4str)
		}
		
		if(saida5){
			def dtsaida5str = datasemhora + ' ' + saida5
			dtsaida5= sdf.parse(dtsaida5str)
		}
		if(entrada5){
			def dtentrada5str = datasemhora + ' ' + entrada5
			dtentrada5 = sdf.parse(dtentrada5str)
		}
		
		if(dtentrada1 && dtsaida1){
			if(dtentrada1 > dtsaida1){
				erros[i] = 'Dia ' + dia + ' - ' +  message(code: 'horas.almocomenorentrada.message')
				i++
			}
		}
		if(dtsaida1 && dtentrada2){
			if(dtsaida1 > dtentrada2){
				erros[i] = 'Dia ' + dia + ' - ' + message(code: 'horas.almocosaidamaiorretorno.message')
				i++
			}
		}
		if(dtentrada2 && dtsaida2){
			if(dtentrada2 > dtsaida2){
				erros[i] = 'Dia ' + dia + ' - ' + message(code: 'horas.almocosaidamenorretornoalmoco.message')
				i++
			}
		}
		if(dtsaida3 && dtentrada3){
			if(dtsaida3 > dtentrada3){
				erros[i] = 'Dia ' + dia + ' - ' + message(code: 'horas.almocosaida1maiorretorno.message')
				i++
			}
		}
		if(dtsaida4 && dtentrada4){
			if(dtsaida4 > dtentrada4){
				erros[i] = 'Dia ' + dia + ' - ' + message(code: 'horas.almocosaida2maiorretorno.message')
				i++
			}
		}
		if(dtsaida5 && dtentrada5){
			if(dtsaida5 > dtentrada5){
				erros[i] = 'Dia ' + dia + ' - ' + message(code: 'horas.almocosaida3maiorretorno.message')
				i++
			}
		}
		if(erros.size>0){
			return erros
		}else{
			
			horasInstance.entrada1	= dtentrada1
			horasInstance.saida1	= dtsaida1
			horasInstance.entrada2	= dtentrada2
			horasInstance.saida2	= dtsaida2
			horasInstance.saida3	= dtsaida3
			horasInstance.entrada3	= dtentrada3
			horasInstance.saida4	= dtsaida4
			horasInstance.entrada4	= dtentrada4
			horasInstance.saida5	= dtsaida5
			horasInstance.entrada5	= dtentrada5
			
			def difhoras = diferencaHoras(horasInstance)
			horasInstance.totaldia=difhoras
			
			return horasInstance
			
		}
		
	}
	@Transactional
	def save(Horas horasInstance) {
		
		if (horasInstance == null) {
			notFound()
			return
		}
				
		def horas = validaHoras(params , null, horasInstance, horasInstance.mes, horasInstance.ano)
		if(horas==-1){
			return
		}else{
		
			horas.clearErrors()
			horas.save flush:true
		
			if (horas.hasErrors()) {
				respond horas.errors, view:'index'
				return
			}
			flash.message = message(code: 'horariossalvo.label')
		}
		
		redirect action:"index", params:[filtromes: horasInstance.mes,filtroano:horasInstance.ano ]
		
	}

	def edit(Horas horasInstance) {
		respond horasInstance
	}
	
	def atualizatotal() {
		
		def mes, ano, totaliza
		def idHora=params.list('idalteracao')
		def total = idHora.size()
		def totaldia=[]
		def errobanco=[]
		def erros=[]
		def dias=[]
		def erro=0
		def idhorario, ind
		def data=[]
		mes = params.mes[0]
		ano = params.ano[0]
		def usuarioInstance=Usuario.get(usuarioLogado.id)
		def nome=usuarioInstance.buscaNome(usuarioInstance)
		
		for(int i=0 ; i < total ; i++){
			
			if (total > 1){
				idhorario = params.idalteracao[i]
				totaliza  = params.totalizahidden[i] 
				ind=i
			}else{
				idhorario = params.idalteracao
				totaliza  = params.totalizahidden
				ind=null
			}
			def horasInstance = Horas.get(Long.valueOf(idhorario).longValue())
			def retorno = validaHoras(params , ind, horasInstance, mes , ano)
			
			//Verifico se o objeto retornado é uma Instancia de Horas
			//Senão é um array de erros
			if(retorno in Horas){
				
				retorno.totaliza=Long.valueOf(totaliza).longValue()
				if(retorno.totaliza){
					totaldia.add(retorno.totaldia.round(3))
					dias.add(retorno.dia)
				}
			
			}else{
				erros=retorno
				erro++
				break
			}
		}
		if(erro==0){
			render(status:200,contentType: "application/json"){
				//(totaldia:totaldia,mes:mes,ano:ano,dias:dias)
				[totaldia:totaldia,mes:mes,ano:ano,dias:dias, usuario:nome]
			}
		}else{
			if(errobanco.size()>0){
				render(status:500,contentType: "application/json"){
					errobanco
				}
				
			}else{
				render(status:500,contentType: "application/json"){
					erros
				}
			}
		}
	}
	@Transactional
	def update() {
		
		def mes, ano, obs, totaliza
		def idHora=params.list('idalteracao')
		def total = idHora.size()
		def totaldia=[]
		def errobanco=[]
		def erros=[]
		def erro=0
		def dias=[]
		def idhorario , ind
		mes = params.mes[0]
		ano = params.ano[0]
		def usuarioInstance=Usuario.get(usuarioLogado.id)
		def nome=usuarioInstance.buscaNome(usuarioInstance)
		flash.message=null
		flash.error=null
		usuarioLogado
		for(int i=0 ; i < total ; i++){
			if(total>1){
				obs = params.observacao[i]
				idhorario = params.idalteracao[i]
				totaliza=params.totalizahidden[i]
				ind=i
			}else{
				obs = params.observacao
				idhorario = params.idalteracao
				totaliza=params.totalizahidden
				ind=null
			}
			
			def horasInstance = Horas.get(Long.valueOf(idhorario).longValue())
				
			def retorno = validaHoras(params , ind, horasInstance , mes , ano)
			
			/*Verifico se o objeto retornado é uma Instancia de Horas
			Senão é um array de erros*/
			if(retorno in Horas){
				
				retorno.observacao=obs
				retorno.totaliza=Long.valueOf(totaliza).longValue()
				if(retorno.totaliza){
					totaldia.add(retorno.totaldia.round(3))
					dias.add(retorno.dia)
				}
				retorno.clearErrors()
				retorno.save flush:true
		
				if (retorno.hasErrors()) {
					errobanco=retorno.errors
					erro++
					break
				}
				
			}else{
				erros=retorno
				erro++
				break
			}
		}
		if(erro==0){
			render(status:200,contentType: "application/json"){
				[totaldia:totaldia,mes:mes,ano:ano,dias:dias, usuario:nome]
			}
		}else{
			if(errobanco.size()>0){
				render(status:500,contentType: "application/json"){
					errobanco
				}
				
			}else{
				render(status:500,contentType: "application/json"){
					erros
				}
			}
		}
	}

	@Transactional
	def delete(Horas horasInstance) {
		if (horasInstance == null) {
			notFound()
			return
		}

		horasInstance.delete flush:true
		flash.message = message(code: 'horarioexcluido.label')
		redirect action:"index" , params:[filtromes: horasInstance.mes,filtroano:horasInstance.ano ]
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'horas.label', default: 'Horas'), params.id])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
