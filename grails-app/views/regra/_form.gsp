<%@ page import="seguranca.Regra" %>

<div class="fieldcontain ${hasErrors(bean: regraInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="regra.authority.label" default="Regra" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="authority" required="" value="${regraInstance?.authority}"/>

</div>

