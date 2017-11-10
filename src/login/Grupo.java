package login;

import java.util.ArrayList;

public class Grupo {
	private int id;
	private String descripcion;
	private boolean estado;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Permiso> permisos;

	
	public Grupo() {
		
	}
	
	public Grupo(int id, String decripcion, Boolean estado) {
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		ArrayList<Permiso> permisos= new ArrayList<Permiso>();
		this.id= id;
		this.descripcion= descripcion;
		this.estado= estado;
		this.usuarios= usuarios;
		this.permisos= permisos;
	}

	public ArrayList<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(ArrayList<Permiso> permisos) {
		this.permisos = permisos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
