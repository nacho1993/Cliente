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
import login.Usuario;


@WebServlet("/WebServ2")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
//		DBConnect bd = new DBConnect();
//		String sen = "INSERT INTO `Usuario` (`Usuario`,`Password`,`Nombre`,`Apellido`,`Mail`,`Estado`) VALUES (\"Dawn\",\"Noel\",\"Rebecca\",\"Farley\",\"Mauris.blandit@Duismienim.ca\",true)";
//		if (bd.ejecutar(sen)) {
//			System.out.print("correcta");
//		} else {
//			System.out.print("incorrecta");
//		}

		

		String user = request.getParameter("usr");
		String pass = request.getParameter("pwd");
				
		DBConnect db = new DBConnect();
	
		String con = "SELECT * FROM Usuario WHERE Usuario=\"" + user +"\"";
		ResultSet resultado = db.consulta(con);
		if(resultado == null) {
			request.setAttribute("error", "1");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			try {
				while (resultado.next()) {
				if(pass.equals(resultado.getString("Password"))) {
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("pass", pass);
					request.getSession().setAttribute("idusu", resultado.getInt("id"));

					request.getRequestDispatcher("/menu.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "1");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					
				}}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
