import controledehoras.Horas
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_horasimprimir_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/horas/imprimir.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',5,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'horas.label', default: 'Horas'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',10,['code':("hora.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(3)
invokeTag('stylesheet','asset',11,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',12,['src':("application.js")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
if(true && (flash.error)) {
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(error)
printHtmlPart(7)
})
invokeTag('eachError','g',19,['in':(flash.error),'var':("error")],2)
printHtmlPart(8)
}
else {
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(usuarioInstance.buscaNome(usuarioInstance))
printHtmlPart(10)
expressionOut.print(mes)
printHtmlPart(11)
expressionOut.print(ano)
printHtmlPart(12)
expressionOut.print(message(code: 'horas.dia.label'))
printHtmlPart(13)
expressionOut.print(message(code: 'horas.entrada1.label'))
printHtmlPart(13)
expressionOut.print(message(code: 'horas.saida1.label'))
printHtmlPart(13)
expressionOut.print(message(code: 'horas.entrada2.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.saida2.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.saida3.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.entrada3.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.saida4.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.entrada4.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.saida5.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.entrada5.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.observacao.label'))
printHtmlPart(14)
expressionOut.print(message(code: 'horas.totaldia.label'))
printHtmlPart(15)
invokeTag('set','g',61,['var':("total"),'value':(0)],-1)
printHtmlPart(16)
loop:{
int i = 0
for( horasInstance in (horasInstanceList) ) {
printHtmlPart(17)
expressionOut.print(horasInstance.dia)
printHtmlPart(18)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.entrada1))
printHtmlPart(19)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.saida1))
printHtmlPart(19)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.entrada2))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.saida2))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.saida3))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.entrada3))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.saida4))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.entrada4))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.saida5))
printHtmlPart(20)
expressionOut.print(formatDate(format:"HH:mm" , date:horasInstance.entrada5))
printHtmlPart(21)
expressionOut.print(horasInstance.observacao)
printHtmlPart(22)
expressionOut.print(formatNumber(number:horasInstance.totaldia,maxFractionDigits:3 , minFractionDigits:3))
printHtmlPart(23)
invokeTag('set','g',94,['var':("total"),'value':(total + horasInstance.totaldia)],-1)
printHtmlPart(16)
i++
}
}
printHtmlPart(24)
expressionOut.print(formatNumber(number:total,maxFractionDigits:3 , minFractionDigits:3))
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',109,['class':("impressao"),'onload':("window.print()")],2)
printHtmlPart(1)
}
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412355588000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
