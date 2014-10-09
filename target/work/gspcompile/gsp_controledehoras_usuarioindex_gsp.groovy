import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuarioindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/index.gsp" }
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
createTagBody(2, {->
invokeTag('message','g',13,['code':("usuario.create.label")],-1)
})
invokeTag('link','g',13,['class':("create"),'action':("create")],2)
printHtmlPart(5)
invokeTag('message','g',17,['code':("usuario.list.label")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('sortableColumn','g',25,['property':("username"),'title':(message(code: 'usuario.username.label', default: 'Username'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',26,['property':("email"),'title':(message(code: 'usuario.email.label', default: 'Email'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',27,['property':("primeironome"),'title':(message(code: 'usuario.primeironome.label', default: 'Primeironome'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("sobrenome"),'title':(message(code: 'usuario.sobrenome.label', default: 'Sobrenome'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',29,['property':("imagem"),'title':(message(code: 'usuario.imagem.label', default: 'Imagem'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',30,['property':("enabled"),'title':(message(code: 'usuario.enabled.label', default: 'Ativo'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( usuarioInstance in (usuarioInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: usuarioInstance, field: "username"))
})
invokeTag('link','g',37,['action':("show"),'id':(usuarioInstance.id)],3)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: usuarioInstance, field: "email"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: usuarioInstance, field: "primeironome"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: usuarioInstance, field: "sobrenome"))
printHtmlPart(15)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(16)
invokeTag('image','asset',46,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(usuarioInstance.imagem),'title':(usuarioInstance.username)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(16)
invokeTag('image','asset',49,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("noimage.jpg"),'title':(usuarioInstance.username)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatBoolean','g',54,['boolean':(usuarioInstance?.enabled)],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',62,['total':(usuarioInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407852334000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
