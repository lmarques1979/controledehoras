<%@ page import="seguranca.UsuarioRegra" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioRegra.label', default: 'UsuarioRegra')}" />
		<title><g:message code="usuarioRegra.list.label"/></title>
	</head>
	<body>
		<a href="#show-usuarioRegra" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="usuarioRegra.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="usuarioRegra.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-usuarioRegra" class="content scaffold-show" role="main">
			<h1><g:message code="usuarioRegra.list.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuarioRegra">
			
				<g:if test="${usuarioRegraInstance?.regra}">
				<li class="fieldcontain">
					<span id="regra-label" class="property-label"><g:message code="usuarioRegra.regra.label" default="Regra" /></span>
					
						<span class="property-value" aria-labelledby="regra-label"><g:link controller="regra" action="show" id="${usuarioRegraInstance?.regra?.id}">${usuarioRegraInstance?.regra?.authority}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioRegraInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="usuarioRegra.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="usuario" action="show" id="${usuarioRegraInstance?.usuario?.id}">${usuarioRegraInstance?.usuario?.username}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:usuarioRegraInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${usuarioRegraInstance}"><g:message code="button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
