<%@ page import="seguranca.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="usuario.list.label" /></title>
	</head>
	<body>
		<a href="#list-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-usuario" class="content scaffold-list" role="main">
			
			<div class="logincadastro">
					<div class="login">
							<div id='login'>
									<div class='inner'>
										<div class='fheader'><g:message code="springSecurity.login.header"/></div>
								
										<g:if test='${flash.message}'>
											<div class='login_message'>${flash.message}</div>
										</g:if>
								
										<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
											<p>
												<label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
												<input type='text' class='text_' name='j_username' id='username'/>
											</p>
								
											<p>
												<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
												<input type='password' class='text_' name='j_password' id='password'/>
											</p>
								
											<!--<p id="remember_me_holder">
												<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
												<label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
											</p>-->
											
											<g:link controller="Usuario" action="esqueceusenha">Esqueceu a Senha?</g:link>
											<p>
												<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
											</p>
										</form>
									</div>
								</div>
								<script type='text/javascript'>
									(function() {
										document.forms['loginForm'].elements['j_username'].focus();
									})();
								</script>
					</div>
					<div id="create-usuario" class="content scaffold-create" role="main">
								<h1><g:message code="usuario.create.label"/></h1>
								<g:if test="${flash.message}">
								<div class="message" role="status">${flash.message}</div>
								</g:if>
								<g:hasErrors bean="${usuarioInstance}">
								<ul class="errors" role="alert">
									<g:eachError bean="${usuarioInstance}" var="error">
									<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
									</g:eachError>
								</ul>
								</g:hasErrors>
								<g:uploadForm url="[resource:usuarioInstance, action:'save']">
									<fieldset class="form">
										<g:render template="form"/>
									</fieldset>
									<fieldset class="buttons">
										<g:submitButton name="create" class="save" value="${message(code: 'button.create.label', default: 'Create')}" />
									</fieldset>
								</g:uploadForm>
					</div>
			</div>
		</div>
	</body>
</html>
