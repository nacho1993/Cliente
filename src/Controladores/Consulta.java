package Controladores;

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
import login.Usuario;


@WebServlet("/Consulta")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Consulta() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect bd = new DBConnect();
		
		String con = "SELECT * FROM Usuario";
		ResultSet resultado = bd.consulta(con);
		ArrayList<Usuario> usu = new ArrayList<Usuario>();
		try {
			while (resultado.next()) {
				Usuario usr;
				  String usuario = resultado.getString("Usuario");
				  String password = resultado.getString("Password");
				  String nombre = resultado.getString("Nombre");
				  String apellido = resultado.getString("Apellido");
				  String mail = resultado.getString("Mail");
				  Boolean estado = resultado.getBoolean("Estado");
				 usr = new Usuario(usuario, password, nombre, apellido, mail, estado);
				 usu.add(usr);
//				new Usuario(resultado.getString("Usuario"),  resultado.getString("password"),  resultado.getString("nombre"),  resultado.getString("Apellido"),  resultado.getString("Mail"), resultado.getBoolean("Estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("usu", usu);
		request.getRequestDispatcher("/WEB-INF/sql.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
