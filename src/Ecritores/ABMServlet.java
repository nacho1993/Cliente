package Ecritores;

 
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Estructura.*;
import Objetos.*;
import java.util.ArrayList;
import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;
import Controladores.Consulta;


@WebServlet("/ABMServlet")
public class ABMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ABMServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CodigoHTML=""; 
		String accion = request.getParameter("v1");
		String nombreABM = (String) request.getSession().getAttribute("nombreABM");
		DBConnect db = new DBConnect();
		switch (accion) {
		case "A":
			 CodigoHTML= "<form class=\"form-horizontal\" action=\"AMBgenerico\" method=\"post\">";
//				<!--la respuesta, cuando vuelve de ABMgenerioco  -->
				if (request.getAttribute("respuesta") != null) { 
					CodigoHTML= CodigoHTML +
				"</br>"+
				 request.getAttribute("respuesta");
				}
				CodigoHTML= CodigoHTML +
				"<input type=\"hidden\" name=\"modo\" value=\"alta\">";
//				<!-- trae el array de los campos -->
				ArrayList<Tabla> tabarr = (ArrayList<Tabla>) request.getSession().getAttribute("tabarr");
				CodigoHTML= CodigoHTML +
				"<input type=\"hidden\" name=\"oculto\""+
					"value=\""+ request.getAttribute("ntabla") +"\">";
				for(Tabla tabla : tabarr){
					String nomcam = tabla.getNomcam();
					String tipo = tabla.getTipo();
					switch (tipo) {
						case "int":
				CodigoHTML= CodigoHTML + 
				"<div class=\"form-group\">"+
					"<label class=\"control-label col-sm-2\">" + nomcam +":"+
					"</label>"+
					"<div class=\"col-sm-10\">"+
						"<input type=\"text\" class=\"form-control\" name=\"" + nomcam + "\">"+
					"</div>"+
				"</div>";
				break;
						case "string":
				CodigoHTML= CodigoHTML +
				"<div class=\"form-group\">"+
					"<label class=\"control-label col-sm-2\">"+ nomcam +":"+
					"</label>"+
					"<div class=\"col-sm-10\">"+
						"<input type=\"text\" class=\"form-control\" name=\""+ nomcam+"\">"+
					"</div>"+
				"</div>";
				break;
						case "bool":
							if(nomcam.equals("Estado")){ 
				CodigoHTML= CodigoHTML +
				"<div class=\"form-group\">"+
					"<label class=\"control-label col-sm-2\">Estado:</label>"+
					"<div class=\"checkbox col-md-10\">"+
						"<select name=\"Estado\">"+
							"<option value=\"TRUE\">Activo</option>"+
							"<option value=\"FALSE\">Inactivo</option>"+
						"</select>"+
					"</div>"+
				"</div>";
				}
						break;
						case "lisobj":
				
				CodigoHTML= CodigoHTML +
				"<div class=\"form-group\">"+
					"<div class=\"dropdown col-md-10 col-sm-offset-2\">"+
						 SelecObj.impsel(nomcam) +
					"</div>"+
				"</div>";
				
				break;
						case "date":
				CodigoHTML= CodigoHTML +
				"<div class=\"form-group\">"+
					"<label class=\"control-label col-sm-2\"> "+ nomcam +
					"</label>"+
					"<div class=\"col-sm-10\">"+
					"<input type=\"text\" class=\"form-control\" name=\""+ nomcam+"\">"+
					 "</div>"+
				"</div>";
				break;
						case "datetime":
				CodigoHTML= CodigoHTML +
				"<div class=\"form-group\">"+
					"<label class=\"control-label col-sm-2\"> "+ nomcam +":"+
					"</label>"+
					"<div class=\"col-sm-10\">"+
					"<input type=\"text\" class=\"form-control\" name=\""+ nomcam+"\">"+
					"</div>"+
				"</div>";
				break;
						case "select":
							CodigoHTML= CodigoHTML +
							"<div class=\"form-group\">"+
								"<label class=\"control-label col-sm-2\"> "+ nomcam +":"+
								"</label>"+
								"<div class=\"col-sm-10\">"+
								"<select name=\""+ nomcam +"\" class=\"chosen\">";
									ResultSet resultado = db.consulta("SELECT * FROM "+ nomcam);
									request.getSession().setAttribute("lisformularios", resultado);
						try {
							while (resultado.next()) {
								
								if(nomcam.equals("Consultorio")) {
									CodigoHTML= CodigoHTML +
										"<option value=\""+ resultado.getInt("id") +"\">"+ resultado.getInt("numero") +"</option>";
								}else {
									CodigoHTML= CodigoHTML +
				    			 "<option value=\""+ resultado.getInt("id") +"\">"+ resultado.getString("nombre") + " " + resultado.getString("apellido") +"</option>";
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
							CodigoHTML= CodigoHTML +
				    			 "</select>"+
								"</div>"+
							"</div>";
				break;
						case "formulario":
							ResultSet lisformulario = db.consulta("SELECT * FROM formulario");
							CodigoHTML= CodigoHTML + "<h3 class=\"centrar\">Permisos formularios</h3>";
						try {
							while(lisformulario.next()) {
								
							CodigoHTML= CodigoHTML +
							"<div class=\"form-group\">"+
								"<label class=\"control-label col-sm-2\"> "+ lisformulario.getString("descripcion") +
								"</label>"+
								"<div class=\"col-sm-10\">"+
									"<input type=\"checkbox\" name=\""+ lisformulario.getInt("id")  +"\" value=\"A\"> Alta<br>"+
									"<input type=\"checkbox\" name=\""+ lisformulario.getInt("id")  +"\" value=\"M\" > Modificacion<br>"+
									"<input type=\"checkbox\" name=\""+ lisformulario.getInt("id")  +"\" value=\"B\" > Baja<br>"+
								 "</div>"+
							"</div>";
							
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							break;
						default:
						break;
					}
				} 
				CodigoHTML= CodigoHTML +
				"<div class=\"form-group\">"+
					"<div class=\"col-sm-offset-2 col-sm-10\">"+
						"<button type=\"submit\" class=\"btn btn-default\">Agregar</button>"+
					"</div>"+
				"</div>"+
			"</form>";
					
			break;
		
		case "B":
			CodigoHTML = Consulta.consultagenerica(nombreABM, accion);
			
			break;

		case "M":	
			CodigoHTML = Consulta.consultagenerica(nombreABM, accion);
			break;
			
		default:
			
			break;
		}
		
		response.setContentType("text/plain"); 
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(CodigoHTML); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
