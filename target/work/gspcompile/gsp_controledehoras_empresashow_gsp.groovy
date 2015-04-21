import controledehoras.Empresa
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_empresashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/empresa/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'empresa.label', default: 'Empresa'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',14,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (empresaInstance?.razaosocial)) {
printHtmlPart(10)
invokeTag('message','g',22,['code':("empresa.razaosocial.label"),'default':("Razaosocial")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',24,['bean':(empresaInstance),'field':("razaosocial")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (empresaInstance?.cnpj)) {
printHtmlPart(14)
invokeTag('message','g',31,['code':("empresa.cnpj.label"),'default':("Cnpj")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',33,['bean':(empresaInstance),'field':("cnpj")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (empresaInstance?.imagem)) {
printHtmlPart(16)
invokeTag('message','g',40,['code':("empresa.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(17)
invokeTag('image','asset',43,['height':("50"),'width':("200"),'src':(empresaInstance?.imagem),'title':(empresaInstance?.razaosocial)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (empresaInstance?.ativa)) {
printHtmlPart(20)
invokeTag('message','g',51,['code':("empresa.ativa.label"),'default':("Ativa")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',52,['boolean':(empresaInstance?.ativa)],-1)
printHtmlPart(12)
}
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',61,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',61,['class':("edit"),'action':("edit"),'resource':(empresaInstance)],3)
printHtmlPart(24)
invokeTag('actionSubmit','g',62,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',64,['url':([resource:empresaInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1429564417000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
