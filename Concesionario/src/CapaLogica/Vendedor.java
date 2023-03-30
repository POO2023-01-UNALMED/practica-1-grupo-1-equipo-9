package CapaLogica;

public class Vendedor extends Trabajadores {

	int numeroVentas=0;
	final static double comision=0.02;
	
	public Vendedor(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
	}
	public Vendedor(String nombre, long cedula, long telefono, String correo, double salario,
			String banco, long cuentaBanco) {
		super(nombre, cedula, telefono, correo,salario, banco, cuentaBanco);
	}
	
}
