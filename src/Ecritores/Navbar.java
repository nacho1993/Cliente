package Ecritores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Connect.DBConnect;
import Objetos.Tabla;
import login.Formulario;

//import com.sun.deploy.nativesandbox.comm.Request;

public class Navbar {
	public static String impnbar(HttpServletRequest request) {
		ArrayList<Formulario> arrformularios = new ArrayList<Formulario>();
		String user= (String) request.getSession().getAttribute("user");
		int idusu = (int) request.getSession().getAttribute("idusu");
		DBConnect db = new DBConnect();
		ResultSet rusugrupo = db.consulta("select * from usuariogrupo where usuario=\""+ idusu +"\"");
			try {
				while (rusugrupo.next()) {
					int idgrupo = rusugrupo.getInt("grupo"); 
					ResultSet rgruform = db.consulta("select * from grupoformulario where grupo=\""+ idgrupo +"\" group by formulario");
					while (rgruform.next()) {
						int idform = rgruform.getInt("formulario");
						ResultSet rformulario = db.consulta("select * from formulario where id=\""+ idform +"\"");
						while (rformulario.next()) {
							Formulario form;
							String nombreformulario = (String) rformulario.getString("Descripcion");
						 form = new Formulario(idform, nombreformulario);
						 arrformularios.add(form);
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
				String nbar;
				nbar="<nav class=\"navbar navbar-inverse\">" +
						"<div class=\"colformo3\">"    +
						"<div class=\"container-fluid\" id=\"cssmenu\">"    +
							"<div class=\"navbar-header\">"  +
								"<a class=\"navbar-brand glyphicon glyphicon-home\" href=\"menu.jsp\"></a>" +
							"</div>"                             +
								"<ul class=\"nav navbar-nav\">";
				
				for (Formulario formulario : arrformularios) {
					String form = formulario.getDescripcion();
					switch (form) {
					case "doctor":
					case"paciente":
					case "consultorio":
						nbar=nbar +	"<li class=\"has-sub\"> " +
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
									"</li>"; 
					break;					
					case "alquiler":		
							nbar=nbar +"<li><a href=\"Consulta\">ALQUILER</a></li>" ;
					break;		
							
					case "usuario":	
					case "grupo":
					case "formulario":
							nbar=nbar +"<li class=\"has-sub\">" +
										"<a tabindex=\"-1\" href=\"#\">SISTEMA</a>" +
										"<ul>";
										if(form.equals("usuario")) {
											nbar=nbar +"<li><a href=\"ABMgenera?tabla=usuario\">USUARIOS</a> </li>" ;
										}else {
											if(form.equals("grupo")) {
											nbar=nbar +"<li><a href=\"ABMgenera?tabla=grupo\">GRUPOS</a></li> " ;
											}else {
											nbar=nbar +"<li><a href=\"ABMgenera?tabla=formulario\">FORMULARIOS</a></li> " ;
											}
										}
							nbar=nbar +	"</ul>" +
									 "</li>" ;
					case "turno":				 
							nbar=nbar +	"<li><a href=\"ABMgenera?tabla=turno\">TURNOS</a></li>";	
					break;				
									
					case "historial":				
							nbar=nbar +	"<li class=\"has-sub\"> " +
										"<a tabindex=\"-1\" href=\"#\">HISTORIAL</a> "+
										"<ul>" +
											"<li><a href=\"#\">ESTUDIOS</a> </li>" +
											"<li><a href=\"#\">TURNOS</a></li> " +
										"</ul>" +
									"</li>" ;
					break;
					default:
					break;
					}
				}
									
					nbar=nbar +	"</ul>"+
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
