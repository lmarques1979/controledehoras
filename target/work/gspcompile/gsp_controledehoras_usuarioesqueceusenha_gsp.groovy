import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuarioesqueceusenha_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/esqueceusenha.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',11,['code':("esqueceusenha.label")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
loop:{
int i = 0
for( mensagem in (flash.message) ) {
printHtmlPart(8)
expressionOut.print(mensagem)
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',21,['code':("usuario.username.label")],-1)
printHtmlPart(12)
expressionOut.print(params.username)
printHtmlPart(13)
invokeTag('message','g',26,['code':("usuario.email.label")],-1)
printHtmlPart(12)
expressionOut.print(params.email)
printHtmlPart(14)
expressionOut.print(message(code: "enviar.label"))
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',42,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405193534000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
