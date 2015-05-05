package file

import org.springframework.web.multipart.MultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import com.amazonaws.services.s3.model.*
import utils.*
import org.apache.commons.io.FilenameUtils

@Transactional(readOnly = true)
class FileUploadService {
	
	def amazonWebService
	def configurationService
	
	//Retorna Extensao de um determinado arquivo
	def getExtension(arquivo){
		return FilenameUtils.getExtension(arquivo)
	}
	//Retiro Extensao arquivo
	def removeExtension(arquivo){
		return FilenameUtils.removeExtension(arquivo)
	}
	
	def fileLocalDelete(destinationDirectory){
	
		def servletContext = ServletContextHolder.servletContext
		def storagePath = servletContext.getRealPath(destinationDirectory)
				
		boolean fileSuccessfullyDeleted =  new File(storagePath).delete()
		
		if(fileSuccessfullyDeleted){
			println "SUCESSO"
		}else{
			println "ERRO"
		}
		return fileSuccessfullyDeleted
	}
	
	def fileUpload(def f , def bucket , def pasta){
		
		def nomearquivo = (new Date()).getTime() + "_" + f.getOriginalFilename()
		File file = StreamUtil.stream2file(nomearquivo, f.getInputStream())
		amazonWebService.s3.putObject(new PutObjectRequest(bucket, pasta + nomearquivo , file).withCannedAcl(CannedAccessControlList.PublicRead))
		
		return nomearquivo
	}
	
	def fileDelete(def nomearquivo , def bucket , def pasta){
		
		if (nomearquivo!=null){
			amazonWebService.s3.deleteObject(bucket, pasta+nomearquivo)
		}
	}
	
    def String uploadFile(MultipartFile file, String name, String destinationDirectory) {
		
				def servletContext = ServletContextHolder.servletContext
				def storagePath = servletContext.getRealPath(destinationDirectory)
				
				
				println "Diretório: ${storagePath}"
				println "Arquivo: ${name}"
				
				// Create storage path directory if it does not exist
				def storagePathDirectory = new File(storagePath)
				if (!storagePathDirectory.exists()) {
					if (storagePathDirectory.mkdirs()) {
						println "SUCESSO"
					} else {
						println "FALHA"
					}
				}
		
				// Store file
				if (!file.isEmpty()) {
					file.transferTo(new File("${storagePath}/${name}"))
					println "Saved file: ${storagePath}/${name}"
					return "${storagePath}/${name}"
		
				} else {
					println "File ${file.inspect()} vazia!"
					return null
				}
	}
	
}
