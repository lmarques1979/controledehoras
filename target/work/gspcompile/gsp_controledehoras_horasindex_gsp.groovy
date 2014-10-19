import controledehoras.Horas
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_horasindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/horas/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (params.filtromes)) {
printHtmlPart(1)
invokeTag('set','g',3,['var':("mes"),'value':(params.int('filtromes'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',6,['var':("mes"),'value':(formatDate(format:"MM" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(0)
if(true && (params.filtroano)) {
printHtmlPart(1)
invokeTag('set','g',9,['var':("ano"),'value':(params.int('filtroano'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',12,['var':("ano"),'value':(formatDate(format:"yyyy" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(2)
invokeTag('set','g',15,['var':("diahoje"),'value':(formatDate(format:"dd" , date:new Date()))],-1)
printHtmlPart(0)
invokeTag('set','g',16,['var':("meshoje"),'value':(formatDate(format:"MM" , date:new Date()))],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',21,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
invokeTag('set','g',22,['var':("entityName"),'value':(message(code: 'horas.label', default: 'Horas'))],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',23,['code':("hora.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',23,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',23,[:],2)
printHtmlPart(4)
invokeTag('stylesheet','asset',24,['src':("jquery.timeentry.css")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',25,['src':("jquery.timeentry.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',26,['src':("spinner_init.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',27,['src':("highcharts/modules/exporting.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',28,['src':("highcharts/highcharts.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',29,['src':("funcoes.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',35,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
invokeTag('message','g',39,['code':("hora.list.label")],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (flash.error)) {
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
expressionOut.print(error)
printHtmlPart(14)
})
invokeTag('eachError','g',52,['in':(flash.error),'var':("error")],3)
printHtmlPart(15)
}
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('select','g',57,['onchange':("this.form.submit()"),'value':(mes),'name':("filtromes"),'from':(['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho' , 'Agosto' , 'Setembro' , 'Outubro' , 'Novembro' , 'Dezembro']),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(17)
invokeTag('field','g',58,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("filtroano"),'value':(ano),'type':("number")],-1)
printHtmlPart(18)
})
invokeTag('form','g',59,['url':([resource:horasInstance, action:'index'])],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('hiddenField','g',62,['name':("mes"),'value':(mes)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',63,['name':("ano"),'value':(ano)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',64,['name':("totaliza"),'value':("1")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',65,['name':("usuarioempresa"),'value':(session["usuarioempresa"].id)],-1)
printHtmlPart(21)
expressionOut.print(message(code: 'horas.inclusao.label'))
printHtmlPart(22)
expressionOut.print(message(code: 'horas.dia.label'))
printHtmlPart(23)
expressionOut.print(message(code: 'horas.entrada1.label'))
printHtmlPart(23)
expressionOut.print(message(code: 'horas.saida1.label'))
printHtmlPart(23)
expressionOut.print(message(code: 'horas.entrada2.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida2.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida3.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.entrada3.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida4.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.entrada4.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida5.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.entrada5.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.observacao.label'))
printHtmlPart(25)
invokeTag('field','g',106,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(26)
invokeTag('textField','g',108,['name':("entrada1"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(26)
invokeTag('textField','g',110,['name':("saida1"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(26)
invokeTag('textField','g',112,['name':("entrada2"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',114,['name':("saida2"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',116,['name':("saida3"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',118,['name':("entrada3"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',120,['name':("saida4"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',122,['name':("entrada4"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',124,['name':("saida5"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',126,['name':("entrada5"),'size':("4"),'maxlength':("5"),'class':("timeentry")],-1)
printHtmlPart(27)
invokeTag('textField','g',128,['name':("observacao"),'size':("10")],-1)
printHtmlPart(28)
invokeTag('submitButton','g',135,['name':("create"),'class':("save"),'value':(message(code: 'button.create.label', default: 'Create'))],-1)
printHtmlPart(29)
})
invokeTag('form','g',140,['url':([resource:horasInstance, action:'save'])],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('image','asset',144,['src':("skin/gerarmes.png"),'title':(message(code: 'horas.gerarmes.label'))],-1)
printHtmlPart(32)
})
invokeTag('link','g',145,['controller':("horas"),'action':("gerarmes"),'params':([mes:mes, ano:ano,usuarioempresa:session['usuarioempresa'].id])],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('image','asset',147,['src':("skin/imprimir.png"),'title':(message(code: 'horas.imprimir.label'))],-1)
printHtmlPart(32)
})
invokeTag('link','g',148,['controller':("horas"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano, usuarioempresa:session['usuarioempresa'].id])],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('image','asset',151,['src':("skin/email.png"),'title':(message(code: 'horas.email.label'))],-1)
printHtmlPart(32)
})
invokeTag('link','g',152,['controller':("horas"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano, usuarioempresa:session['usuarioempresa'].id])],2)
printHtmlPart(34)
invokeTag('image','asset',154,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
expressionOut.print(message(code: 'horas.edicao.label'))
printHtmlPart(22)
expressionOut.print(message(code: 'horas.dia.label'))
printHtmlPart(23)
expressionOut.print(message(code: 'horas.entrada1.label'))
printHtmlPart(23)
expressionOut.print(message(code: 'horas.saida1.label'))
printHtmlPart(23)
expressionOut.print(message(code: 'horas.entrada2.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida2.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida3.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.entrada3.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida4.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.entrada4.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.saida5.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.entrada5.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.observacao.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.totaliza.label'))
printHtmlPart(24)
expressionOut.print(message(code: 'horas.totaldia.label'))
printHtmlPart(37)
invokeTag('set','g',200,['var':("total"),'value':(0)],-1)
printHtmlPart(31)
loop:{
int i = 0
for( horasInstance in (horasInstanceList) ) {
printHtmlPart(38)
invokeTag('hiddenField','g',203,['name':("idalteracao"),'value':(horasInstance.id)],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',204,['name':("mes"),'value':(horasInstance.mes)],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',205,['name':("ano"),'value':(horasInstance.ano)],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',206,['name':("usuarioempresa"),'value':(horasInstance.usuarioempresa.id)],-1)
printHtmlPart(40)
expressionOut.print(horasInstance.dia == diahoje.toInteger() && horasInstance.mes == meshoje.toInteger() ? 'diahoje' : '')
printHtmlPart(41)
invokeTag('field','g',210,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(horasInstance.dia),'type':("number"),'required':("")],-1)
printHtmlPart(42)
invokeTag('textField','g',212,['name':("entrada1"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.entrada1))],-1)
printHtmlPart(43)
invokeTag('textField','g',214,['name':("saida1"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.saida1))],-1)
printHtmlPart(43)
invokeTag('textField','g',216,['name':("entrada2"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.entrada2))],-1)
printHtmlPart(44)
invokeTag('textField','g',218,['name':("saida2"),'size':("4"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.saida2))],-1)
printHtmlPart(44)
invokeTag('textField','g',220,['name':("saida3"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.saida3))],-1)
printHtmlPart(44)
invokeTag('textField','g',222,['name':("entrada3"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.entrada3))],-1)
printHtmlPart(44)
invokeTag('textField','g',224,['name':("saida4"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.saida4))],-1)
printHtmlPart(44)
invokeTag('textField','g',226,['name':("entrada4"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.entrada4))],-1)
printHtmlPart(44)
invokeTag('textField','g',228,['name':("saida5"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.saida5))],-1)
printHtmlPart(44)
invokeTag('textField','g',230,['name':("entrada5"),'size':("4"),'maxlength':("5"),'class':("timeentry"),'value':(formatDate(format:"HH:mm" , date:horasInstance.entrada5))],-1)
printHtmlPart(45)
invokeTag('textField','g',233,['class':("centro"),'name':("observacao"),'size':("10"),'value':(horasInstance.observacao)],-1)
printHtmlPart(46)
invokeTag('hiddenField','g',237,['name':("totalizahidden"),'id':("totalizahidden"),'value':(horasInstance.totaliza)],-1)
printHtmlPart(47)
invokeTag('checkBox','g',238,['class':("totaliza"),'name':("totaliza"),'value':(horasInstance.totaliza)],-1)
printHtmlPart(48)
invokeTag('textField','g',241,['class':("centro"),'name':("totaldia"),'id':("totaldia${horasInstance.dia}"),'size':("4"),'value':(formatNumber(number:horasInstance.totaldia,maxFractionDigits:3 , minFractionDigits:3)),'readonly':("readonly")],-1)
printHtmlPart(49)
createTagBody(4, {->
printHtmlPart(50)
invokeTag('hiddenField','g',246,['name':("id"),'value':(horasInstance?.id)],-1)
printHtmlPart(50)
invokeTag('hiddenField','g',247,['name':("mes"),'value':(mes)],-1)
printHtmlPart(50)
invokeTag('hiddenField','g',248,['name':("ano"),'value':(ano)],-1)
printHtmlPart(50)
invokeTag('actionSubmitImage','g',249,['id':("submitimage"),'class':("tabela"),'controller':("horas"),'action':("delete"),'value':(message(code: 'button.delete.label')),'title':(message(code: 'button.delete.label')),'src':(assetPath(src:'skin/remove.png')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(51)
})
invokeTag('form','g',251,['controller':("horas"),'action':("delete")],4)
printHtmlPart(52)
if(true && (horasInstance.totaliza)) {
printHtmlPart(53)
invokeTag('set','g',256,['var':("total"),'value':(total + horasInstance.totaldia)],-1)
printHtmlPart(39)
}
printHtmlPart(54)
i++
}
}
printHtmlPart(55)
invokeTag('textField','g',263,['class':("total"),'name':("totalgeral"),'id':("totalgeral"),'size':("6"),'value':(formatNumber(number:total,maxFractionDigits:3 , minFractionDigits:3)),'readonly':("readonly")],-1)
printHtmlPart(56)
invokeTag('submitButton','g',270,['id':("formupdatesubmit"),'name':("create"),'class':("save"),'value':(message(code: 'button.create.label', default: 'Create'))],-1)
printHtmlPart(29)
})
invokeTag('form','g',275,['id':("formupdate"),'url':([resource:horasInstance, action:'update'])],2)
printHtmlPart(57)
})
invokeTag('captureBody','sitemesh',281,[:],1)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412998741000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
