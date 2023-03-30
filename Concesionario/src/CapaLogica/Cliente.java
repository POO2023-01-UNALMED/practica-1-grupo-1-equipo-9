package CapaLogica;

public class Cliente extends Personas{

	public Cliente(String nombre, long cedula, long telefono, String correo, String direccion) {
		super(nombre, cedula, telefono, correo, direccion);
	}

	public Cliente(String nombre, long cedula, long telefono, String correo) {
		super(nombre, cedula, telefono, correo);
	}
}
