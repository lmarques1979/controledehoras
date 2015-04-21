
<%@ page import="controledehoras.Empresa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'empresa.label', default: 'Empresa')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-empresa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-empresa" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list empresa">
			
				<g:if test="${empresaInstance?.razaosocial}">
				<li class="fieldcontain">
					<span id="razaosocial-label" class="property-label"><g:message code="empresa.razaosocial.label" default="Razaosocial" /></span>
					
						<span class="property-value" aria-labelledby="razaosocial-label"><g:fieldValue bean="${empresaInstance}" field="razaosocial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${empresaInstance?.cnpj}">
				<li class="fieldcontain">
					<span id="cnpj-label" class="property-label"><g:message code="empresa.cnpj.label" default="Cnpj" /></span>
					
						<span class="property-value" aria-labelledby="cnpj-label"><g:fieldValue bean="${empresaInstance}" field="cnpj"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${empresaInstance?.imagem}">
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label"><g:message code="empresa.imagem.label" default="Imagem" /></span>
					
					<span class="property-value" aria-labelledby="imagem-label">
						<asset:image height="50" width="200" src="${empresaInstance?.imagem}" title="${empresaInstance?.razaosocial}"/>
					</span>
					
				</li>
				</g:if>
				
				<g:if test="${empresaInstance?.ativa}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="empresa.ativa.label" default="Ativa" /></span>
					<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${empresaInstance?.ativa}" /></span>
					
				</li>
				</g:if>
				
			
			</ol>
			<g:form url="[resource:empresaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${empresaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
