<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>

		<div class="nav" role="navigation">
				<ul>
				    	<!-- Usuario admin -->
						<sec:ifLoggedIn>
								<g:if test="${sec.loggedInUserInfo(field: 'username') == 'admin'}">
									 <li><g:link class="usuarios" controller="Usuario" action="index"><g:message code="usuarios.label"/></g:link></li>
								</g:if>
								<!-- Usuarios logados -->
								<g:if test="${sec.loggedInUserInfo(field: 'username') != 'admin'}">
									 <g:if test="${session["usuarioempresa"]}">
										 <li><g:link class="horas" controller="Horas" action="index" ><g:message code="horas.label"/></g:link></li>
									 </g:if>
									 <li><g:link class="configuracao" controller="Configuracao" action="index" ><g:message code="configuracao.label"/></g:link></li>
									 <li><g:link class="usuario" controller="Usuario" action="show" id="${sec.loggedInUserInfo(field:"id")}"><g:message code="dadosusuario.label"/></g:link></li>
									 <li><g:link class="cadempresa" controller="Empresa" action="create"><g:message code="empresacreate.label"/></g:link></li>
									 <li><g:link class="listempresa" controller="UsuarioEmpresa" action="index"><g:message code="empresalist.label"/></g:link></li>
								</g:if> 
							
								<li><g:link class="logout" controller="logout" action="index"><g:message code="logout.label"/></g:link></li>
							
								
							</sec:ifLoggedIn>
						
						<sec:ifNotLoggedIn>
					
					    <li><g:link class="cadastrousuario" controller="Usuario" action="create" ><g:message code="usuario.create.label"/></g:link></li>
						<div class="loginprincipal">
							<g:form url='/${meta(name:'app.name')}/j_spring_security_check' method='POST' id='formlogin' class='cssform' autocomplete='off'>
							
								<label for='password'><g:message code="springSecurity.login.username.label"/>:</label>
								<input type='text' name='j_username' id='username'/>
								
								<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
								<input type='password' name='j_password' id='password'/>
								<g:actionSubmitImage title="${message(code: 'entrar.label')}" value="${message(code: 'button.create.label')}" src="${assetPath(src:'skin/loginSpring.png')}" />
								<g:link controller="Usuario" action="esqueceusenha" class="esqueceusenha"><g:message code="esqueceusenha.label"/></g:link>
							</g:form>
							<script type='text/javascript'>
								(function() {
									document.forms['formlogin'].elements['j_username'].focus();
								})();
							</script>
		
						</div>
					</sec:ifNotLoggedIn>
				</ul>
			</div><div class="clearer"></div>
			<sec:ifLoggedIn>
				<div class="logo">
	
						<div class="logoempresa">
							<g:if test="${session["usuarioempresa"]}">
								<g:if test="${session["usuarioempresa"].empresa.imagem}">
									<g:link controller="empresa" action="edit" id="${session["usuarioempresa"].empresa.id}">
										<asset:image height="50" width="200" src="${session["usuarioempresa"].empresa.imagem}" title="${session["usuarioempresa"].empresa.razaosocial}"/>
									</g:link>
								</g:if>
							</g:if>
						</div>
						
						<div class="logousuario">
							<g:if test="${usuarioInstance.imagem}">
								<g:link controller="usuario" action="show" id="${usuarioInstance.id}">
									<asset:image height="65" width="65" src="${usuarioInstance.imagem}" title="${usuarioInstance.buscaNome(usuarioInstance)}"/>
								</g:link>
							</g:if>	
							<g:else>
									<asset:image height="65" width="65" src="noimage.jpg" title="${usuarioInstance.buscaNome(usuarioInstance)}"/>
							</g:else>
						</div>
					
						
				</div>
			</sec:ifLoggedIn>
					
		<g:layoutBody/>
		<div class="footer" role="contentinfo">
			<span><g:message code="titulopagina.label"/> <g:meta name="app.version"/> - 
			<g:message code="desenvolvido.label"/> 
			<br>
			<g:message code="copyrigth.label"/>
				
			</span>
		</div>
		
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
