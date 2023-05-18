package gestorAplicacion.personal;

import java.io.Serializable;

import gestorAplicacion.activos.Auto;
import gestorAplicacion.activos.TransaccionTaller;

public abstract class Trabajador extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
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
	
	public void pago(Mecanico mec) {
		double suma=0;
		for (TransaccionTaller t: TransaccionTaller.getTransaccionestal()) {
			if (t.getMecanico()==mec) {
				suma+=(t.getIngreso())*0.15;
			}
		}
		mec.setSalario(suma+mec.getSalario());
	}
	
	public void pago(Vendedor vend, Auto a) {
		vend.setSalario(vend.getSalario()+((a.getPrecio())*0.02));
	}
	
	abstract int calcularSalario();
	
	
}
