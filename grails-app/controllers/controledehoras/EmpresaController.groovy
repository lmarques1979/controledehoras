package controledehoras

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured("isFullyAuthenticated()")
@Transactional(readOnly = true)
class EmpresaController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    /*def index(Integer max) {
        def configuracoes = configuracaoParams
        respond Empresa.list(configuracoes), model:[empresaInstanceCount: Empresa.count()]
    }*/

    def show(Empresa empresaInstance) {
        respond empresaInstance
    }

    def create() {
        respond new Empresa(params)
    }

    @Transactional
    def save(Empresa empresaInstance) {
        if (empresaInstance == null) {
            notFound()
            return
        }
		
		def f = request.getFile('arquivo')
		if (!f.empty) {
			def imagem = fileUpload(f)
			empresaInstance.imagem = imagem
		}
        
        empresaInstance.save flush:true
		
		if (empresaInstance.hasErrors()) {
			respond empresaInstance.errors, view:'create'
			return
		}else{
		
			def usuarioEmpresaInstance = new UsuarioEmpresa()
			usuarioEmpresaInstance.usuario=usuarioLogado
			usuarioEmpresaInstance.empresa=empresaInstance
			usuarioEmpresaInstance.save flush:true
			if (usuarioEmpresaInstance.hasErrors()) {
				respond usuarioEmpresaInstance.errors, view:'create'
				return
			}
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empresa.label', default: 'Empresa'), empresaInstance.id])
                redirect empresaInstance
            }
            '*' { respond empresaInstance, [status: CREATED] }
        }
    }

    def edit(Empresa empresaInstance) {
        respond empresaInstance
    }

    @Transactional
    def update(Empresa empresaInstance) {
        if (empresaInstance == null) {
            notFound()
            return
        }
		
		
		def f = request.getFile('arquivo')
		if (!f.empty) {
			def deleteS3 = fileDelete(empresaInstance.imagem)
			def imagem = fileUpload(f)
			empresaInstance.imagem = imagem
		}
		
        empresaInstance.save flush:true
			
		if (empresaInstance.hasErrors()) {
			respond empresaInstance.errors, view:'edit'
			return
		}else{
			flash.message = message(code: 'default.updated.message', args: [message(code: 'Empresa.label', default: 'Empresa'), empresaInstance.id])
		}
		
		redirect(controller: "usuarioEmpresa", action: "index")
        
    }

    @Transactional
    def delete(Empresa empresaInstance) {

        if (empresaInstance == null) {
            notFound()
            return
        }

		if(session["usuarioempresa"]){
			if(empresaInstance.id==session["usuarioempresa"].empresa.id){
				session["usuarioempresa"]=null
			}
		}	
		
        empresaInstance.delete flush:true
		if (empresaInstance.hasErrors()) {
			flash.error=empresaInstance.errors
			return
		}else{
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'Empresa.label', default: 'Empresa'), empresaInstance.id])
		}
		 			
        redirect(controller: "usuarioEmpresa", action: "index")
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empresa.label', default: 'Empresa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
