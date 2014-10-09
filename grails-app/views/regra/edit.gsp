<%@ page import="seguranca.Regra" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regra.label', default: 'Regra')}" />
		<title><g:message code="edit.regra.label"/></title>
	</head>
	<body>
		<a href="#edit-regra" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="regra.list.label" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="regra.create.label" /></g:link></li>
			</ul>
		</div>
		<div id="edit-regra" class="content scaffold-edit" role="main">
			<h1><g:message code="edit.regra.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${regraInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${regraInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:regraInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${regraInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
