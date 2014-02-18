package com.example.bdcentros;

public class Centros {

	private String codCentro;
	private String nombrecentro;
	private String direccion;
	public Centros(String cod, String nom, String dir)
	{
		codCentro = cod;
		nombrecentro =nom;
		direccion=dir;
	}
	public String getDireccion() 
	{
		return direccion;
	}
	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}
	public String getCodCentro() 
	{
		return codCentro;
	}
	public void setCodCentro(String codCentro) 
	{
		this.codCentro = codCentro;
	}
	public String getNomCentro() 
	{
		return nombrecentro;
	}
	public void setNomCentro(String nomCentro) 
	{
		this.nombrecentro = nomCentro;
	}
	
	
}

