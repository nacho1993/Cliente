package Estructura;
import Connect.DBConnect;
import login.Usuario;
import Objetos.Listaselect;
import Objetos.Tabla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
public class SelecObj {
		
	public static String impsel(String nomcam) {
		DBConnect db = new DBConnect();
		ResultSet resultado = db.consulta("select * from "+ nomcam);
		if(resultado == null)
			return "\n";
				String slc;
				slc= "<button class=\"btn btn-primary dropdown-toggle\" id=\"menu1\"" +
				"		type=\"button\" data-toggle=\"dropdown\"> "+
						nomcam + " <span class=\"caret\"></span> "+
				"	</button> "+
				"	<ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"menu1\" "+
				"		id=\"myT"+ nomcam +"\"> "+
				"		<li role=\"presentation\"><input class=\"form-control\" "+
				"			id=\"myI"+ nomcam +"\" type=\"text\" placeholder=\"Search..\"></li> "+
				"		<li role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\"> "+
							"	<table id=\"myTable\"> "+
							"		<tbody> ";
							try {
								while (resultado.next()) {
							slc= slc + 
							"			<tr> "+
							"				<td><input type=\"checkbox\" name=\"lista\" value=\"" + resultado.getInt("numero") + "\"><span> " + resultado.getInt("numero") + "</span></td> "+
							"			</tr> ";
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							 slc= slc +
							"		</tbody> "+
							"	</table></li> "+
				"	</ul> " +
				" <script> "+
				"			$(document).ready(function() { "+
				"					$(\"#myI"+ nomcam +"\").on(\"keyup\",function() { "+
				"							var value = $(this).val().toLowerCase(); "+
				"							$(\"#myT"+ nomcam +" tr\").filter(function() { "+
				"								$(this).toggle( "+
				"								$(this).text().toLowerCase().indexOf(value) > -1) "+
				"																}); "+
				"														}); \"+"+
				"										}); "+
				" </script> ";
						
				return slc;	
      }
	
	
	
	}
