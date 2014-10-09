<%@ page import="controledehoras.Configuracao" %>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'alturaimagens', 'error')} required">
	<label for="alturaimagens">
		<g:message code="configuracao.alturaimagens.label" default="Altura Imagens" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="alturaimagens" required="" value="${configuracaoInstance?.alturaimagens}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error')} required">
	<label for="larguraimagens">
		<g:message code="configuracao.larguraimagens.label" default="Largura Imagens" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="larguraimagens" required="" value="${configuracaoInstance?.larguraimagens}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'alturaimagensthumbs', 'error')}">
	<label for="alturaimagensthumbs">
		<g:message code="configuracao.alturaimagensthumbs.label" default="Altura Imagens Thumb" />
	</label>
	<g:textField name="alturaimagensthumbs" required="" value="${configuracaoInstance?.alturaimagensthumbs}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'larguraimagensthumbs', 'error')}">
	<label for="larguraimagensthumbs">
		<g:message code="configuracao.larguraimagensthumbs.label" default="Largura Imagens Thumb" />
	</label>
	<g:textField name="larguraimagensthumbs" required="" value="${configuracaoInstance?.larguraimagensthumbs}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error')} required">
	<label for="tamanhoiconetimes">
		<g:message code="configuracao.itensporpagina.label" default="Itens por Página" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="itensporpagina" required="" value="${configuracaoInstance?.itensporpagina}"/>

</div>

<input type='hidden' name='usuario' value="${sec.loggedInUserInfo(field: 'id')}"/>