package Ecritores;

import javax.servlet.http.HttpServletRequest;

//import com.sun.deploy.nativesandbox.comm.Request;

public class Navbar {
	public static String impnbar(HttpServletRequest request) {
		String user= (String) request.getSession().getAttribute("user");
				String nbar;
				nbar="<nav class=\"navbar navbar-inverse\">" +
						"<div class=\"colformo3\">"    +
						"<div class=\"container-fluid\" id=\"cssmenu\">"    +
							"<div class=\"navbar-header\">"  +
								"<a class=\"navbar-brand glyphicon glyphicon-home\" href=\"menu.jsp\"></a>" +
							"</div>"                             +
								"<ul class=\"nav navbar-nav\">"      +
									
									"<li class=\"has-sub\"> " +
										" <a tabindex=\"-1\" href=\"#\">GESTIONAR</a> "+
										"<ul>" +
											"<li class=\"active has-sub\"><a href=\"ABMgenera?tabla=doctor\">DOCTORES</a> " + 
//												"<ul>" +
//													"<li><a href=\"#\">Page 1-1-1</a></li> " +
//												"</ul>"+
											"</li>" +
											"<li><a href=\"ABMgenera?tabla=paciente\">PACIENTES</a></li> " +
											"<li><a href=\"ABMgenera?tabla=consultorio\">CONSULTORIOS</a></li> " +
										"</ul>" +
									"</li>" +
										
									
									"<li><a href=\"Consulta\">ALQUILER</a></li>" +
									
									
									"<li class=\"has-sub\">" +
										"<a tabindex=\"-1\" href=\"#\">SISTEMA</a>" +
										"<ul>" +
											"<li><a href=\"ABMgenera?tabla=usuario\">USUARIOS</a> </li>" +
											"<li><a href=\"ABMgenera?tabla=grupo\">GRUPOS</a></li> " +
											"<li><a href=\"ABMgenera?tabla=permiso\">PERMISOS</a></li> " +
											"<li><a href=\"ABMgenera?tabla=formulario\">FORMULARIOS</a></li> " +
										"</ul>" +
									 "</li>" +	
									 
									"<li><a href=\"ABMgenera?tabla=turno\">TURNOS</a></li>" +	
									
									"<li class=\"has-sub\"> " +
										"<a tabindex=\"-1\" href=\"#\">HISTORIAL</a> "+
										"<ul>" +
											"<li><a href=\"#\">ESTUDIOS</a> </li>" +
											"<li><a href=\"#\">TURNOS</a></li> " +
										"</ul>" +
									"</li>" +
								
								"</ul>"+
								"<ul class=\"nav navbar-nav navbar-right cerrar\">"+
									"<li><a href=\"Cerrar\"><span class=\"glyphicon glyphicon-log-out\"></span> Cerrar sesi�n</a></li>"+
								"</ul>"     +	
								"<ul class=\"nav navbar-nav navbar-right\">"+
									"<li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> "+ user +" </a></li>"       +
								"</ul>"     +
						"</div>"        +
						"</div>"        +
					"</nav>";	
				return nbar;
	}

}
