<%@ page import="seguranca.UsuarioRegra" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioRegra.label', default: 'UsuarioRegra')}" />
		<title><g:message code="usuarioRegra.list.label" /></title>
	</head>
	<body>
		<a href="#list-usuarioRegra" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="usuarioRegra.create.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-usuarioRegra" class="content scaffold-list" role="main">
			<h1><g:message code="usuarioRegra.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="usuarioRegra.regra.label" default="Regra" /></th>
					
						<th><g:message code="usuarioRegra.usuario.label" default="Usuario" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioRegraInstanceList}" status="i" var="usuarioRegraInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usuarioRegraInstance.id}">${usuarioRegraInstance?.regra?.authority}</g:link></td>
					
						<td>${usuarioRegraInstance?.usuario?.username}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usuarioRegraInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
