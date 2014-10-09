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
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'usuarioEmpresa.label', default: 'UsuarioEmpresa'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("empresalist.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
loop:{
int i = 0
for( usuarioEmpresaInstance in (usuarioEmpresaInstanceList) ) {
printHtmlPart(9)
if(true && (usuarioEmpresaInstance?.empresa)) {
printHtmlPart(10)
createTagBody(4, {->
printHtmlPart(11)
if(true && (usuarioEmpresaInstance?.empresa?.imagem)) {
printHtmlPart(12)
invokeTag('image','asset',26,['height':("50"),'width':("200"),'src':(usuarioEmpresaInstance?.empresa?.imagem),'title':(usuarioEmpresaInstance?.empresa?.razaosocial)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(12)
invokeTag('image','asset',29,['height':("50"),'width':("200"),'src':("/skin/noimage.jpg"),'title':(usuarioEmpresaInstance?.empresa?.razaosocial)],-1)
printHtmlPart(13)
}
printHtmlPart(11)
expressionOut.print(usuarioEmpresaInstance?.empresa?.razaosocial)
printHtmlPart(14)
})
invokeTag('link','g',32,['controller':("UsuarioEmpresa"),'action':("escolheempresausuario"),'id':(usuarioEmpresaInstance?.id)],4)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
invokeTag('image','asset',36,['src':("skin/edit.png")],-1)
printHtmlPart(11)
})
invokeTag('link','g',37,['controller':("empresa"),'action':("edit"),'resource':(usuarioEmpresaInstance?.empresa)],4)
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
invokeTag('hiddenField','g',39,['name':("id"),'value':(usuarioEmpresaInstance?.empresa?.id)],-1)
printHtmlPart(12)
invokeTag('actionSubmitImage','g',40,['class':("semborda"),'controller':("empresa"),'action':("delete"),'value':(message(code: 'button.delete.label')),'title':(message(code: 'button.delete.label')),'src':(assetPath(src:'skin/remove.png')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(11)
})
invokeTag('form','g',41,['controller':("empresa"),'action':("delete"),'method':("DELETE")],4)
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
if(true && (usuarioEmpresaInstanceCount > params.max)) {
printHtmlPart(20)
invokeTag('paginate','g',50,['total':(usuarioEmpresaInstanceCount ?: 0)],-1)
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1408752874000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
