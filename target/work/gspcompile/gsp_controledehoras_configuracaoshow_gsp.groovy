import controledehoras.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_configuracaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'configuracao.label', default: 'Configuracao'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("configuracao.list.label")],-1)
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
invokeTag('message','g',13,['code':("configuracao.list.label")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (configuracaoInstance?.alturaimagens)) {
printHtmlPart(9)
invokeTag('message','g',21,['code':("configuracao.alturaimagens.label"),'default':("Altura Imagens")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',23,['bean':(configuracaoInstance),'field':("alturaimagens")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.larguraimagens)) {
printHtmlPart(13)
invokeTag('message','g',30,['code':("configuracao.larguraimagens.label"),'default':("Largura Imagens")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',32,['bean':(configuracaoInstance),'field':("larguraimagens")],-1)
printHtmlPart(11)
}
printHtmlPart(15)
if(true && (configuracaoInstance?.alturaimagensthumbs)) {
printHtmlPart(16)
invokeTag('message','g',39,['code':("configuracao.alturaimagensthumbs.label"),'default':("Altura Imagens Thumnail")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',41,['bean':(configuracaoInstance),'field':("alturaimagensthumbs")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.larguraimagensthumbs)) {
printHtmlPart(17)
invokeTag('message','g',48,['code':("configuracao.larguraimagensthumbs.label"),'default':("Largura Imagens Thumbnail")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',50,['bean':(configuracaoInstance),'field':("larguraimagensthumbs")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.itensporpagina)) {
printHtmlPart(19)
invokeTag('message','g',57,['code':("configuracao.itensporpagina.label"),'default':("Itens por Página")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',59,['bean':(configuracaoInstance),'field':("itensporpagina")],-1)
printHtmlPart(11)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',70,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',70,['class':("edit"),'action':("edit"),'resource':(configuracaoInstance)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',71,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('form','g',73,['url':([resource:configuracaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1407874177000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
