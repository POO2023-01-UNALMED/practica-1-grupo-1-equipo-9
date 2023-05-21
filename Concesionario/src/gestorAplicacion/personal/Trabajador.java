package gestorAplicacion.personal;

import java.io.Serializable;

import gestorAplicacion.activos.Auto;
import gestorAplicacion.activos.TransaccionTaller;

public abstract class Trabajador implements Persona,Serializable{
	private static final long serialVersionUID = 1L;
	String nombre;
	long cedula;
	long telefono;
	String correo;
	String direccion;
	double salario;
	String banco;
	long cuentaBanco;

	public Trabajador(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.salario = salario;
		this.banco = banco;
		this.cuentaBanco = cuentaBanco;
	}

	public Trabajador(String nombre, long cedula, long telefono, String correo, double salario, String banco,
			long cuentaBanco) {
		this(nombre,cedula,telefono,correo,"Medellin",salario,banco,cuentaBanco);
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
		mec.setSalario(mec.getManoObra()+mec.getSalario());
	}
	
	public void pago(Vendedor vend, Auto a) {
		vend.setSalario(vend.getSalario()+((a.getPrecio())*Vendedor.comision));
	}
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public long getCedula() {
		return cedula;
	}

	@Override
	public long getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}

	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}

	@Override
	public String getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public void setCedula(long cedula) {
		this.cedula=cedula;
	}

	@Override
	public void setTelefono(long telefono) {
		this.telefono=telefono;
	}

	@Override
	public void setCorreo(String correo) {
		this.correo=correo;
	}

	@Override
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	abstract int calcularSalario();
	
	
}
