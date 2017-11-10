package login;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Usuario {
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private String email;
	private boolean estado;
	public ArrayList<Grupo> grupos;
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String password, String nombre, String apellido, String email, Boolean estado) {
		ArrayList<Grupo> grupos= new ArrayList<Grupo>();
		this.usuario= usuario;
		this.password= password;
		this.nombre= nombre;
		this.apellido= apellido;
		this.email= email;
		this.estado= estado;
		this.grupos= grupos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}
	

}
