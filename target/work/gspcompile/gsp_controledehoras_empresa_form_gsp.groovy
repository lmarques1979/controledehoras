import controledehoras.Empresa
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_empresa_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/empresa/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: empresaInstance, field: 'razaosocial', 'error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("empresa.razaosocial.label"),'default':("Razaosocial")],-1)
printHtmlPart(2)
invokeTag('textField','g',7,['name':("razaosocial"),'required':(""),'value':(empresaInstance?.razaosocial)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: empresaInstance, field: 'cnpj', 'error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("empresa.cnpj.label"),'default':("Cnpj")],-1)
printHtmlPart(5)
invokeTag('textField','g',16,['name':("cnpj"),'maxlength':("14"),'value':(empresaInstance?.cnpj)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: empresaInstance, field: 'imagem', 'error'))
printHtmlPart(6)
invokeTag('message','g',22,['code':("empresa.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: empresaInstance, field: 'ativa', 'error'))
printHtmlPart(8)
invokeTag('message','g',30,['code':("empresa.ativa.label"),'default':("Ativa")],-1)
printHtmlPart(5)
invokeTag('checkBox','g',33,['name':("ativa"),'value':(empresaInstance?.ativa)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1429563738000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
