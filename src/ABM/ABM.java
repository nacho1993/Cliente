package ABM;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Estructura.Button;

public class ABM {
	
	public static String genABM(HttpServletRequest request, String jsp,String autonum) throws NullPointerException
	{
	
		
		String[][] tipocampos=null;
		
//			ParamSession params = (ParamSession)request.getSession().getAttribute(Param.PARAMETROSDESESION);
			
			tipocampos = ParamFijos.getTipocampos(jsp,request);
		
		
		
		ArrayList<String[]> claves = ParamFijos.getClaves(jsp);
		
		
		//arma el FORM
		String genABM="<form class=\"form-horizontal\" method=\"post\" action=\"ABMServlet\" >"
				+ "<input type=\"hidden\" name=\"jsp\" value=\""+jsp+"\">";
		for (int i = 0; i < claves.size(); i++) {		
		
			//escribe el campo, con el name=nombre de campo y etiqueta=descripcion de campo
			genABM+="<div class=\"form-group\">"
					+ "	    <label class=\"control-label col-md-3\" for=\""+claves.get(i)[0]+"\">"+claves.get(i)[1]+":</label>"
					+ "	 <span class=\"glyphicon glyphicon-plus\" style=\"line-height: 2\">  </span><span> Agregar</span>"
					+ "   <div class=\"col-md-6\"> ";
			String type="",max="";
			switch(tipocampos[Integer.parseInt(claves.get(i)[3])][0])
			{
				case "NUMERIC":
					max=" max=\"";
					for (int j = 0; j < Integer.parseInt(tipocampos[Integer.parseInt(claves.get(i)[3])][1]); j++) {
						max+="9";}
					max+="\"";
					
					type=" type=\"number\"";
					break;
				case "DECIMAL":
					max=" maxlength=\""+(Integer.parseInt(tipocampos[Integer.parseInt(claves.get(i)[3])][1])+1)+"\"";//sumo uno para la coma
					
					type=" pattern=\"[0-9]+([,][0-9]+)?\""
					+ "title=\"El valor debe ser numerico y utilizar una coma para agregar decimales.\"";
					break;
				case "CHAR":
				case "VARCHAR":
					max=" maxlength=\""+Integer.parseInt(tipocampos[Integer.parseInt(claves.get(i)[3])][1])+"\"";
					
					type="type=\"text\"";
					break;		
				
			}
					genABM+= "<input "+type+" class=\"form-control\" id=\""+claves.get(i)[0]+"\" name=\""+claves.get(i)[0]+"\""+max+" required>"
					+ " </div></div>";
		}
		if(autonum!=null)
		{				
			genABM+="<input type=\"hidden\" name=\"autonum\" value=\""+autonum+"\">";

		}
		
		
		genABM+="<div class=\"row\">"
				+ Button.impButton(Button.TIPO_SUBMIT, Button.CLASE_PRIMARY, "Confirmar","Iniciar","id=\btnSubmit\" data-loading-text=\"<i class='fa fa-spinner fa-spin '></i> Recuperando datos\"", 3, 3)+ "</form>";
				
		genABM+="<a href=\"menu.jsp\">"
				+ Button.impButton(Button.TIPO_BUTTON, Button.CLASE_WARNING, "Volver al Menu", 2, 2)
				+ "</a>"
				+ "</div>";	
		return genABM;
		
	}
	
	//sin autonumerico
	public static String genABM(HttpServletRequest request, String jsp) throws NullPointerException
	{
		return genABM(request, jsp, null);
	}
	

}
