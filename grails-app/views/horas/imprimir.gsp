<%@ page import="controledehoras.Horas" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'horas.label', default: 'Horas')}" />
		<title><g:message code="hora.list.label" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	
	<g:if test="${flash.error}">
			<ul class="errors" role="alert">
				<g:eachError in="${flash.error}" var="error">
					<li>${error}</li>
				</g:eachError>
			</ul>
	</g:if>
	<g:else>
		<body class="impressao" onload="window.print()"> 
					
				<table class="impressao">
						<thead>
								<tr>
									<th colspan="13" class="esquerda">Horas do usuário ${usuarioInstance.buscaNome(usuarioInstance)} mês ${mes} de ${ano}</th>
								</tr>
								<tr>
								
									<th>${message(code: 'horas.dia.label')}</th>
								
									<th>${message(code: 'horas.entrada1.label')}</th>
								
									<th>${message(code: 'horas.saida1.label')}</th>
								
									<th>${message(code: 'horas.entrada2.label')}</th>
									
									<th>${message(code: 'horas.saida2.label')}</th>
									
									<th>${message(code: 'horas.saida3.label')}</th>
									
									<th>${message(code: 'horas.entrada3.label')}</th>
									
									<th>${message(code: 'horas.saida4.label')}</th>
									
									<th>${message(code: 'horas.entrada4.label')}</th>
									
									<th>${message(code: 'horas.saida5.label')}</th>
									
									<th>${message(code: 'horas.entrada5.label')}</th>
									
									<th>${message(code: 'horas.observacao.label')}</th>
									
									<th>${message(code: 'horas.totaldia.label')}</th>
	
								</tr>
							</thead>
							<tbody>
							<g:set var="total" value="${0}" />
							<g:each in="${horasInstanceList}" status="i" var="horasInstance">
								
								<tr>
								
									<td>${horasInstance.dia}</td>
							
									<td>${formatDate(format:"HH:mm" , date:horasInstance.entrada1)}</td>
								
									<td>${formatDate(format:"HH:mm" , date:horasInstance.saida1)}</td>
								
									<td>${formatDate(format:"HH:mm" , date:horasInstance.entrada2)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.saida2)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.saida3)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.entrada3)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.saida4)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.entrada4)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.saida5)}</td>
									
									<td>${formatDate(format:"HH:mm" , date:horasInstance.entrada5)}</td>
								    
								     <td>${horasInstance.observacao}</td>
								     
								    <td>${formatNumber(number:horasInstance.totaldia,maxFractionDigits:3 , minFractionDigits:3)}</td>
								    
								    							    
								</tr>
								<g:set var="total" value="${total + horasInstance.totaldia}" />
							</g:each>
							<tr>
								<td colspan="11"></td>
								<td>Total Mês</td>
								<td>
									${formatNumber(number:total,maxFractionDigits:3 , minFractionDigits:3)}
								</td>
							</tr>
							
							
							</tbody>
				</table>
				
				<div id="container" style="min-width: 310px; height: 200px; margin: 0 auto"></div>	
		</body>
	</g:else>
</html>