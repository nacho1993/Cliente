<%@page import="login.Usuario"%>
<%@page import="Connect.DBConnect"%>
<%@page import="login.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Ecritores.Navbar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"  />
<link rel="stylesheet" type="text/css" href="css/estilo.css"  />
<title>menu</title>
</head>
<body>
<div class="container">
<%= Navbar.impnbar(request) %>
</div>
</body>
</html>