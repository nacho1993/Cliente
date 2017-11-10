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
									" <li class=\"has-sub\"> " +
										" <a tabindex=\"-1\" href=\"#\">GESTIONAR</a> "+
										"<ul>" +
											"<li class=\"active has-sub\"><a href=\"ABMgenera?tabla=doctor\">DOCTOR</a> " + 
												"<ul>" +
													"<li><a href=\"#\">Page 1-1-1</a></li> " +
												"</ul>"+
											"</li>" +
											"<li><a href=\"#\">PACIENTE</a></li> " +
											"<li><a href=\"#\">CONSULTORIO</a></li> " +
										"</ul>" +
									"</li>" +
									"<li><a href=\"Consulta\">ALQUILER</a></li>" +
									"<li class=\"has-sub\">" +
									  "<a tabindex=\"-1\" href=\"#\">SISTEMA</a>" +
									  "<ul>" +
											"<li class=\"active\"><a href=\"#\">USUARIO</a> </li>" +
											"<li><a href=\"#\">GRUPO</a></li> " +
									"</ul>" +
									"</li>" +
									"<li><a href=\"#\">TURNO</a></li>" +
								"</ul>"+
								"<ul class=\"nav navbar-nav navbar-right cerrar\">"+
									"<li><a href=\"Cerrar\"><span class=\"glyphicon glyphicon-log-out\"></span> Cerrar sesión</a></li>"+
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
