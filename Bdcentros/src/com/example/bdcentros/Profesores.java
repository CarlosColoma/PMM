package com.example.bdcentros;

public class Profesores {

	private String codCentro;
	private String dni;
	private String apellidos;
	private String espec;
	
	
	public Profesores(String cod, String dn, String ape, String esp)
	{
		codCentro =cod;
		dni =dn;
		apellidos = ape;
		espec =esp;
				
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCodCentro() {
		return codCentro;
	}

	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}

	public String getEspecialidad() {
		return espec;
	}

	public void setEspecialidad(String especialidad) {
		this.espec = especialidad;
	}

	
}

