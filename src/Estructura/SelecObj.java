package Estructura;
import Connect.DBConnect;
import login.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
public class SelecObj {
		
	public static String impsel(String nomcap) {
		DBConnect db = new DBConnect();
		ResultSet resultado = db.consulta("select * from "+ nomcap);
		System.out.print(resultado);
		if(resultado == null)
			return "\n";
				String slc;
				slc= "<button class=\"btn btn-primary dropdown-toggle\" id=\"menu1\"" +
				"		type=\"button\" data-toggle=\"dropdown\"> "+
						nomcap + " <span class=\"caret\"></span> "+
				"	</button> "+
				"	<ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"menu1\" "+
				"		id=\"myT"+ nomcap +"\"> "+
				"		<li role=\"presentation\"><input class=\"form-control\" "+
				"			id=\"myI"+ nomcap +"\" type=\"text\" placeholder=\"Search..\"></li> "+
				"		<li role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\"> "+
							"	<table id=\"myTable\"> "+
							"		<tbody> ";
							try {
								while (resultado.next()) {
							slc= slc + 
							"			<tr> "+
							"				<td><input type=\"checkbox\" name=\"doctores\" value=\"" + resultado.getInt("numero") + "\"><span> " + resultado.getInt("numero") + "</span></td> "+
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
				"					$(\"#myI"+ nomcap +"\").on(\"keyup\",function() { "+
				"							var value = $(this).val().toLowerCase(); "+
				"							$(\"#myT"+ nomcap +" tr\").filter(function() { "+
				"								$(this).toggle( "+
				"								$(this).text().toLowerCase().indexOf(value) > -1) "+
				"																}); "+
				"														}); \"+"+
				"										}); "+
				" </script> ";
						
				return slc;
				
				
				
						
					
      }
	}
