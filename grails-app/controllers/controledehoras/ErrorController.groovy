package controledehoras

class ErrorController {

	def erros = []
	
	def internalerror(){
		render(view: '/error/500')
	}
	
    def denied() {
		erros[0] = message(code: 'error.403.message')
		flash.erros = erros
		render(view: '/error/403')
    }
	def notfound() {
		erros[0] = message(code: 'error.404.message')
		flash.erros = erros
		render(view: '/error/404')
	  }
}
