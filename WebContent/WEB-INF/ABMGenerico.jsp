<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="ABM.ABM"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Connect.DBConnect"%>
<%@page import="Ecritores.Navbar"%>
<%@page import="Estructura.*"%>
<%@page import="Objetos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="css/chosen.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<script>
$(document).ready(function() {
//     $("#FECHA").keyup(function(e){
//         if (e.keyCode != 8){    
// 	        if ($(this).val().length == 2){
// 	            $(this).val($(this).val() + "/");
// 	        }else if ($(this).val().length == 5){
// 	            $(this).val($(this).val() + "/");
// 	        }
//         }    
//     })

	 $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
	
// 	$('#formu').on('submit', function(e){
// 	var d;
// 	var m;
// 	var a;
// 	var valid = true;
	
// 	var temp = $("#FECHA").val().replace(/\//g,""); 
// 	d = temp.substring(0,2);
// 	m = temp.substring(2,4);
// 	a = temp.substring(4,8);
// 	var fven = a+m+d;//Fecha

	
// 		var date_input1=$('input[name="FECHA"]');
// 		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		
		
// 		date_input1.datepicker({			
// 			format: 'dd/mm/yyyy',
// 			container: container,
// 			todayHighlight: true,
// 			autoclose: true,
// 			orientation: 'top auto',
// 		})

    $("#ACCION").chosen().change(function(){
   	 $("#General").html('<div class="text-center"><i class="fa fa-refresh fa-spin" style="font-size:50px"></i></div>');    

   	 var accion = $("#ACCION").val();
   	 $.get("ABMServlet", {v1 : accion}, function(response2){
   		 $("#General").html(response2);
   	 })
	})
});
</script>




</head>
<body>
	<div class="container">
		<%= Navbar.impnbar(request)%>

		
		<div class="col-md-8 col-md-offset-4">
   		 <select name="ACCION" id="ACCION" class="chosen">
	    			 <option value="">Seleccionar accion</option> 
	    			 <option value="A">Alta</option> 
	    			 <option value="B">Baja</option> 
	    			 <option value="M">Modificacion</option> 
   		 </select>
   	 </div>
		<br><br><br>
		
		<div id=General>
		<%if(request.getAttribute("respuesta") != null){ %>
		<div class="alert alert-success"><span class="glyphicon glyphicon-thumbs-up"></span> <%= request.getAttribute("respuesta") %></div>
		<%} %>
		</div>
		 
	</div>
	 <script>

</script> 
</body>
</html>