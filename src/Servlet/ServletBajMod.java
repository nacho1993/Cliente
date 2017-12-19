package Servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;


@WebServlet("/ServletBajMod")
public class ServletBajMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletBajMod() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect bd = new DBConnect();
		String accion = request.getParameter("accion");
		String tabla = (String) request.getSession().getAttribute("nombreABM");
		String id = request.getParameter("id");
		
		if(accion.equals("B")) {
			String SQL = "delete from "+ tabla +" where id="+ id;
		 if(bd.ejecutar(SQL)) {
			 	request.setAttribute("respuesta", "Se dio de baja de forma correcta");
				request.getRequestDispatcher("WEB-INF/ABMGenerico.jsp").forward(request,response);
		 }
		}

	}
}
