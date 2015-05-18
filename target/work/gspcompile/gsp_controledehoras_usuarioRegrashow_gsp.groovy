import seguranca.UsuarioRegra
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuarioRegrashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioRegra/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'usuarioRegra.label', default: 'UsuarioRegra'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("usuarioRegra.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',13,['code':("usuarioRegra.list.label")],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("usuarioRegra.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("usuarioRegra.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (usuarioRegraInstance?.regra)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("usuarioRegra.regra.label"),'default':("Regra")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(usuarioRegraInstance?.regra?.authority)
})
invokeTag('link','g',28,['controller':("regra"),'action':("show"),'id':(usuarioRegraInstance?.regra?.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (usuarioRegraInstance?.usuario)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("usuarioRegra.usuario.label"),'default':("Usuario")],-1)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(usuarioRegraInstance?.usuario?.username)
})
invokeTag('link','g',37,['controller':("usuario"),'action':("show"),'id':(usuarioRegraInstance?.usuario?.id)],3)
printHtmlPart(13)
}
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',45,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',45,['class':("edit"),'action':("edit"),'resource':(usuarioRegraInstance)],3)
printHtmlPart(19)
invokeTag('actionSubmit','g',46,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(20)
})
invokeTag('form','g',48,['url':([resource:usuarioRegraInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',50,[:],1)
printHtmlPart(22)
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
