import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuario_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'username', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("usuario.username.label"),'default':("Username")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("username"),'size':("20"),'maxlenght':("30"),'required':(""),'value':(usuarioInstance?.username)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'password', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("usuario.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('passwordField','g',17,['name':("password"),'size':("20"),'maxlenght':("30"),'required':(""),'value':(usuarioInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'email', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("usuario.email.label"),'default':("Email")],-1)
printHtmlPart(2)
invokeTag('field','g',26,['type':("email"),'size':("35"),'maxlenght':("100"),'name':("email"),'required':(""),'value':(usuarioInstance?.email)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'primeironome', 'error'))
printHtmlPart(6)
invokeTag('message','g',32,['code':("usuario.primeironome.label"),'default':("Primeironome")],-1)
printHtmlPart(2)
invokeTag('textField','g',35,['name':("primeironome"),'required':(""),'value':(usuarioInstance?.primeironome)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'sobrenome', 'error'))
printHtmlPart(7)
invokeTag('message','g',41,['code':("usuario.sobrenome.label"),'default':("Sobrenome")],-1)
printHtmlPart(8)
invokeTag('textField','g',44,['name':("sobrenome"),'value':(usuarioInstance?.sobrenome)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'imagem', 'error'))
printHtmlPart(7)
invokeTag('message','g',50,['code':("usuario.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(9)
expressionOut.print(usuarioInstance?.imagem)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'enabled', 'error'))
printHtmlPart(11)
invokeTag('message','g',59,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',62,['name':("enabled"),'value':(usuarioInstance?.enabled)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error'))
printHtmlPart(13)
invokeTag('message','g',69,['code':("usuario.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(14)
invokeTag('checkBox','g',71,['name':("accountExpired"),'value':(usuarioInstance?.accountExpired)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error'))
printHtmlPart(15)
invokeTag('message','g',77,['code':("usuario.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',80,['name':("accountLocked"),'value':(usuarioInstance?.accountLocked)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'enabled', 'error'))
printHtmlPart(11)
invokeTag('message','g',86,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',89,['name':("enabled"),'value':(usuarioInstance?.enabled)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error'))
printHtmlPart(16)
invokeTag('message','g',95,['code':("usuario.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',98,['name':("passwordExpired"),'value':(usuarioInstance?.passwordExpired)],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407853229000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
