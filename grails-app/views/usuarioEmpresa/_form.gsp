<%@ page import="controledehoras.UsuarioEmpresa" %>



<div class="fieldcontain ${hasErrors(bean: usuarioEmpresaInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="usuarioEmpresa.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${seguranca.Usuario.list()}" optionKey="id" required="" value="${usuarioEmpresaInstance?.usuario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioEmpresaInstance, field: 'empresa', 'error')} required">
	<label for="empresa">
		<g:message code="usuarioEmpresa.empresa.label" default="Empresa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="empresa" name="empresa.id" from="${controledehoras.Empresa.list()}" optionKey="id" required="" value="${usuarioEmpresaInstance?.empresa?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioEmpresaInstance, field: 'horas', 'error')} ">
	<label for="horas">
		<g:message code="usuarioEmpresa.horas.label" default="Horas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${usuarioEmpresaInstance?.horas?}" var="h">
    <li><g:link controller="horas" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="horas" action="create" params="['usuarioEmpresa.id': usuarioEmpresaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'horas.label', default: 'Horas')])}</g:link>
</li>
</ul>


</div>

