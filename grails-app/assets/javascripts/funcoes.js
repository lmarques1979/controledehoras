$(document).ready(function(){
	
			var postData = $("#formupdate").serializeArray();
			var formURL =  '/controledehoras/horas/atualizatotal'; 
		  
		    $.ajax( 
		    {
		        url : formURL,
		        type: "POST",
		        data : postData,
		        dataType: "json",
		        success:function(data, textStatus, jqXHR)
		        {
		        	
		        	var total=0;
		            var i = 0;
		            var grafico = [];
		            var dias =[];
		            var totaldia=[];
		            while (i<data.horas.length) {
		        		var campo = "totaldia"+data.horas[i].id;
		        		var valor = data.horas[i].totaldia.toFixed(3).replace(".",",");
		        		var totaliza = data.horas[i].totaliza;
		        		
		        		if(totaliza=='1'){
    	        			document.getElementById(campo).value=valor;
    	        			total=total+data.horas[i].totaldia;
    	        			dias.push(data.horas[i].dia);
    		        		totaldia.push(data.horas[i].totaldia);
    	        		}else{
    	        			document.getElementById(campo).value=0;
    	        		}
		        		
		        		i++;
		        	}
		            
		            grafico['mes']  	= data.horas[0].mes;
	        		grafico['ano']  	= data.horas[0].ano;
	        		grafico['usuario']	= data.usuario;
		            grafico['dias']  	= dias;
		            grafico['totaldia'] = totaldia;
		            
		        	document.getElementById("totalgeral").value=total.toFixed(3).replace(".",",");
		        	mostraGrafico(grafico);
		        },
		        error: function(jqXHR, textStatus, errorThrown)
		        	{
		        	
			        	var i = 0;
			        	var errodiv='<ul class="errors" role="alert">';
			        	var mensagem='';
			        	var fechadiv="</div>"
			        	while (i<jqXHR.responseJSON.length) {
			        		mensagem = mensagem + '<li>' +  jqXHR.responseJSON[i] + '</li>'
			        		i++;
			        	}
			        	var htmlfinal= errodiv + mensagem + fechadiv;
			        	
			        	$('.ajaxmessage').html('');
			        	$('.ajaxerror').html('');
			        	$('.ajaxerror').html(htmlfinal);
		        	
		        	}
		});
	
		function mostraGrafico(grafico){
		
		    	$('#container').highcharts({
		    		chart: {
		    			type: 'line',
		    			backgroundColor: '#fbf5ef'
		        },
		        title: {
		            text: 'Horas do Mes ' + grafico['mes'] + ' de ' + grafico['ano'] + ' (' + document.getElementById("totalgeral").value + ')',
		            margin:50
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: grafico['dias'],
		            title: {
		                text: 'Dia do Mes'
		            }
		        },
		        yAxis: {
		            title: {
		                text: 'Quantidade Horas (dia)'
		            },
		            gridLineWidth:0,
		            tickInterval: 0.1
		        },
		        plotOptions: {
		            line: {
		                dataLabels: {
		                    enabled: true
		                },
		                enableMouseTracking: false
		            }
		        },
		        series: [{
		            name: grafico['usuario'],
		            data: grafico['totaldia'],
		            dataLabels: {
		                enabled: true,
		                rotation: -90,
		                color: '#000',
		                align: 'top',
		                x: 4,
		                y: -10,
		                style: {
		                    fontSize: '11px',
		                    fontFamily: 'Verdana, sans-serif',
		                    textShadow: '0 0 3px #fff'
		                	}
		            	}
		        	}]
		    	});
		 }
	
		//Quando clica no checkbox de totalizar
		$(".totaliza").click(function(){
			
			var valorid = $(this).attr('data-idfoto');
			var campo = "#totalizahidden" + valorid;
			var $hidden=$(this).closest("tr").find(campo);
						
			if($(this).is(':checked')){
				$hidden.val("1");
			}else{
				$hidden.val("0");
			}
			atualizaCampo();
		});
	
		//Função que é chamada após o click do checkbox de totalizar
		function atualizaCampo(){
		
			var formURL  = $("#formupdate").attr("action"); 
			trataDadosTela(formURL);
		    
		};
	
		//Quando clica no Salvar do Formulário de Update
		$("#formupdatesubmit").click(function(e){
			
			var formURL  = $("#formupdate").attr("action"); 
			trataDadosTela(formURL, e);
	  	});
	
		//Quando sai (mudar de campo) de um dos campos de hora
		$(".timeentry").blur(function(e){
	    	
	    	var formURL =  '/controledehoras/horas/atualizatotal'; 
	    	trataDadosTela(formURL , e);
	  });
	   
	  //Atualiza os dados da Tela, totais, gráfico, total dia, etc.
	  function trataDadosTela(action, e){
		  
		    var postData = $("#formupdate").serializeArray();
		    var formURL  = action; 
		  
		    $.ajax(
		    {
		        url : formURL,
		        type: "POST",
		        data : postData,
		        dataType: "json",
		        success:function(data, textStatus, jqXHR)
		        {
		        	
		        	var total=0;
		            var i = 0;
		            var grafico = [];
		            var dias =[];
		            var totaldia=[];
		            
		            while (i<data.horas.length) {
		        		var campo = "totaldia"+data.horas[i].id;
		        		var valor = data.horas[i].totaldia.toFixed(3).replace(".",",");
		        		var totaliza = data.horas[i].totaliza;
		        		
  	        		if(totaliza=='1'){
  	        			document.getElementById(campo).value=valor;
  	        			total=total+data.horas[i].totaldia;
  	        			dias.push(data.horas[i].dia);
  		        		totaldia.push(data.horas[i].totaldia);
  		        		
  	        		}else{
  	        			document.getElementById(campo).value='0,000';
  	        		}
		        		i++;
		        	}
		            grafico['mes']  	= data.horas[0].mes;
	        		grafico['ano']  	= data.horas[0].ano;
	        		grafico['usuario']	= data.usuario;
		            grafico['dias']  	= dias;
		            grafico['totaldia'] = totaldia;
		        	document.getElementById("totalgeral").value=total.toFixed(3).replace(".",",");
		        	if(action!=='/controledehoras/horas/atualizatotal'){
		        		var sucessodiv = '<div class="message" role="status">Horario Salvo</div>'; 
		        	}
	                $('.ajaxmessage').html('');
		        	$('.ajaxerror').html('');
		        	$('.ajaxmessage').html(sucessodiv);
	                mostraGrafico(grafico);
		        },
		        error: function(jqXHR, textStatus, errorThrown)
		        {
		        	
		        	var i = 0;
		        	var errodiv='<ul class="errors" role="alert">';
		        	var mensagem='';
		        	var fechadiv="</div>"
		        	while (i<jqXHR.responseJSON.length) {
		        		mensagem = mensagem + '<li>' +  jqXHR.responseJSON[i] + '</li>'
		        		i++;
		        	}
		        	var htmlfinal= errodiv + mensagem + fechadiv;
		        	$('.ajaxmessage').html('');
		        	$('.ajaxerror').html('');
		        	$('.ajaxerror').html(htmlfinal);
		        	
		        }
		    });
	    	e.preventDefault(); //STOP default action
	  }
});