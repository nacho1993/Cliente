<%@page import="ABM.ABM"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Connect.DBConnect"%>
<%@page import="Ecritores.Navbar"%>
<%@page import="Objetos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM Doctor</title>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
</head>
<body>
<div class="container">
<%= Navbar.impnbar(request)%>

<%-- <%= ABM.genABM(request, "ABMDoctor")%> --%>

<!--   <form class="form-horizontal" action="MDoctor" method="post"> -->
<!--   <input type="hidden" name="modo" value="alta"> -->
<!--   <div class="form-group"> -->
<!--     <label class="control-label col-sm-2">DNI:</label> -->
<!--     <div class="col-sm-10"> -->
<!--       <input type="text" class="form-control" name="DNI" placeholder="Documento doctor"> -->
<!--     </div> -->
<!--   </div> -->
<!--   <div class="form-group"> -->
<!--     <label class="control-label col-sm-2" >Nombre:</label> -->
<!--     <div class="col-sm-10"> -->
<!--       <input type="text" class="form-control" name="Nombre" placeholder="Nombre doctor"> -->
<!--     </div> -->
<!--   </div> -->
<!--   <div class="form-group"> -->
<!--     <label class="control-label col-sm-2">Apellido:</label> -->
<!--     <div class="col-sm-10"> -->
<!--       <input type="text" class="form-control" name="Apellido" placeholder="Apellido doctor"> -->
<!--     </div> -->
<!--   </div> -->
<!--   <div class="form-group"> -->
<!--     <label class="control-label col-sm-2">Consultorio </label> -->
<!--       <div class="select"> -->
<!--         <select name="Consultorio"> -->
<%-- <%--         <% for %> --%> 
<!--   			<option value="volvo">nasjd</option> -->
<!--   		</select> -->
<!--       </div> -->
<!--   </div> -->
<!--   <div class="form-group"> -->
<!--    <label class="control-label col-sm-2">Estado:</label> -->
<!--       <div class="checkbox"> -->
<!--         <select name="Estado"> -->
<!-- 			<option value="TRUE">Activo</option> -->
<!--   			<option value="FALSE">Inactivo</option> -->
<!--   		</select> -->
<!--     </div> -->
<!--   </div> -->
<!--   <div class="form-group"> -->
<!--     <div class="col-sm-offset-2 col-sm-10"> -->
<!--       <button type="submit" class="btn btn-default">Agregar</button> -->
<!--     </div> -->
<!--   </div> -->
<!-- </form>  -->
<form class="form-horizontal" action="MDoctor" method="post">
  <input type="hidden" name="modo" value="alta">
  
  <%    ArrayList<Tabla> tabarr = (ArrayList<Tabla>) request.getAttribute("tabarr");
		for(Tabla tabla : tabarr){
			String nomcam = tabla.getNomcam();
			String tipo = tabla.getTipo();
			
			switch (tipo) {
			
			case "INT":%>
			<div class="form-group">
				<label class="control-label col-sm-2"> <%=nomcam%>:</label>
				<div class="col-sm-10">
  					<input type="text" class="form-control" name="<%=nomcam%>">
				</div>
				</div>
			<%break;
			
			case "String":%>
				<div class="form-group">
    				<label class="control-label col-sm-2"> <%=nomcam%>:</label>
    				<div class="col-sm-10">
      					<input type="text" class="form-control" name="<%=nomcam%>">
    				</div>
  				</div>
			<%break;
				
			case "bool":
				if(nomcam.equals("Estado")){ %>
					<div class="form-group">
					   <label class="control-label col-sm-2">Estado:</label>
					      <div class="checkbox">
					        <select name="Estado">
								<option value="TRUE">Activo</option>
					  			<option value="FALSE">Inactivo</option>
					  		</select>
					    </div>
					  </div>
					
			<%	}
				break;

			default:
				break;
			}
		
		%>
  
  
  
  <%} %>
    
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Agregar</button>
    </div>
  </div>
</form> 

</div>
</body>
</html>