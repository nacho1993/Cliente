package Controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import Connect.DBConnect;
import Objetos.Consultorio;
import Objetos.Doctor;
import Objetos.Paciente;
import Objetos.Tabla;
import Objetos.Turno;
import login.Formulario;
import login.Grupo;
import login.Usuario;

public class Consulta {

	public static String consultagenerica(String tabla, String accion) {
		String stringtabla="";
		DBConnect bd = new DBConnect();
		
		String con = "SELECT * FROM " + tabla;
		ResultSet resultado = bd.consulta(con);
		
		switch (tabla) {
		case "doctor":
//			arma una lista con todos los doctores
			ArrayList<Doctor> docarr = new ArrayList<Doctor>();
			try {
				while (resultado.next()) {
					Doctor doc;
					  int id = resultado.getInt("id");
					  int dni = resultado.getInt("dni");
					  String nombre = resultado.getString("Nombre");
					  String apellido = resultado.getString("Apellido");
//					  String domicilio = resultado.getString("Domicilio");
					  String domicilio = "nananan";
					  String especialidad = resultado.getString("Especialidad");
					  int matricula = resultado.getInt("Matricula"); 
 					  Boolean estado = resultado.getBoolean("Estado");
					 doc = new Doctor(id, dni, nombre, apellido, domicilio, especialidad, matricula, estado);
					 docarr.add(doc);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>DNI</th>"+
				"<th>Nombre</th>"+
				"<th>Apellido</th>"+
//				"<th>Domicilio</th>"+
				"<th>Especialidad</th>"+
				"<th>Matricula</th>"+
				"<th>Estado</th>"+
			"</tr>";
			
			for (Doctor doctor : docarr) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ doctor.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ doctor.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ doctor.getDni() +"</td>"+
					"<td>"+ doctor.getNombre()  +"</td>"+
					"<td>"+ doctor.getApellido() +"</td>"+
//					"<td>"+ doctor.getDomicilio() +"</td>"+
					"<td>"+ doctor.getEspecialidad() +"</td>"+
					"<td>"+ doctor.getMatricula() +"</td>";
					if (doctor.getEstado()){
						stringtabla = stringtabla +
						"<td>Habilitado</td>";
					}else{ 
						stringtabla = stringtabla +
					"<td>Deshabilitado</td>";
					}
				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;
//			--------------------------------------------------------------------------------------
		case "paciente":
//			arma una lista con todos los doctores
			ArrayList<Paciente> pasarr = new ArrayList<Paciente>();
			try {
				while (resultado.next()) {
					Paciente pas;
					  int id = resultado.getInt("id");
					  int dni = resultado.getInt("dni");
					  String nombre = resultado.getString("Nombre");
					  String apellido = resultado.getString("Apellido");
//					  String domicilio = resultado.getString("Domicilio");
					  String domicilio = "nananan";
					  String fecnac = resultado.getString("fechanacimiento");
					  String obrasocial = resultado.getString("obrasocial");
					  int legajo = resultado.getInt("legajo"); 
 					  Boolean estado = resultado.getBoolean("Estado");
					 pas = new Paciente(id, dni, nombre, apellido, domicilio, legajo, fecnac, obrasocial, estado);
					 pasarr.add(pas);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>DNI</th>"+
				"<th>Nombre</th>"+
				"<th>Apellido</th>"+
//				"<th>Domicilio</th>"+
				"<th>Legajo</th>"+
				"<th>fecnac</th>"+
				"<th>Obrasocial</th>"+
				"<th>Estado</th>"+
			"</tr>";
			
			for (Paciente pasiente : pasarr) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ pasiente.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ pasiente.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ pasiente.getDni() +"</td>"+
					"<td>"+ pasiente.getNombre()  +"</td>"+
					"<td>"+ pasiente.getApellido() +"</td>"+
//					"<td>"+ doctor.getDomicilio() +"</td>"+
					"<td>"+ pasiente.getLegajo() +"</td>"+
					"<td>"+ pasiente.getFecnac() +"</td>"+
					"<td>"+ pasiente.getObrasocial() +"</td>";
					if (pasiente.getEstado()){
						stringtabla = stringtabla +
						"<td>Habilitado</td>";
					}else{ 
						stringtabla = stringtabla +
					"<td>Deshabilitado</td>";
					}
				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;
//			--------------------------------------------------------------------------------------
		case "consultorio":
//			arma una lista con todos los doctores
			ArrayList<Consultorio> conarr = new ArrayList<Consultorio>();
			try {
				while (resultado.next()) {
					Consultorio consul;
					  int id = resultado.getInt("id");
					  int numero = resultado.getInt("numero");
					  int piso = resultado.getInt("piso"); 
 					  Boolean estado = resultado.getBoolean("Estado");
					 consul = new Consultorio(id, numero, piso, estado);
					 conarr.add(consul);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>Numero</th>"+
				"<th>Piso</th>"+
				"<th>Estado</th>"+
			"</tr>";
			
			for (Consultorio consultorio : conarr) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+  consultorio.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ consultorio.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ consultorio.getNumero() +"</td>"+
					"<td>"+ consultorio.getPiso() +"</td>";
					if (consultorio.getEstado()){
						stringtabla = stringtabla +
						"<td>Habilitado</td>";
					}else{ 
						stringtabla = stringtabla +
					"<td>Deshabilitado</td>";
					}
				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;
//			--------------------------------------------------------------------------------------
		case "usuario":
//			arma una lista con todos los doctores
			ArrayList<Usuario> usu = new ArrayList<Usuario>();
			try {
				while (resultado.next()) {
					Usuario usr;
					  int id = resultado.getInt("id");
					  String usuario = resultado.getString("Usuario");
					  String password = resultado.getString("Password");
					  String nombre = resultado.getString("Nombre");
					  String apellido = resultado.getString("Apellido");
					  String mail = resultado.getString("Mail");
					  Boolean estado = resultado.getBoolean("Estado");
					 usr = new Usuario(id, usuario, password, nombre, apellido, mail, estado);
					 usu.add(usr);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>Usuario</th>"+
				"<th>Contraseña</th>"+
				"<th>Nombre</th>"+
				"<th>Apellido</th>"+
				"<th>Mail</th>"+
				"<th>Estado</th>"+
			"</tr>";
			
			for (Usuario usuario : usu) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ usuario.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ usuario.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ usuario.getUsuario() +"</td>"+
					"<td> ******** </td>"+
					"<td>"+ usuario.getNombre() +"</td>"+
					"<td>"+ usuario.getApellido() +"</td>"+
					"<td>"+ usuario.getEmail() +"</td>";
					if (usuario.isEstado()){
						stringtabla = stringtabla +
						"<td>Habilitado</td>";
					}else{ 
						stringtabla = stringtabla +
					"<td>Deshabilitado</td>";
					}
				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;
//			--------------------------------------------------------------------------------------
		case "grupo":
//			arma una lista con todos los doctores
			ArrayList<Grupo> gruarr = new ArrayList<Grupo>();
			try {
				while (resultado.next()) {
					Grupo gru;
					  int id = resultado.getInt("id");
					  String descripcion = resultado.getString("descripcion"); 
 					  Boolean estado = resultado.getBoolean("Estado");
					 gru = new Grupo(id, descripcion, estado);
					 gruarr.add(gru);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>Descripcion</th>"+
				"<th>Estado</th>"+
			"</tr>";
			
			for (Grupo grupo : gruarr) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+  grupo.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ grupo.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ grupo.getDescripcion() +"</td>";
					if (grupo.isEstado()){
						stringtabla = stringtabla +
						"<td>Habilitado</td>";
					}else{ 
						stringtabla = stringtabla +
					"<td>Deshabilitado</td>";
					}
				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;	
//			--------------------------------------------------------------------------------------
		case "formulario":
//			arma una lista con todos los doctores
			ArrayList<Formulario> forarr = new ArrayList<Formulario>();
			try {
				while (resultado.next()) {
					Formulario formu;
					  int id = resultado.getInt("id");
					  String descripcion = resultado.getString("descripcion"); 
// 					  Boolean estado = resultado.getBoolean("Estado");
					 formu = new Formulario(id, descripcion);
					 forarr.add(formu);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>Descripcion</th>"+
//				"<th>Estado</th>"+
			"</tr>";
			
			for (Formulario formulario : forarr) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+  formulario.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ formulario.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ formulario.getDescripcion() +"</td>";
//					if (grupo.isEstado()){
//						stringtabla = stringtabla +
//						"<td>Habilitado</td>";
//					}else{ 
//						stringtabla = stringtabla +
//					"<td>Deshabilitado</td>";
//					}
				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;	
//			--------------------------------------------------------------------------------------
		case "turno":
//			arma una lista con todos los doctores
			ArrayList<Turno> turarr = new ArrayList<Turno>();
			try {
				while (resultado.next()) {
					Turno tur;
					  int id = resultado.getInt("id");
					  String fecha= resultado.getString("fecha"); 
					  int doctor = resultado.getInt("doctor");
					  int paciente = resultado.getInt("paciente");
					  int consultorio = resultado.getInt("consultorio");
					  tur = new Turno(id, fecha, doctor, paciente, consultorio);
					 turarr.add(tur);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
//			arma una tabla para modificacioon y baja 
			stringtabla = stringtabla +
			"<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"+
			"<table class=\"table table-condensed table-bordered\" id=\"myTable\">"+
			"<tr>"+
				"<th></th>"+
				"<th>Fecha</th>"+
				"<th>Doctor</th>"+
				"<th>Paciente</th>"+
				"<th>Consultorio</th>"+
			"</tr>";
			
			for (Turno turno : turarr) {
					stringtabla = stringtabla+
				"<tr>";
					if(accion.equals("M")) {
						stringtabla = stringtabla +
								"<td><form class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+  turno.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-edit btn btn-default transparencia\"></button></form></td>";
					}else{
						stringtabla = stringtabla +
								"<td><form  class=\"centrar\" action=\"ServletBajMod\" method=\"post\">"+
								"<input type=\"hidden\" name=\"id\" value=\""+ turno.getId() +"\">"+
								"<input type=\"hidden\" name=\"accion\" value=\""+ accion +"\">"+
								"<button type=\"submit\" class=\"glyphicon glyphicon-trash btn btn-default transparencia\"></button></form></td>";
					}
					stringtabla = stringtabla +
					"<td>"+ turno.getFecha() +"</td>";
					
//					busca descripcion de doctor
					String sql= "SELECT * FROM doctor where id=" + turno.getDoctor();
					ResultSet doctorturno = bd.consulta(sql);
					try {
					if(doctorturno.next()) {
							String nombre = doctorturno.getString("nombre");
							String apellido = doctorturno.getString("apellido");
							stringtabla = stringtabla +
									"<td>"+nombre +" "+apellido  +"</td>";
					}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					
					
//					busca descripcion de paciente
					ResultSet pacienteturno = bd.consulta("SELECT * FROM paciente where id=" + turno.getPaciente());

						try {
							if(pacienteturno.next()) {
							stringtabla = stringtabla +
									"<td>"+ pacienteturno.getString("nombre")+" "+ pacienteturno.getString("apellido")  +"</td>";
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					
					
//					busca descripcion de consultorio
					ResultSet consultorioturno = bd.consulta("SELECT * FROM consultorio where id=" + turno.getConsultorio());
						try {
							if(consultorioturno.next()) {
							stringtabla = stringtabla +
									"<td>"+ consultorioturno.getInt("numero")+"</td>";
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					

				stringtabla = stringtabla + "</tr>";		
			 }
			stringtabla = stringtabla + "</table></form>";
			break;			
		default:
			break;
		}
		return stringtabla;

		

}}
