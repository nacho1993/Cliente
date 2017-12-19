package Estructura;



import Connect.DBConnect;

public class Date {
	
	public static String inputdate(String nomcam) {
		String select="";
		
		select=		 "<div class=\"col-md-3\">"+		    
						"<input type=\"text\" class=\"form-control\" required value=\"\" id=\"" +nomcam +"\" name=\"FECHA\" placeholder=\"Fecha Nacimiento\">"+
					"</div>";

					
							return select; 

}}
