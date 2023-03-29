package CapaLogica;

public class Trabajadores extends Personas{
	double salario;
	String banco;
	long cuentaBanco;
	int numeroVentas=0;
	
	
	public Trabajadores(String nombre, long cedula, long telefono, String correo, String direccion,double salario,String banco,long cuentaBanco) {
		super(nombre, cedula, telefono, correo, direccion);
		this.salario=salario;
		this.banco=banco;
		this.cuentaBanco=cuentaBanco;
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
}
