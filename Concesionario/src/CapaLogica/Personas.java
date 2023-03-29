package CapaLogica;

public class Personas {
	String nombre;
	long cedula;
	long telefono;
	String correo;
	String direccion;
	
	
	public Personas(String nombre,long cedula,long telefono,String correo,String direccion) {
		this.nombre=nombre;
		this.cedula=cedula;
		this.telefono=telefono;
		this.correo=correo;
		this.direccion=direccion;
	}
	public Personas(String nombre,long cedula,long telefono,String correo) {
		this(nombre, cedula, telefono, correo,"Medellin");		
	}
}
