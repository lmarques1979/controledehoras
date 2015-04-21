$(document).ready(function() {
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
});