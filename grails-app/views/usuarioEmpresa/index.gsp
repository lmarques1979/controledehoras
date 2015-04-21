
<%@ page import="controledehoras.UsuarioEmpresa" %>
<g:if test="${params.ativa}">
	<g:set var="ativa" value="${params.ativa}" />
</g:if>
<g:else>
	<g:set var="ativa" value="A" />
</g:else>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarioEmpresa.label', default: 'UsuarioEmpresa')}" />
		<title><g:message code="empresalist.label"/></title>
		<asset:javascript src="grafico.js"/>
		
	</head>
	<body>
	
		<a href="#list-usuarioEmpresa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-usuarioEmpresa" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<div class="ativa"> 
				<g:form url="[resource:usuarioEmpresaInstance, action:'index']" >
					
					<g:select onchange="this.form.submit()" value="${ativa}" name="ativa" from="${[message(code:'ativa.label'),message(code:'inativa.label'),message(code:'todos.label')]}" keys="${['A','I','T']}"/>
					
				</g:form>				
			</div><div class="clearer"></div> 
			
			<div class="usuarioEmpresa">
			
				<g:each in="${usuarioEmpresaInstanceList}" status="i" var="usuarioEmpresaInstance">
					<g:if test="${usuarioEmpresaInstance?.empresa}">
					
							
							<g:link controller="UsuarioEmpresa" action="escolheempresausuario" id="${usuarioEmpresaInstance?.id}">
								<g:if test="${usuarioEmpresaInstance?.empresa?.imagem}">
									<asset:image height="50" width="200" src="${usuarioEmpresaInstance?.empresa?.imagem}" title="${usuarioEmpresaInstance?.empresa?.razaosocial}"/><br>
								</g:if>
								<g:else>
									<asset:image height="50" width="200" src="/skin/noimage.jpg" title="${usuarioEmpresaInstance?.empresa?.razaosocial}"/><br>
								</g:else>
								${usuarioEmpresaInstance?.empresa?.razaosocial} 
							</g:link><div class="clearer"></div>
							
							<div class="edicao">
								<g:link controller="empresa" action="edit" resource="${usuarioEmpresaInstance?.empresa}">
										<asset:image src="skin/edit.png"/>
								</g:link>
								<g:form controller="empresa" action="delete" method="DELETE">
									<g:hiddenField name="id" value="${usuarioEmpresaInstance?.empresa?.id}" />
									<g:actionSubmitImage class="semborda" controller="empresa" action="delete" value="${message(code: 'button.delete.label')}" title="${message(code: 'button.delete.label')}" src="${assetPath(src:'skin/remove.png')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
								</g:form>
							</div><div class="clearer"></div>
					</g:if>
				</g:each>

			</div>
			
			<g:if test="${usuarioEmpresaInstanceCount > params.max}">
				<div class="pagination">
					<g:paginate total="${usuarioEmpresaInstanceCount ?: 0}" />
				</div>
			</g:if>
		</div>
	</body>
</html>
