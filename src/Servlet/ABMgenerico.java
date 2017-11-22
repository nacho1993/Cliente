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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabnom = request.getParameter("oculto");
		DBConnect db = new DBConnect();
		String modo = 	request.getParameter("modo");
		String[] lista = request.getParameterValues("lista");
		
		switch (modo) {
//---------------------alta----------------------------------------------------------------------------------------------------------
		case "alta":
			String campos = "";
			String valores = "";
			int contador = 0;
//			consulta para ver si lla existe
			ResultSet conex = db.consulta("select * from " + tabnom + " where DNI=" + request.getParameter("DNI"));
			try {
				if(conex.next()) {
					request.setAttribute("respuesta", "<div class=\"alert alert-danger\">Ya hay un "+tabnom+" con ese DNI</div>");
					request.getRequestDispatcher("/WEB-INF/ABMGenerico.jsp").forward(request, response);
				}else {
				ResultSet resultado = db.consulta("select * from campos where tabla=\"" + tabnom + "\"");
				ResultSet cantidad = db.consulta("select count(*) from campos where tabla=\"" + tabnom + "\" and tipo<>\"lisobj\"");

					while (cantidad.next()) {
						int cant = cantidad.getInt("count(*)");
					while (resultado.next()) {
					String nomcam = resultado.getString("nomcam");
					String tipo = resultado.getString("tipo");
					if(tipo.equals("lisobj")) {	
//					genere un registro en la tabla intermedia
						for (String string : lista) {
							ResultSet conlis = db.consulta("SELECT * FROM " + nomcam + tabnom +" WHERE " +tabnom+ "=" +request.getParameter("DNI") + " and " + nomcam +"=" + string);
							if (conlis.next()) {
							}else {
								String senlis = "INSERT INTO " + nomcam + tabnom +"(" +tabnom+ ", "+nomcam+ ") VALUES (" + request.getParameter("DNI") + ", "  + string + ")";
								if (db.ejecutar(senlis)) {
								} else {
									request.setAttribute("respuesta", "Error al Agregar");
									request.getRequestDispatcher("WEB-INF/ABMgenerico.jsp").forward(request, response);
								}
							}
						}
					}else {
					contador = contador + 1;
						campos = campos + "`" + nomcam + "`";
					if (request.getParameter(nomcam) != null) {
						if(tipo.equals("INT") || tipo.equals("bool")) { 
							valores = valores + request.getParameter(nomcam);
						}else {
							valores = valores + "\"" + request.getParameter(nomcam) +"\"";
						}
					}else {
						valores = valores + "NULL";
					}
					if(cant != contador) {
						campos = campos + ", ";
						valores = valores + ", ";
					}
						}}}
					
					
				
				
				String sen = "INSERT INTO " + tabnom + " ("+ campos +") VALUES ("+ valores +")";
				
				if (db.ejecutar(sen)) {
					request.setAttribute("respuesta", "<div class=\"alert alert-success\"><span class=\"glyphicon glyphicon-thumbs-up\"></span> Se agrego correctamente</div>");
					request.getRequestDispatcher("/WEB-INF/ABMGenerico.jsp").forward(request, response);
//					response.sendRedirect("resultado.jsp");
				} else {
					request.setAttribute("respuesta", "Error al Agregar");
					request.getRequestDispatcher("WEB-INF/ABMgenerico.jsp").forward(request, response);
				}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			break;
//---------------------modificacion----------------------------------------------------------------------------------------------------------
		case "modi":
			
			break;
//---------------------consulta----------------------------------------------------------------------------------------------------------
		case "cons":
	
			break;

		default:
			break;
		}
	}

}
