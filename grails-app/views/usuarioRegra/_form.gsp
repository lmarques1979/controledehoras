<%@ page import="seguranca.UsuarioRegra" %>



<div class="fieldcontain ${hasErrors(bean: usuarioRegraInstance, field: 'regra', 'error')} required">
	<label for="regra">
		<g:message code="usuarioRegra.regra.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:select id="regra" name="regra.id" from="${seguranca.Regra.list()}" optionKey="id" optionValue="authority" required="" value="${usuarioRegraInstance?.regra?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioRegraInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="usuarioRegra.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${seguranca.Usuario.list()}" optionKey="id" optionValue="username" required="" value="${usuarioRegraInstance?.usuario?.id}" class="many-to-one"/>

</div>

