package Estructura;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connect.DBConnect;

public class Listobj {

	public static String lisselect(String nomcam) {
		String select="";
		DBConnect db = new DBConnect();
		ResultSet resultado = db.consulta("select * from "+ nomcam);
		if(resultado == null)
			return "\n";

		try {
		select= "<div class=\"col-md-7 col-offset-md-1\">"+
					"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
					"<table class=\"table table-condensed table-bordered\" id=\"myTable\"> <tbody>";
						while (resultado.next()) {
							select= select + 
									"			<tr> "+
									"				<td>"+
									"                  <div calass=\"radio\"> <label>       "+
									"					<input type=\"radio\" name=\"lista\" value=\"" + resultado.getInt("id") + "\">"+
									"					</label> </div>"+			
									"				</td> ";
							if(nomcam.equals("Consultorio") ) {
								select= select +
								"				<td>"+
								"					<span> " + resultado.getInt("numero") + "</span>"	+	
								"				</td>"+
								"  				<td>"+
								"					<span> " + resultado.getInt("piso") + "</span>"	+	
								"				</td>";
							}else {
								select= select +		
									"				<td>"+
									"					<span> " + resultado.getInt("dni") + "</span>"	+	
									"				</td>"+
									"				<td>"+
									"					<span> " + resultado.getString("nombre") + "</span>"	+	
									"				</td>"+
									"				<td>"+
									"					<span> " + resultado.getString("apellido") + "</span>"	+	
									"				</td>"+
									"			</tr> ";
							}
						}
						select= select + "</tbody></table></div>";
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				return select; 

	
//				select= "<select class=\"selectpiker\" data-style=\"btn-primary\">";
//				try {
//					if(nomcam.equals("Consultorio") ) {
//						while (resultado.next()) {
//							select= select + "<option value=\"" + resultado.getInt("id") +"\">"+resultado.getInt("numero") +"</option>";
//					}	
//					}else {
//					while (resultado.next()) {
//							select= select + "<option value=\"" + resultado.getInt("id") +"\">"+resultado.getInt("dni")+"  " +resultado.getString("nombre") +"</option>";
//					}
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				
//				select= select + "</select>";
	
	}
}
