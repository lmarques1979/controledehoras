import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuarioshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/show.gsp" }
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
invokeTag('message','g',13,['code':("usuario.list.label")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (usuarioInstance?.imagem)) {
printHtmlPart(9)
invokeTag('message','g',22,['code':("usuario.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(10)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(11)
invokeTag('image','asset',26,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(usuarioInstance.imagem),'title':(usuarioInstance.username)],-1)
printHtmlPart(12)
}
else {
printHtmlPart(11)
invokeTag('image','asset',29,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("noimage.jpg"),'title':(usuarioInstance.username)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (usuarioInstance?.username)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("usuario.username.label"),'default':("Username")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(usuarioInstance),'field':("username")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (usuarioInstance?.email)) {
printHtmlPart(19)
invokeTag('message','g',49,['code':("usuario.email.label"),'default':("Email")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',51,['bean':(usuarioInstance),'field':("email")],-1)
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (usuarioInstance?.primeironome)) {
printHtmlPart(22)
invokeTag('message','g',58,['code':("usuario.primeironome.label"),'default':("Primeironome")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',60,['bean':(usuarioInstance),'field':("primeironome")],-1)
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (usuarioInstance?.sobrenome)) {
printHtmlPart(24)
invokeTag('message','g',67,['code':("usuario.sobrenome.label"),'default':("Sobrenome")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',69,['bean':(usuarioInstance),'field':("sobrenome")],-1)
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (usuarioInstance?.enabled)) {
printHtmlPart(26)
invokeTag('message','g',76,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(27)
invokeTag('formatBoolean','g',78,['boolean':(usuarioInstance?.enabled)],-1)
printHtmlPart(21)
}
printHtmlPart(28)
if(true && (usuarioInstance?.accountExpired)) {
printHtmlPart(29)
invokeTag('message','g',86,['code':("usuario.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(30)
invokeTag('formatBoolean','g',88,['boolean':(usuarioInstance?.accountExpired)],-1)
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (usuarioInstance?.accountLocked)) {
printHtmlPart(31)
invokeTag('message','g',95,['code':("usuario.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(32)
invokeTag('formatBoolean','g',97,['boolean':(usuarioInstance?.accountLocked)],-1)
printHtmlPart(21)
}
printHtmlPart(18)
if(true && (usuarioInstance?.enabled)) {
printHtmlPart(26)
invokeTag('message','g',104,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(27)
invokeTag('formatBoolean','g',106,['boolean':(usuarioInstance?.enabled)],-1)
printHtmlPart(21)
}
printHtmlPart(33)
if(true && (usuarioInstance?.passwordExpired)) {
printHtmlPart(34)
invokeTag('message','g',114,['code':("usuario.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(35)
invokeTag('formatBoolean','g',116,['boolean':(usuarioInstance?.passwordExpired)],-1)
printHtmlPart(21)
}
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
invokeTag('message','g',128,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',128,['class':("edit"),'action':("edit"),'resource':(usuarioInstance)],3)
printHtmlPart(38)
invokeTag('actionSubmit','g',129,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
})
invokeTag('form','g',131,['url':([resource:usuarioInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407852356000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
