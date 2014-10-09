<%@ page import="controledehoras.Empresa" %>
<div class="fieldcontain ${hasErrors(bean: empresaInstance, field: 'razaosocial', 'error')} required">
	<label for="razaosocial">
		<g:message code="empresa.razaosocial.label" default="Razaosocial" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="razaosocial" required="" value="${empresaInstance?.razaosocial}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: empresaInstance, field: 'cnpj', 'error')} ">
	<label for="cnpj">
		<g:message code="empresa.cnpj.label" default="Cnpj" />
		
	</label>
	<g:textField name="cnpj" maxlength="14" value="${empresaInstance?.cnpj}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: empresaInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="empresa.imagem.label" default="Imagem" />
		
	</label>
	<input type="file" name="arquivo"/>
</div>

