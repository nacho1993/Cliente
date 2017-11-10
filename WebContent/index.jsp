<%@page import="java.sql.Connection"%>
<%@page import="Connect.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<title>log</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron fondo">
			<h1>Clinica de Ortopedia Rosario</h1>
			<p>Lider en inovacion</p>
		</div>
			<%
			if (request.getSession().getAttribute("user") != null) {
				request.getRequestDispatcher("/menu.jsp");
			}
		%>
		<div class="col-md-4 col-md-offset-4 formulario">
			<%
				if (request.getAttribute("error") != null) {
			%>
			</br>
			<div class="alert alert-danger">Usuario o contraseña incorrecta</div>
			<%
				}
			%>
			</br>
			<form action="WebServ2" method="post">
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="email"
						type="text" class="form-control" name="usr" placeholder="Usuario">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="password"
						type="password" class="form-control" name="pwd"
						placeholder="Password">
				</div>
				<br>
				<div>
					<button type="submit" class="btn ">Ingresar</button>
					<button type="reset" class="btn ">Blanquear</button>
				</div>
			</form>
			</br>
		</div>
	</div>

</body>
</html>