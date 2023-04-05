package CapaLogica;

import java.util.ArrayList;

public class Mecanico extends Trabajador {
	ArrayList<Auto> autos;
	long pagoSvcs=0;

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, ArrayList<Auto> autos) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = new ArrayList<Auto>();
	}

	public ArrayList<Auto> getAutos() {
		return autos;
	}

	public void setAutos(ArrayList<Auto> autos) {
		this.autos = autos;
	}

	@Override
	int calcularSalario() {
		return (int) (pagoSvcs+getSalario());
	}
}
