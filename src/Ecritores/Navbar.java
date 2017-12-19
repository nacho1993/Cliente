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
		ResultSet rusugrupo = db.consulta("select * from grupousuario where usuario=\""+ idusu +"\"");
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
			
				int vgestionar=0;
				int vsistema=0;
				String nbar;
				String gestionar="";
				String sistema="";
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
						if(vgestionar==0){
						gestionar=gestionar +	"<li class=\"has-sub\"> " +
										" <a tabindex=\"-1\" href=\"#\">GESTIONAR</a> "+
										"<ul>";
						vgestionar=1;
						}
						if(form.equals("doctor")) {
							gestionar=gestionar +"<li class=\"active has-sub\"><a href=\"ABMgenera?tabla=doctor\">DOCTORES</a> </li>" ;
						}else {
							if(form.equals("paciente")) {
								gestionar=gestionar +"<li><a href=\"ABMgenera?tabla=paciente\">PACIENTES</a></li> ";
							}else {
								gestionar=gestionar +"<li><a href=\"ABMgenera?tabla=consultorio\">CONSULTORIOS</a></li> ";
							}
						}
						
					break;	
					
					case "alquiler":		
							nbar=nbar +"<li><a href=\"Consulta\">ALQUILER</a></li>" ;
					break;		
							
					case "usuario":	
					case "grupo":
					case "formulario":
						if(vsistema==0){
							sistema=sistema +"<li class=\"has-sub\">" +
										"<a tabindex=\"-1\" href=\"#\">SISTEMA</a>" +
										"<ul>";
							vsistema=1;
						}
										if(form.equals("usuario")) {
											sistema=sistema +"<li><a href=\"ABMgenera?tabla=usuario\">USUARIOS</a> </li>" ;
										}else {
											if(form.equals("grupo")) {
												sistema=sistema +"<li><a href=\"ABMgenera?tabla=grupo\">GRUPOS</a></li> " ;
											}else {
												sistema=sistema +"<li><a href=\"ABMgenera?tabla=formulario\">FORMULARIOS</a></li> " ;
											}
										}
					break;
										
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
				if(vgestionar==1) {
					gestionar=gestionar +"</ul>" +
							"</li>";
				}
				if(vsistema==1) {
					sistema=sistema	+"</ul>" +
							 "</li>" ;
				}
								
				
				
					nbar=nbar + gestionar+ sistema +	"</ul>"+
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
