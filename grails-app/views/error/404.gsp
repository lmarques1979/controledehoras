<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'palpite.label', default: 'Palpite')}" />
		<title><g:message code="error.404.message"/></title>
	</head>
	<body>

		<a href="#list-palpite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-palpite" class="content scaffold-list" role="main">
			<g:if test="${flash.erros}">
				<ul class="errors" role="alert">
					<g:each in="${flash.erros}" status="i" var="erro">
						<li>${erro}</li>
					</g:each>
				</ul>
			</g:if>
		</div>
	</body>
</html>

