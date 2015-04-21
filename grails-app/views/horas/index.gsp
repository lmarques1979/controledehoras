<%@ page import="controledehoras.Horas" %>
<g:if test="${params.filtromes}">
	<g:set var="mes" value="${params.int('filtromes')}" />
</g:if>
<g:else>
	<g:set var="mes" value="${formatDate(format:"MM" , date:new Date()).toInteger()}" />
</g:else>
<g:if test="${params.filtroano}">
	<g:set var="ano" value="${params.int('filtroano')}" />
</g:if>
<g:else>
	<g:set var="ano" value="${formatDate(format:"yyyy" , date:new Date()).toInteger()}" />
</g:else>

<g:set var="diahoje" value="${formatDate(format:"dd" , date:new Date())}" />
<g:set var="meshoje" value="${formatDate(format:"MM" , date:new Date())}" />

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'horas.label', default: 'Horas')}" />
		<title><g:message code="hora.list.label" /></title>
		<asset:stylesheet src="jquery.timeentry.css"/>
		<asset:javascript src="jquery.timeentry.js"/>
		<asset:javascript src="spinner_init.js"/>
		<asset:javascript src="highcharts/modules/exporting.js"/>
		<asset:javascript src="highcharts/highcharts.js"/>
		<asset:javascript src="grafico.js"/> 
		<asset:javascript src="funcoes.js"/> 
		<script type="text/javascript">
			$(document).ready(function() {
			   carregaTela(); 
			});
		</script>
				
	</head>
	<body>
		
		<a href="#list-horas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="list-horas" class="content scaffold-list" role="main">
		
			<h1><g:message code="hora.list.label"/></h1>
			
			
			<g:if test="${flash.message}">
				<div class="message" role="status">
					${flash.message}
				</div>
			</g:if>
			
			<g:if test="${flash.error}">
				<ul class="errors" role="alert">
					<g:eachError in="${flash.error}" var="error">
						<li>${error}</li>
					</g:eachError>
				</ul>
			</g:if>
			<div class="filtro"> 
			<g:form url="[resource:horasInstance, action:'index']" >
				<g:select onchange="this.form.submit()" value="${mes}" name="filtromes" from="${['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho' , 'Agosto' , 'Setembro' , 'Outubro' , 'Novembro' , 'Dezembro']}" keys="${['1','2','3','4','5','6','7','8','9','10','11','12']}"/>
				<g:field onchange="this.form.submit()" class="ano" min="2000" name="filtroano" value="${ano}" type="number"/>
			</g:form>				
			</div><div class="clearer"></div>
			<g:form url="[resource:horasInstance, action:'save']" > 
				<g:hiddenField name="mes" value="${mes}" />
				<g:hiddenField name="ano" value="${ano}" />
				<g:hiddenField name="totaliza" value="1" />
				<g:hiddenField name="usuarioempresa" value="${session["usuarioempresa"].id}" />
				
				<table>
					<thead>
							<tr>
								<th colspan="12" class="esquerda">${message(code: 'horas.inclusao.label')}</th>
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
								
																
							
							</tr>
						</thead>
						<tbody>
						
						<tr>
							
							<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${formatDate(format:"dd" , date:new Date())}" type="number" required=""/></td>
						
							<td><g:textField name="entrada1" size="4" maxlength="5" class="timeentry"/></td>
						
							<td><g:textField name="saida1" size="4" maxlength="5" class="timeentry"/></td>
						
							<td><g:textField name="entrada2" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="saida2" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="saida3" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="entrada3" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="saida4" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="entrada4" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="saida5" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="entrada5" size="4" maxlength="5" class="timeentry"/></td>
							
							<td><g:textField name="observacao" size="10"/></td>
							
							
						</tr>
			
						<tr>
							<td colspan="12">
								<g:submitButton name="create" class="save" value="${message(code: 'button.create.label', default: 'Create')}" />
							</td>
						</tr>
						</tbody>
					</table>
				</g:form>
				<div class="menuacoes">
				
					<g:link controller="horas" action="gerarmes" params="${[mes:mes, ano:ano,usuarioempresa:session['usuarioempresa'].id]}">
						<asset:image src="skin/gerarmes.png" title="${message(code: 'horas.gerarmes.label')}"/>
					</g:link>
					<g:link controller="horas" target="_blank" action="imprimir" params="${[mes:mes, ano:ano, usuarioempresa:session['usuarioempresa'].id]}">
						<asset:image src="skin/imprimir.png" title="${message(code: 'horas.imprimir.label')}"/>
					</g:link>
					
					<g:link controller="horas" action="enviarpdfemail" params="${[mes:mes, ano:ano, usuarioempresa:session['usuarioempresa'].id]}">
						<asset:image src="skin/email.png" title="${message(code: 'horas.email.label')}"/>
					</g:link>
					
					<!--<asset:image id="grafico" src="skin/grafico.png" title="${message(code: 'horas.grafico.label')}"/>
					-->
								
				</div><div class="clearer"></div>
				<div class="ajaxmessage"></div>
				<div class="ajaxerror"></div>
				<g:form id="formupdate" url="[resource:horasInstance, action:'update']" >
					<table id="update">
					<thead>
							<tr>
								<th colspan="15" class="esquerda">${message(code: 'horas.edicao.label')}</th>
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
								
								<th>${message(code: 'horas.totaliza.label')}</th>
								
								<th>${message(code: 'horas.totaldia.label')}</th>
								
								<th></th>
							</tr>
						</thead>
						<tbody>
						<g:set var="total" value="${0}" />
						<g:each in="${horasInstanceList}" status="i" var="horasInstance">
						
							<g:hiddenField name="idalteracao" value="${horasInstance.id}" />
							<g:hiddenField name="mes" value="${horasInstance.mes}" />
							<g:hiddenField name="ano" value="${horasInstance.ano}" />
							<g:hiddenField name="usuarioempresa" value="${horasInstance.usuarioempresa.id}" />
							
							<tr class="${horasInstance.dia == diahoje.toInteger() && horasInstance.mes == meshoje.toInteger() ? 'diahoje' : ''}">
							
								<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${horasInstance.dia}" type="number" required=""/></td>
						
								<td><g:textField name="entrada1" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.entrada1)}"/></td>
							
								<td><g:textField name="saida1" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.saida1)}"/></td>
							
								<td><g:textField name="entrada2" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.entrada2)}"/></td>
								
								<td><g:textField name="saida2" size="4" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.saida2)}"/></td>
								
								<td><g:textField name="saida3" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.saida3)}"/></td>
								
								<td><g:textField name="entrada3" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.entrada3)}"/></td>
								
								<td><g:textField name="saida4" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.saida4)}"/></td>
								
								<td><g:textField name="entrada4" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.entrada4)}"/></td>
								
								<td><g:textField name="saida5" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.saida5)}"/></td>
								
								<td><g:textField name="entrada5" size="4" maxlength="5" class="timeentry" value="${formatDate(format:"HH:mm" , date:horasInstance.entrada5)}"/></td>
							    
							    <td>
							    	<g:textField class="centro" name="observacao" size="10" value="${horasInstance.observacao}"/>
							    </td>
							    
							    <td>
							    	<g:hiddenField name="totalizahidden" id="totalizahidden${horasInstance.id}" value="${horasInstance.totaliza}" />
							    	<g:checkBox data-idfoto="${horasInstance.id}" class="totaliza" name="totaliza" value="${horasInstance.totaliza}"/>
							    </td>
							    
							    <td>
							    	<g:if test="${horasInstance.totaldia < 8}">
										<g:textField class="centrovermelho" name="totaldia" id="totaldia${horasInstance.id}" size="4" value="${formatNumber(number:horasInstance.totaldia,maxFractionDigits:3 , minFractionDigits:3)}" readonly="readonly" /></td>
							        </g:if>
									<g:else>
										<g:textField class="centro" name="totaldia" id="totaldia${horasInstance.id}" size="4" value="${formatNumber(number:horasInstance.totaldia,maxFractionDigits:3 , minFractionDigits:3)}" readonly="readonly" /></td>
							        </g:else>
							    	
							    
							    <td>
							    	<g:form controller="horas" action="delete">
										<g:hiddenField name="id" value="${horasInstance?.id}" />
										<g:hiddenField name="mes" value="${mes}" />
										<g:hiddenField name="ano" value="${ano}" />
										<g:actionSubmitImage id="submitimage" class="tabela" controller="horas" action="delete" value="${message(code: 'button.delete.label')}" title="${message(code: 'button.delete.label')}" src="${assetPath(src:'skin/remove.png')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
										<div class="clearer"></div>
									</g:form>
							    </td><div class="clearer"></div>
							    
							</tr>
							<g:if test="${horasInstance.totaliza}">
								<g:set var="total" value="${total + horasInstance.totaldia}" />
							</g:if>
							
						</g:each>
						<tr>
							<td colspan="13"></td>
							<td class="total">
								<g:textField class="total" name="totalgeral" id="totalgeral" size="6" value="${formatNumber(number:total,maxFractionDigits:3 , minFractionDigits:3)}" readonly="readonly" />
							</td>
							<td></td>
						</tr>
						
						<tr>
							<td colspan="15">
								<g:submitButton id="formupdatesubmit"  name="create" class="save" value="${message(code: 'button.create.label', default: 'Create')}" />
							</td>
						</tr>
						</tbody>
					</table>
				</g:form>
			
		</div>
				
		<div id="container" style="min-width: 310px; height: 300px; margin: 0 auto"></div>	
	
	</body>

</html>