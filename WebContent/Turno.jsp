<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Ecritores.Navbar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />

<title>Turnos</title>

</head>
<body>
<div class="container">
<%= Navbar.impnbar(request) %>

	<!-- vercion tabla -->

	<!-- <div class="col-md-2 col-md-offset-2"> -->
	<!-- <input class="form-control" id="myInput" type="text" placeholder="Search.."> -->
	<!-- <form action=""> -->
	<!-- <table class="table table-condensed table-bordered" id="myTable"> -->
	<!-- <thead> -->
	<!-- 	<tr> -->
	<!-- 		<td class="col-md-1"></td> -->
	<!-- 		<td> doctor </td> -->
	<!-- 	</tr> -->
	<!-- </thead> -->
	<!-- <tbody> -->
	<!-- 	<tr> -->
	<!-- 		<td><input type="checkbox" name="doctor" value="na"></td> -->
	<!-- 		<td><span>nacho</span> </td>  -->
	<!-- 	</tr> -->
	<!-- 	<tr> -->
	<!-- 		<td><input type="checkbox" name="doctor" value="pa"></td> -->
	<!-- 		<td><span>pablo</span> </td>  -->
	<!-- 	</tr> -->
	<!-- 		<tr> -->
	<!-- 		<td><input type="checkbox" name="doctor" value="ni"></td> -->
	<!-- 		<td><span>nico</span> </td>  -->
	<!-- 	</tr> -->

	<!-- </tbody> -->
	<!-- </table> -->

	<!-- </form> -->
	<!-- </div> -->



	<!-- vercion select -->

	<div class="container">
		<form action="SerTurno" method="get">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" id="menu1"
					type="button" data-toggle="dropdown">
					Doctores <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="menu1"
					id="myTable">
					<li role="presentation"><input class="form-control"
						id="myInput" type="text" placeholder="Search.."></li>
					<li role="presentation"><a role="menuitem" tabindex="-1">
							<table id="myTable">
								<tbody>
									<tr>
										<td><input type="checkbox" name="doctores" value="na"><span>
												Nacho</span></td>
									</tr>
									<tr>
										<td><input type="checkbox" name="doctores" value="pa"><span>
												Pablo</span></td>
									</tr>
									<tr>
										<td><input type="checkbox" name="doctores" value="ni"><span>
												Nico</span></td>
									</tr>
								</tbody>
							</table></li>
				</ul>
				<button type="submit">ss</button>
			</div>
		</form>
	</div>
</div>
	<script>
		$(document).ready(function() {
				$("#myInput").on("keyup",function() {
						var value = $(this).val().toLowerCase();
						$("#myTable tr").filter(function() {
							$(this).toggle(
							$(this).text().toLowerCase().indexOf(value) > -1)
															});
													});
									});
	</script>
</body>
</html>