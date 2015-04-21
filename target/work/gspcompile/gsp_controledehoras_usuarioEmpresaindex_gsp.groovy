import controledehoras.UsuarioEmpresa
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_usuarioEmpresaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioEmpresa/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
if(true && (params.ativa)) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("ativa"),'value':(params.ativa)],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',7,['var':("ativa"),'value':("A")],-1)
printHtmlPart(0)
}
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',13,['var':("entityName"),'value':(message(code: 'usuarioEmpresa.label', default: 'UsuarioEmpresa'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',14,['code':("empresalist.label")],-1)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(3)
invokeTag('javascript','asset',15,['src':("grafico.js")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',20,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('select','g',30,['onchange':("this.form.submit()"),'value':(ativa),'name':("ativa"),'from':([message(code:'ativa.label'),message(code:'inativa.label'),message(code:'todos.label')]),'keys':(['A','I','T'])],-1)
printHtmlPart(11)
})
invokeTag('form','g',32,['url':([resource:usuarioEmpresaInstance, action:'index'])],2)
printHtmlPart(12)
loop:{
int i = 0
for( usuarioEmpresaInstance in (usuarioEmpresaInstanceList) ) {
printHtmlPart(13)
if(true && (usuarioEmpresaInstance?.empresa)) {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
if(true && (usuarioEmpresaInstance?.empresa?.imagem)) {
printHtmlPart(16)
invokeTag('image','asset',43,['height':("50"),'width':("200"),'src':(usuarioEmpresaInstance?.empresa?.imagem),'title':(usuarioEmpresaInstance?.empresa?.razaosocial)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(16)
invokeTag('image','asset',46,['height':("50"),'width':("200"),'src':("/skin/noimage.jpg"),'title':(usuarioEmpresaInstance?.empresa?.razaosocial)],-1)
printHtmlPart(17)
}
printHtmlPart(15)
expressionOut.print(usuarioEmpresaInstance?.empresa?.razaosocial)
printHtmlPart(18)
})
invokeTag('link','g',49,['controller':("UsuarioEmpresa"),'action':("escolheempresausuario"),'id':(usuarioEmpresaInstance?.id)],4)
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
invokeTag('image','asset',53,['src':("skin/edit.png")],-1)
printHtmlPart(15)
})
invokeTag('link','g',54,['controller':("empresa"),'action':("edit"),'resource':(usuarioEmpresaInstance?.empresa)],4)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
invokeTag('hiddenField','g',56,['name':("id"),'value':(usuarioEmpresaInstance?.empresa?.id)],-1)
printHtmlPart(16)
invokeTag('actionSubmitImage','g',57,['class':("semborda"),'controller':("empresa"),'action':("delete"),'value':(message(code: 'button.delete.label')),'title':(message(code: 'button.delete.label')),'src':(assetPath(src:'skin/remove.png')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(15)
})
invokeTag('form','g',58,['controller':("empresa"),'action':("delete"),'method':("DELETE")],4)
printHtmlPart(21)
}
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
if(true && (usuarioEmpresaInstanceCount > params.max)) {
printHtmlPart(24)
invokeTag('paginate','g',67,['total':(usuarioEmpresaInstanceCount ?: 0)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1429582294000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
