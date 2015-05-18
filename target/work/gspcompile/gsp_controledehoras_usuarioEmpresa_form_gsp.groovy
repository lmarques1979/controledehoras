import controledehoras.UsuarioEmpresa
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuarioEmpresa_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioEmpresa/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: usuarioEmpresaInstance, field: 'usuario', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("usuarioEmpresa.usuario.label"),'default':("Usuario")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("usuario"),'name':("usuario.id"),'from':(seguranca.Usuario.list()),'optionKey':("id"),'required':(""),'value':(usuarioEmpresaInstance?.usuario?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioEmpresaInstance, field: 'empresa', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("usuarioEmpresa.empresa.label"),'default':("Empresa")],-1)
printHtmlPart(2)
invokeTag('select','g',17,['id':("empresa"),'name':("empresa.id"),'from':(controledehoras.Empresa.list()),'optionKey':("id"),'required':(""),'value':(usuarioEmpresaInstance?.empresa?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: usuarioEmpresaInstance, field: 'horas', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("usuarioEmpresa.horas.label"),'default':("Horas")],-1)
printHtmlPart(6)
for( h in (usuarioEmpresaInstance?.horas) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(h?.encodeAsHTML())
})
invokeTag('link','g',29,['controller':("horas"),'action':("show"),'id':(h.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'horas.label', default: 'Horas')]))
})
invokeTag('link','g',32,['controller':("horas"),'action':("create"),'params':(['usuarioEmpresa.id': usuarioEmpresaInstance?.id])],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423083523000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
