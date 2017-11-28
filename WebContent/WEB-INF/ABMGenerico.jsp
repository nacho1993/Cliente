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
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" />

</head>
<body>
	<div class="container">
		<%= Navbar.impnbar(request)%>

		<form class="form-horizontal" action="AMBgenerico" method="post">
		
			<!--la respuesta, cuando vuelve de ABMgenerioc  -->
			<%if (request.getAttribute("respuesta") != null) { %>
				</br> <%= request.getAttribute("respuesta")%>
			<%}%>     
            
  			
  			<input type="hidden" name="modo" value="alta"> 
  			
			<!-- trae el array de los campos -->
 			<%ArrayList<Tabla> tabarr = (ArrayList<Tabla>) request.getSession().getAttribute("tabarr");%>
  	
    		<input type="hidden" name="oculto" value="<%= request.getAttribute("ntabla") %>">
			
			<%for(Tabla tabla : tabarr){
				String nomcam = tabla.getNomcam();
				String tipo = tabla.getTipo();
				
				
				switch (tipo) {
					case "int":%>
						<div class="form-group">
							<label class="control-label col-sm-2"> <%=nomcam%>:</label>
							<div class="col-sm-10">
  								<input type="text" class="form-control" name="<%=nomcam%>">
							</div>
						</div>
					<%break;
			
					case "string":%>
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
					      		<div class="checkbox col-md-10">
					        		<select name="Estado">
										<option value="TRUE">Activo</option>
					  					<option value="FALSE">Inactivo</option>
					  				</select>
					    		</div>
					  		</div>
						<%}
					break;
					
					case "select":%>
					<div class="form-group">
						<label class="control-label col-sm-2"> <%=nomcam%>:</label>
						<div class="col-sm-10">
 							<%= Listobj.lisselect(nomcam)%> 				
						</div>
					</div>
				<%break;
				
					case "lisobj": %>
						<div class="form-group">
							<div class="dropdown col-md-10 col-sm-offset-2">
								<%= SelecObj.impsel(nomcam) %>
							</div>
						</div>
					<%break;
					
					case "date":%>
						<div class="form-group">
							<label class="control-label col-sm-2"> <%=nomcam%>:</label>
							<div class="col-sm-10">
								
							</div>
						</div>
					<%break;
			
					case "datetime":%>
						<div class="form-group">
							<label class="control-label col-sm-2"> <%=nomcam%>:</label>
							<div class="col-sm-10">
							
							</div>
						</div>
					<%break;
					
				
					
					default:
					break;
				}
			} %>
    
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
     	 			<button type="submit" class="btn btn-default">Agregar</button>
    			</div>
  			</div>
		</form> 
	</div>
</body>
</html>