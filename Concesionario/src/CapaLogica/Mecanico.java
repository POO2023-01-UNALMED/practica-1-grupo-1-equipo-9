package CapaLogica;

import java.util.ArrayList;

public class Mecanico extends Trabajador {
	static ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
	String[] autos;
	long pagoSvcs=0;

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, String[] autos) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = autos;
		Mecanico.mecanicos.add(this);
	}

	public String[] getAutos() {
		return autos;
	}

	public void setAutos(String[] autos) {
		this.autos = autos;
	}
	
	public static ArrayList<Mecanico> getMecanicos() {
		return mecanicos;
	}
	
	public static void setMecanicos(ArrayList<Mecanico> mecanicos) {
		Mecanico.mecanicos = mecanicos;
	}

	@Override
	int calcularSalario() {
		return (int) (pagoSvcs+getSalario());
	}
}
