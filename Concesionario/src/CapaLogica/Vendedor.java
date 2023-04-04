package CapaLogica;

import java.util.ArrayList;

public class Vendedor extends Trabajador {
	static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
	int numeroVentas = 0;
	final static double comision = 0.02;

	public Vendedor(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		vendedores.add(this);
	}

	public Vendedor(String nombre, long cedula, long telefono, String correo, double salario, String banco,
			long cuentaBanco) {
		super(nombre, cedula, telefono, correo, salario, banco, cuentaBanco);
		vendedores.add(this);
	}

	public static ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public static void addVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}

	public static void removeVendedor(Vendedor vendedor) {
		vendedores.remove(vendedor);
	}
}
