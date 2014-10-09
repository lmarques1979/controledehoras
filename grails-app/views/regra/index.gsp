<%@ page import="seguranca.Regra" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regra.label', default: 'Regra')}" />
		<title><g:message code="regra.list.label"/></title>
	</head>
	<body>
		<a href="#list-regra" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
			<li><g:link class="create" action="create"><g:message code="regra.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="list-regra" class="content scaffold-list" role="main">
			<h1><g:message code="regra.list.label"/></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="authority" title="${message(code: 'regra.authority.label', default: 'Authority')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${regraInstanceList}" status="i" var="regraInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${regraInstance.id}">${fieldValue(bean: regraInstance, field: "authority")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${regraInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>