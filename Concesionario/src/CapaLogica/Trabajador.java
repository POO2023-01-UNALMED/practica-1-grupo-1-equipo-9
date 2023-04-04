package CapaLogica;

public abstract class Trabajador extends Persona {
	double salario;
	String banco;
	long cuentaBanco;

	public Trabajador(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco) {
		super(nombre, cedula, telefono, correo, direccion);
		this.salario = salario;
		this.banco = banco;
		this.cuentaBanco = cuentaBanco;
	}

	public Trabajador(String nombre, long cedula, long telefono, String correo, double salario, String banco,
			long cuentaBanco) {
		super(nombre, cedula, telefono, correo);
		this.salario = salario;
		this.banco = banco;
		this.cuentaBanco = cuentaBanco;
	}

	public double getSalario() {
		return salario;
	}

	public String getBanco() {
		return banco;
	}

	public long getCuentaBanco() {
		return cuentaBanco;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setCuentaBanco(long cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}
	abstract int calcularSalario();
}
