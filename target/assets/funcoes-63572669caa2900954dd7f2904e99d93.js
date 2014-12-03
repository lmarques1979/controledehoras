$(document).ready(function(){function t(e){$("#container").highcharts({chart:{type:"line",backgroundColor:"#fbf5ef"},title:{text:"Horas do Mes "+e["mes"]+" de "+e["ano"]+" ("+document.getElementById("totalgeral").value+")",margin:50},subtitle:{text:""},xAxis:{categories:e["dias"],title:{text:"Dia do Mes"}},yAxis:{title:{text:"Quantidade Horas (dia)"},gridLineWidth:0,tickInterval:.1},plotOptions:{line:{dataLabels:{enabled:true},enableMouseTracking:false}},series:[{name:e["usuario"],data:e["totaldia"],dataLabels:{enabled:true,rotation:-90,color:"#000",align:"top",x:4,y:-10,style:{fontSize:"11px",fontFamily:"Verdana, sans-serif",textShadow:"0 0 3px #fff"}}}]})}function i(){var n=$("#formupdate").serializeArray();var r=$("#formupdate").attr("action");$.ajax({url:r,type:"POST",data:n,dataType:"json",success:function(e,n,r){var i=0;var s=0;var o=[];var u=[];var a=[];while(s<e.horas.length){var f="totaldia"+e.horas[s].id;var l=e.horas[s].totaldia.toFixed(3).replace(".",",");var c=e.horas[s].totaliza;var h="#totalizahidden"+e.horas[s].id;var c=e.horas[s].totaliza;if(c=="1"){document.getElementById(f).value=l;i=i+e.horas[s].totaldia;u.push(e.horas[s].dia);a.push(e.horas[s].totaldia)}else{document.getElementById(f).value="0,000"}s++}o["mes"]=e.horas[0].mes;o["ano"]=e.horas[0].ano;o["usuario"]=e.usuario;o["dias"]=u;o["totaldia"]=a;document.getElementById("totalgeral").value=i.toFixed(3).replace(".",",");var p='<div class="message" role="status">Horario Salvo</div>';$(".ajaxmessage").html("");$(".ajaxerror").html("");$(".ajaxmessage").html(p);t(o)},error:function(e,t,n){var r=0;var i='<ul class="errors" role="alert">';var s="";var o="</div>";while(r<e.responseJSON.length){s=s+"<li>"+e.responseJSON[r]+"</li>";r++}var u=i+s+o;$(".ajaxmessage").html("");$(".ajaxerror").html("");$(".ajaxerror").html(u)}});e.preventDefault()}var n=$("#formupdate").serializeArray();var r="/controledehoras/horas/atualizatotal";$.ajax({url:r,type:"POST",data:n,dataType:"json",success:function(e,n,r){var i=0;var s=0;var o=[];var u=[];var a=[];while(s<e.horas.length){var f="totaldia"+e.horas[s].id;var l=e.horas[s].totaldia.toFixed(3).replace(".",",");var c=e.horas[s].totaliza;u.push(e.horas[s].dia);a.push(e.horas[s].totaldia);if(c=="1"){document.getElementById(f).value=l}else{document.getElementById(f).value=0}i=i+e.horas[s].totaldia;s++}o["mes"]=e.horas[0].mes;o["ano"]=e.horas[0].ano;o["usuario"]=e.usuario;o["dias"]=u;o["totaldia"]=a;document.getElementById("totalgeral").value=i.toFixed(3).replace(".",",");t(o)},error:function(e,t,n){var r=0;var i='<ul class="errors" role="alert">';var s="";var o="</div>";while(r<e.responseJSON.length){s=s+"<li>"+e.responseJSON[r]+"</li>";r++}var u=i+s+o;$(".ajaxmessage").html("");$(".ajaxerror").html("");$(".ajaxerror").html(u)}});$(".totaliza").click(function(){var e=$(this).attr("data-idfoto");var t="#totalizahidden"+e;var n=$(this).closest("tr").find(t);if($(this).is(":checked")){n.val("1")}else{n.val("0")}i()});$("#formupdatesubmit").click(function(e){var n=$("#formupdate").serializeArray();var r=$("#formupdate").attr("action");$.ajax({url:r,type:"POST",data:n,dataType:"json",success:function(e,n,r){var i=0;var s=0;var o=[];var u=[];var a=[];while(s<e.dias.length){var f="totaldia"+e.horas[s].id;var l=e.horas[s].totaldia.toFixed(3).replace(".",",");var c=e.horas[s].totaliza;if(c=="1"){document.getElementById(f).value=l;i=i+e.horas[s].totaldia;u.push(e.horas[s].dia);a.push(e.horas[s].totaldia)}else{document.getElementById(f).value="0,000"}s++}o["mes"]=e.horas[0].mes;o["ano"]=e.horas[0].ano;o["usuario"]=e.usuario;o["dias"]=u;o["totaldia"]=a;document.getElementById("totalgeral").value=i.toFixed(3).replace(".",",");var h='<div class="message" role="status">Horario Salvo</div>';$(".ajaxmessage").html("");$(".ajaxerror").html("");$(".ajaxmessage").html(h);t(o)},error:function(e,t,n){var r=0;var i='<ul class="errors" role="alert">';var s="";var o="</div>";while(r<e.responseJSON.length){s=s+"<li>"+e.responseJSON[r]+"</li>";r++}var u=i+s+o;$(".ajaxmessage").html("");$(".ajaxerror").html("");$(".ajaxerror").html(u)}});e.preventDefault()});$(".timeentry").blur(function(e){var n=$("#formupdate").serializeArray();var r="/controledehoras/horas/atualizatotal";$.ajax({url:r,type:"POST",data:n,dataType:"json",success:function(e,n,r){var i=0;var s=0;var o=[];var u=[];var a=[];while(s<e.horas.length){var f="totaldia"+e.horas[s].id;var l=e.horas[s].totaldia.toFixed(3).replace(".",",");var c=e.horas[s].totaliza;if(c=="1"){document.getElementById(f).value=l;i=i+e.horas[s].totaldia;u.push(e.horas[s].dia);a.push(e.horas[s].totaldia)}else{document.getElementById(f).value="0,000"}s++}o["mes"]=e.horas[0].mes;o["ano"]=e.horas[0].ano;o["usuario"]=e.usuario;o["dias"]=u;o["totaldia"]=a;document.getElementById("totalgeral").value=i.toFixed(3).replace(".",",");t(o)},error:function(e,t,n){var r=0;var i='<ul class="errors" role="alert">';var s="";var o="</div>";while(r<e.responseJSON.length){s=s+"<li>"+e.responseJSON[r]+"</li>";r++}var u=i+s+o;$(".ajaxmessage").html("");$(".ajaxerror").html("");$(".ajaxerror").html(u)}});e.preventDefault()})})