package controledehoras
import utils.*
import com.amazonaws.services.s3.model.*
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isAuthenticated()")
class BaseController{
   
	def configurationService
	def springSecurityService
	def bucket  = 'timesheetlmdcm'
	def amazonWebService
	def pasta = 'assets/' 
	
	def fileUpload(def f){
		def nomearquivo = (new Date()).getTime() + "_" + f.getOriginalFilename()
		File file = StreamUtil.stream2file(nomearquivo, f.getInputStream())
		amazonWebService.s3.putObject(new PutObjectRequest(bucket, pasta + nomearquivo , file).withCannedAcl(CannedAccessControlList.PublicRead))
		
		return nomearquivo
	}
	
	def fileDelete(def nomearquivo){
		
		if (nomearquivo!=null){
			amazonWebService.s3.deleteObject(bucket, pasta+nomearquivo)
		}
	}
	
	def getConfiguracaoParams(){
		
			def resultado = Configuracao.findAllByUsuario(usuarioLogado)
			resultado.each() {
				params.alturaimagens 		= it.alturaimagens ? it.alturaimagens : "120"
				params.larguraimagens 		= it.larguraimagens ? it.larguraimagens : "125"
				params.alturaimagensthumbs 	= it.alturaimagensthumbs ? it.alturaimagensthumbs : "20"
				params.larguraimagensthumbs	= it.larguraimagensthumbs ? it.larguraimagensthumbs : "25"
				params.max = Math.min(it.itensporpagina ? it.itensporpagina : 20, 10000)
			}
			if (resultado.size() == 0){
				params.alturaimagens 		= "120"
				params.larguraimagens 		= "125"
				params.alturaimagensthumbs 	= "20"
				params.larguraimagensthumbs	= "25"
				params.max = Math.min(20, 10000)
			}
			params
	}
  
	
  def getUsuarioLogado(){
		  springSecurityService.currentUser
  }
 
}