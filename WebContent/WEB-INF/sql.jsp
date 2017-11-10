<%@page import="java.util.ArrayList"%>
<%@page import="login.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Ecritores.Navbar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<title>sql results</title>
</head>
<body>
<div class="container">
	<%=Navbar.impnbar(request)%>
	<div class="col-md-10 col-offset-md-1">
	<input class="form-control" id="myInput" type="text" placeholder="Search..">
	<table class="table table-condensed table-bordered" id="myTable">
	<tr>
		<th>Usuario</th>
		<th>Contraseña</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Mail</th>
		<th>Estado</th>
	</tr>
	
	<%
	ArrayList<Usuario> usu = (ArrayList<Usuario>) request.getSession().getAttribute("usu") ;
		for(Usuario usuario : usu){ %>
		<tr>	
			<td><%= usuario.getUsuario()  %></td>
			<td><%= usuario.getPassword()  %></td>
			<td><%= usuario.getNombre()  %></td>
			<td><%= usuario.getApellido()  %></td>
			<td><%= usuario.getEmail()  %></td>
			<% if (usuario.isEstado()){ %>
			<td>Habilitado</td>
			<%}else{ %>
			<td>Deshabilitado</td>
			<%} %>
		</tr>			
	<% } %>
	</table>
	</div>
	</div>

 <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script> 
</body>

</html>