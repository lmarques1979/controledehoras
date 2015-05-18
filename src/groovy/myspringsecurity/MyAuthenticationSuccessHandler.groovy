package myspringsecurity    
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.web.authentication.AjaxAwareAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import seguranca.Usuario
import static org.springframework.http.HttpStatus.*

class MyAuthenticationSuccessHandler extends AjaxAwareAuthenticationSuccessHandler{

		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){

		def username = authentication.getPrincipal().username
		 
		if (username=='admin'){
			redirectStrategy.sendRedirect(request, response, '/usuario/index');
		}else{
			redirectStrategy.sendRedirect(request, response, '/usuarioEmpresa/index');
		}
		
	}
}