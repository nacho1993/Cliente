package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabnom = request.getParameter("oculto");
		DBConnect db = new DBConnect();
		String modo = 	request.getParameter("modo");
		
		switch (modo) {
//---------------------alta----------------------------------------------------------------------------------------------------------
		case "alta":
			String campos = "";
			String valores = "";
			int contador = 0;
			ResultSet resultado = db.consulta("select * from campos where tabla=\"" + tabnom + "\"");
			ResultSet cantidad = db.consulta("select count(*) from campos where tabla=\"" + tabnom + "\"");
			try {
				while (cantidad.next()) {
					int cant = cantidad.getInt("count(*)");
				while (resultado.next()) {
				String nomcam = resultado.getString("nomcam");
				String tipo = resultado.getString("tipo");
				contador = contador + 1;
					campos = campos + "`" + nomcam + "`";
				if (request.getParameter(nomcam) != null) {
					if(tipo.equals("INT") || tipo.equals("bool")) { 
						valores = valores + request.getParameter(nomcam);
					}else {
						valores = valores + "\"" + request.getParameter(nomcam) +"\"";
					}
					if(cant != contador) {
						campos = campos + ", ";
						valores = valores + ", ";
					}
				}else {
					valores = valores + "NULL";
				}
					}}
				}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			int DNI = Integer.parseInt(request.getParameter("DNI"));
//			String nombre = request.getParameter("Nombre");
//			String apellido = request.getParameter("Nombre");
//			String estado = request.getParameter("Estado");
			
			
			String sen = "INSERT INTO " + tabnom + " ("+ campos +") VALUES ("+ valores +")";
			
			if (db.ejecutar(sen)) {
				response.sendRedirect("resultado.jsp");
			} else {
				request.setAttribute("respuesta", "Error al Agregar");
				request.getRequestDispatcher("WEB-INF/ABMgenerico.jsp").forward(request, response);
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
