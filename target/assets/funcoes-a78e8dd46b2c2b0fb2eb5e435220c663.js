$(document).ready(function(){$(".totaliza").click(function(){var e=$(this).attr("data-idfoto");var t="#totalizahidden"+e;var n=$(this).closest("tr").find(t);if($(this).is(":checked")){n.val("1")}else{n.val("0")}atualizaCampo()});$("#formupdatesubmit").click(function(e){var t=$("#formupdate").attr("action");trataDadosTela(t,e)});$(".timeentry").blur(function(e){var t="/controledehoras/horas/atualizatotal";trataDadosTela(t,e)})})