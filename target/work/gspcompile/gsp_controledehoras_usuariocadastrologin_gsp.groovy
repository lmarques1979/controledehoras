import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuariocadastrologin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/cadastrologin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'usuario.label', default: 'Usuario'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("usuario.list.label")],-1)
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
invokeTag('message','g',18,['code':("springSecurity.login.header")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(postUrl)
printHtmlPart(9)
invokeTag('message','g',26,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(10)
invokeTag('message','g',31,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(11)
expressionOut.print(rememberMeParameter)
printHtmlPart(12)
if(true && (hasCookie)) {
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',37,['code':("springSecurity.login.remember.me.label")],-1)
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',40,['controller':("Usuario"),'action':("esqueceusenha")],2)
printHtmlPart(17)
expressionOut.print(message(code: "springSecurity.login.button"))
printHtmlPart(18)
invokeTag('message','g',54,['code':("usuario.create.label")],-1)
printHtmlPart(19)
if(true && (flash.message)) {
printHtmlPart(20)
expressionOut.print(flash.message)
printHtmlPart(21)
}
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(25)
expressionOut.print(error.field)
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('message','g',61,['error':(error)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',62,['bean':(usuarioInstance),'var':("error")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',64,['bean':(usuarioInstance)],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('render','g',67,['template':("form")],-1)
printHtmlPart(31)
invokeTag('submitButton','g',70,['name':("create"),'class':("save"),'value':(message(code: 'button.create.label', default: 'Create'))],-1)
printHtmlPart(32)
})
invokeTag('uploadForm','g',72,['url':([resource:usuarioInstance, action:'save'])],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407853288000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
