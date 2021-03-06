package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;
import Objetos.Tabla;
import login.Usuario;


@WebServlet("/ABMgenera")
public class ABMgenera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ABMgenera() {
        super();
        
    }

	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 trae todos los campos de la tabla capos para el objeto elejido y los guarda en un array 
		String tabnom = request.getParameter("tabla"); 
			DBConnect bd = new DBConnect();
			
			String con = "SELECT * FROM campos where tabla=\"" + tabnom + "\"" ;
			ResultSet resultado = bd.consulta(con);
			
			ArrayList<Tabla> tabarr = new ArrayList<Tabla>();
			try {
				while (resultado.next()) {
					Tabla tabobj;
					  String nombre = resultado.getString("tabla");
					  String nomcap = resultado.getString("nomcam");
					  String tipo = resultado.getString("tipo");
					  Boolean primary =  resultado.getBoolean("primary");
					  
					 tabobj = new Tabla(nombre, nomcap, tipo, primary);
					 tabarr.add(tabobj);
				}
				
			
			request.getSession().setAttribute("tabarr", tabarr);
			request.getSession().setAttribute("nombreABM", tabnom);
//			request.setAttribute("ntabla", tabnom);
			request.getRequestDispatcher("/WEB-INF/ABMGenerico.jsp").forward(request, response);
			
			
			}catch (SQLException e) {
				e.printStackTrace();
			}


		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
