package CapaLogica;



public class Mecanico extends Trabajador {
	String[] autos;
	long pagoSvcs=0;

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, String[] autos) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = autos;
	}

	public String[] getAutos() {
		return autos;
	}

	public void setAutos(String[] autos) {
		this.autos = autos;
	}

	@Override
	int calcularSalario() {
		return (int) (pagoSvcs+getSalario());
	}
}
