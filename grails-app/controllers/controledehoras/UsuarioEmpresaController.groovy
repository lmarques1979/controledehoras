package controledehoras

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured("isFullyAuthenticated()")
@Transactional(readOnly = true)
class UsuarioEmpresaController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	
    def index(Integer max) {
        def configuracoes = configuracaoParams
		configuracoes.max = Math.min(4, 1000)
		def resultado = UsuarioEmpresa.createCriteria().list (configuracoes) {
			eq("usuario.id" , usuarioLogado.id)
		}
		
        respond resultado, model:[usuarioEmpresaInstanceCount: resultado.totalCount]
    }
	
	def escolheempresausuario(UsuarioEmpresa usuarioEmpresaInstance){
		session["usuarioempresa"] = usuarioEmpresaInstance
		redirect(controller: "horas", action: "index") 
	}

    def show(UsuarioEmpresa usuarioEmpresaInstance) {
        respond usuarioEmpresaInstance
    }

    def create() {
        respond new UsuarioEmpresa(params)
    }

    @Transactional
    def save(UsuarioEmpresa usuarioEmpresaInstance) {
        if (usuarioEmpresaInstance == null) {
            notFound()
            return
        }

        if (usuarioEmpresaInstance.hasErrors()) {
            respond usuarioEmpresaInstance.errors, view:'create'
            return
        }

        usuarioEmpresaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuarioEmpresa.label', default: 'UsuarioEmpresa'), usuarioEmpresaInstance.id])
                redirect usuarioEmpresaInstance
            }
            '*' { respond usuarioEmpresaInstance, [status: CREATED] }
        }
    }

    def edit(UsuarioEmpresa usuarioEmpresaInstance) {
        respond usuarioEmpresaInstance
    }

    @Transactional
    def update(UsuarioEmpresa usuarioEmpresaInstance) {
        if (usuarioEmpresaInstance == null) {
            notFound()
            return
        }

        if (usuarioEmpresaInstance.hasErrors()) {
            respond usuarioEmpresaInstance.errors, view:'edit'
            return
        }

        usuarioEmpresaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UsuarioEmpresa.label', default: 'UsuarioEmpresa'), usuarioEmpresaInstance.id])
                redirect usuarioEmpresaInstance
            }
            '*'{ respond usuarioEmpresaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UsuarioEmpresa usuarioEmpresaInstance) {

        if (usuarioEmpresaInstance == null) {
            notFound()
            return
        }

		if(session["usuarioempresa"]){
			if(usuarioEmpresaInstance.id==session["usuarioempresa"].id){
				session["usuarioempresa"]=null
			}
		}
		
		usuarioEmpresaInstance.delete flush:true
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UsuarioEmpresa.label', default: 'UsuarioEmpresa'), usuarioEmpresaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarioEmpresa.label', default: 'UsuarioEmpresa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
