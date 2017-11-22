package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class DBConnect {
	public Connection getconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "nacho1552");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean ejecutar(String SQL ) {
		try {
		java.sql.Statement sentecia = getconnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		sentecia.execute(SQL);
		sentecia.close();
		}catch (SQLException e){
			System.out.print("Error en Ejecutar");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ResultSet consulta(String SQL) {
		ResultSet resultado = null;
		try {
			java.sql.Statement sentencia = getconnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			resultado = sentencia.executeQuery(SQL);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultado;
	}
	

}
