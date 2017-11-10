package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;


@WebServlet("/MDoctor")
public class ABMgenerico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ABMgenerico() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBConnect db = new DBConnect();
		String modo = 	request.getParameter("modo");
		
		switch (modo) {
//---------------------alta----------------------------------------------------------------------------------------------------------
		case "alta":
			
			int DNI = Integer.parseInt(request.getParameter("DNI"));
			String nombre = request.getParameter("Nombre");
			String apellido = request.getParameter("Nombre");
			String estado = request.getParameter("Estado");
			
			
			String sen = "INSERT INTO `Doctor` (`DNI`,`Nombre`,`Apellido`, `Estado`) VALUES (" + DNI + ",\"" + nombre + "\",\""+ apellido +"\"," + estado + ")";
			if (db.ejecutar(sen)) {
				response.sendRedirect("");
			} else {
				request.setAttribute("respuesta", "Error al Agregar");
				request.getRequestDispatcher("/WEB-INF/ABMgenerico.jsp").forward(request, response);
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
