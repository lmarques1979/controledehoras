$(document).ready(function(){
	
	/*$("#grafico").click(function(){*/
		
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
		            while (i<data.dias.length) {
		        		var campo = "totaldia"+data.dias[i];
		        		var valor = data.totaldia[i].toFixed(3).replace(".",",");
		        	    document.getElementById(campo).value=valor;
		        		total=total+data.totaldia[i];
		        		i++;
		        	}
		        	document.getElementById("totalgeral").value=total.toFixed(3).replace(".",",");
		        	mostraGrafico(data);
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
	/*});*/	

	function mostraGrafico(data){
		
		 $('#container').highcharts({
		        chart: {
		            type: 'line',
		            backgroundColor: '#fbf5ef'
		        },
		        title: {
		            text: 'Horas do Mes ' + data.mes + ' de ' + data.ano + ' (' + document.getElementById("totalgeral").value + ')',
		            margin:50
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: data.dias,
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
		            name: data.usuario,
		            data: data.totaldia,
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
	
	$(".totaliza").click(function(){
			
			var $hidden=$(this).closest("tr").find("#totalizahidden");
	
			if($(this).is(':checked')){
				$hidden.val("1");
			}else{
				$hidden.val("0");
			}
			
			var postData = $("#formupdate").serializeArray();
			var formURL  = $("#formupdate").attr("action");  
			
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
		    	            while (i<data.dias.length) {
		    	        		var campo = "totaldia"+data.dias[i];
		    	        		var valor = data.totaldia[i].toFixed(3).replace(".",",");
		    	        	    document.getElementById(campo).value=valor;
		    	        		total=total+data.totaldia[i];
		    	        		i++;
		    	        	}
		    	        	document.getElementById("totalgeral").value=total.toFixed(3).replace(".",",");
		                    var sucessodiv = '<div class="message" role="status">Horario Salvo</div>'; 
		                   
		                    $('.ajaxmessage').html('');
		    	        	$('.ajaxerror').html('');
		                    $('.ajaxmessage').html(sucessodiv);
		                    mostraGrafico(data);
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
		    
		});
	
		$("#formupdatesubmit").click(function(e){
		    var postData = $("#formupdate").serializeArray();
		    var formURL = $("#formupdate").attr("action"); 
		  
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
		            while (i<data.dias.length) {
		        		var campo = "totaldia"+data.dias[i];
		        		var valor = data.totaldia[i].toFixed(3).replace(".",",");
		        	    document.getElementById(campo).value=valor;
		        		total=total+data.totaldia[i];
		        		i++;
		        	}
		        	document.getElementById("totalgeral").value=total.toFixed(3).replace(".",",");
	                var sucessodiv = '<div class="message" role="status">Horario Salvo</div>'; 
	               
	                $('.ajaxmessage').html('');
		        	$('.ajaxerror').html('');
	                $('.ajaxmessage').html(sucessodiv);
	                mostraGrafico(data);
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
	  	});
	
	    $(".timeentry").blur(function(e){
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
	            while (i<data.dias.length) {
	        		var campo = "totaldia"+data.dias[i];
	        		var valor = data.totaldia[i].toFixed(3).replace(".",",");
	        	    document.getElementById(campo).value=valor;
	        		total=total+data.totaldia[i];
	        		i++;
	        	}
	        	document.getElementById("totalgeral").value=total.toFixed(3).replace(".",",");
	        	mostraGrafico(data);
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
	  });
});