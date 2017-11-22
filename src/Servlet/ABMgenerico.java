package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;
import Objetos.Tabla;

@WebServlet("/AMBgenerico")
public class ABMgenerico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ABMgenerico() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tabnom = request.getParameter("oculto");
		DBConnect db = new DBConnect();
		String modo = request.getParameter("modo");
		String[] lista = request.getParameterValues("lista");

		// (ve si es alta, modificacion o baja
		switch (modo) {
		// ---------------------alta----------------------------------------------------------------------------------------------------------
		case "alta":
			// inicializa variables
			String campos = "";
			String valores = "";
			int contador = 0;
			Tabla objint = null; 
			String claveprimaria = ""; 
			
			
			try {
					ArrayList<Tabla> tabarr = (ArrayList<Tabla>) request.getSession().getAttribute("tabarr");
					ResultSet cantidad = db.consulta("select count(*) from campos where tabla=\"" + tabnom + "\" and tipo<>\"lisobj\"");

					while (cantidad.next()) {
						int cant = cantidad.getInt("count(*)");
						//recorre todos los campos para escribir el formulario						
						for (Tabla tabla : tabarr) {
							String tipo = tabla.getTipo();
							String nomcam = tabla.getNomcam();
							// consulta para ver si lla existe
							if(tabla.getPrimary() == true) {
								claveprimaria= tabla.getNomcam();
								ResultSet conexiste = db.consulta("select * from " + tabnom + " where "+ claveprimaria +" =" + request.getParameter(claveprimaria));
								if (conexiste.next()) {
									request.setAttribute("respuesta","<div class=\"alert alert-danger\">Ya hay un " + tabnom + " con ese "+claveprimaria +"</div>");
									request.getRequestDispatcher("/WEB-INF/ABMGenerico.jsp").forward(request, response);
								}
							}
							
							//si hay un campos para hacer tabla intermedia
							if (tipo.equals("lisobj")) {
								objint = tabla;
							}else{	
								
								contador = contador + 1;
								campos = campos + "`" + nomcam + "`";
								if (request.getParameter(nomcam) != null) {
									if (tipo.equals("int") || tipo.equals("bool")) {
										valores = valores + request.getParameter(nomcam);
									} else {
										valores = valores + "\"" + request.getParameter(nomcam) + "\"";
									}
								} else {
									valores = valores + "NULL";
								}
								if (cant != contador) {
									campos = campos + ", ";
									valores = valores + ", ";
								}
							}
						}
					}

					String sen = "INSERT INTO " + tabnom + " (" + campos + ") VALUES (" + valores + ")";

					if (db.ejecutar(sen)) {
							if (objint != null) {
								String nomcam = objint.getNomcam();
								// genere un registro en la tabla intermedia
								for (String string : lista) {
									ResultSet conlis = db.consulta("SELECT * FROM " + nomcam + tabnom + " WHERE " + tabnom + "="+ request.getParameter(claveprimaria) + " and " + nomcam + "=" + string);
									if (conlis.next()) {
									} else {
										String senlis = "INSERT INTO " + nomcam + tabnom + "(" + tabnom + ", " + nomcam+ ") VALUES (" + request.getParameter(claveprimaria) + ", " + string + ")";
										if (db.ejecutar(senlis)) {
										} else {
											request.setAttribute("respuesta", "Error al Agregar");
											request.getRequestDispatcher("WEB-INF/ABMgenerico.jsp").forward(request,response);
										}
									}
								}
							}
						}
//						mensaje que se agrego bien
						request.setAttribute("respuesta","<div class=\"alert alert-success\"><span class=\"glyphicon glyphicon-thumbs-up\"></span> Se agrego correctamente</div>");
						request.getRequestDispatcher("/WEB-INF/ABMGenerico.jsp").forward(request, response);
				
					
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		// ---------------------modificacion----------------------------------------------------------------------------------------------------------
		case "modi":

			break;
		// ---------------------consulta----------------------------------------------------------------------------------------------------------
		case "cons":

			break;

		default:
			break;
		}
	}

}
