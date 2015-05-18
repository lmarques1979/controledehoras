import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_controledehoras_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',3,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',4,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',14,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'apple-touch-icon.png'))
printHtmlPart(6)
expressionOut.print(assetPath(src: 'apple-touch-icon-retina.png'))
printHtmlPart(7)
invokeTag('stylesheet','asset',19,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',20,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',21,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',30,['code':("usuarios.label")],-1)
})
invokeTag('link','g',30,['class':("usuarios"),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (sec.loggedInUserInfo(field: 'username') != 'admin')) {
printHtmlPart(13)
if(true && (session["usuarioempresa"])) {
printHtmlPart(14)
createTagBody(5, {->
invokeTag('message','g',35,['code':("horas.label")],-1)
})
invokeTag('link','g',35,['class':("horas"),'controller':("Horas"),'action':("index")],5)
printHtmlPart(15)
}
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',37,['code':("configuracao.label")],-1)
})
invokeTag('link','g',37,['class':("configuracao"),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(16)
createTagBody(4, {->
invokeTag('message','g',38,['code':("dadosusuario.label")],-1)
})
invokeTag('link','g',38,['class':("usuario"),'controller':("Usuario"),'action':("show"),'id':(sec.loggedInUserInfo(field:"id"))],4)
printHtmlPart(16)
createTagBody(4, {->
invokeTag('message','g',39,['code':("empresacreate.label")],-1)
})
invokeTag('link','g',39,['class':("cadempresa"),'controller':("Empresa"),'action':("create")],4)
printHtmlPart(16)
createTagBody(4, {->
invokeTag('message','g',40,['code':("empresalist.label")],-1)
})
invokeTag('link','g',40,['class':("listempresa"),'controller':("UsuarioEmpresa"),'action':("index")],4)
printHtmlPart(11)
}
printHtmlPart(17)
createTagBody(3, {->
invokeTag('message','g',43,['code':("logout.label")],-1)
})
invokeTag('link','g',43,['class':("logout"),'controller':("logout"),'action':("index")],3)
printHtmlPart(18)
})
invokeTag('ifLoggedIn','sec',46,[:],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',50,['code':("usuario.create.label")],-1)
})
invokeTag('link','g',50,['class':("cadastrousuario"),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',54,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(23)
invokeTag('message','g',57,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(24)
invokeTag('actionSubmitImage','g',59,['title':(message(code: 'entrar.label')),'value':(message(code: 'button.create.label')),'src':(assetPath(src:'skin/loginSpring.png'))],-1)
printHtmlPart(9)
createTagBody(4, {->
invokeTag('message','g',60,['code':("esqueceusenha.label")],-1)
})
invokeTag('link','g',60,['controller':("Usuario"),'action':("esqueceusenha"),'class':("esqueceusenha")],4)
printHtmlPart(25)
})
invokeTag('form','g',61,['url':("/${meta(name:'app.name')}/j_spring_security_check"),'method':("POST"),'id':("formlogin"),'class':("cssform"),'autocomplete':("off")],3)
printHtmlPart(26)
})
invokeTag('ifNotLoggedIn','sec',69,[:],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
if(true && (session["usuarioempresa"])) {
printHtmlPart(9)
if(true && (session["usuarioempresa"].empresa.imagem)) {
printHtmlPart(29)
createTagBody(5, {->
printHtmlPart(30)
invokeTag('image','asset',79,['height':("50"),'width':("200"),'src':(session["usuarioempresa"].empresa.imagem),'title':(session["usuarioempresa"].empresa.razaosocial)],-1)
printHtmlPart(29)
})
invokeTag('link','g',80,['controller':("empresa"),'action':("edit"),'id':(session["usuarioempresa"].empresa.id)],5)
printHtmlPart(9)
}
printHtmlPart(25)
}
printHtmlPart(31)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(29)
invokeTag('image','asset',88,['height':("65"),'width':("65"),'src':(usuarioInstance.imagem),'title':(usuarioInstance.buscaNome(usuarioInstance))],-1)
printHtmlPart(9)
})
invokeTag('link','g',89,['controller':("usuario"),'action':("show"),'id':(usuarioInstance.id)],4)
printHtmlPart(25)
}
else {
printHtmlPart(29)
invokeTag('image','asset',92,['height':("65"),'width':("65"),'src':("noimage.jpg"),'title':(usuarioInstance.buscaNome(usuarioInstance))],-1)
printHtmlPart(25)
}
printHtmlPart(32)
})
invokeTag('ifLoggedIn','sec',98,[:],2)
printHtmlPart(33)
invokeTag('layoutBody','g',100,[:],-1)
printHtmlPart(34)
invokeTag('message','g',102,['code':("titulopagina.label")],-1)
printHtmlPart(35)
invokeTag('meta','g',102,['name':("app.version")],-1)
printHtmlPart(36)
invokeTag('message','g',103,['code':("desenvolvido.label")],-1)
printHtmlPart(37)
invokeTag('message','g',105,['code':("copyrigth.label")],-1)
printHtmlPart(38)
invokeTag('message','g',110,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(39)
})
invokeTag('captureBody','sitemesh',111,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1412861410000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
