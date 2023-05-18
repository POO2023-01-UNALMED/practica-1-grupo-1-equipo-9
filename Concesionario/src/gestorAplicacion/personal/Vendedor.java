package gestorAplicacion.personal;

import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicacion.activos.*;

public class Vendedor extends Trabajador implements Serializable{
	private static final long serialVersionUID = 1L;
	static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
	int ventas = 0;
	String puesto; 
	final static double comision = 0.02;
	

	public Vendedor(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco,String puesto) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.puesto=puesto;
		vendedores.add(this);
	}

	public Vendedor(String nombre, long cedula, long telefono, String correo, double salario, String banco,
			long cuentaBanco,String puesto) {
		super(nombre, cedula, telefono, correo, salario, banco, cuentaBanco);
		this.puesto=puesto;
		vendedores.add(this);
	}

	public static ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}
	
	public static Vendedor getVendedorPorCedula(long cedula){
		Vendedor finder = null;
		for(Vendedor vendedor: vendedores) {
			if(vendedor.getCedula()==cedula) {
				finder = vendedor;
			} 
		
		}return finder;
	}

	public static void addVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}

	public static void removeVendedor(Vendedor vendedor) {
		vendedores.remove(vendedor);
	}
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

	@Override
	int calcularSalario() {
		return (int) (getSalario()+(ventas*comision));
	}
	
	public String info() {
		String texto = "Nombre del Vendedor: " + getNombre() + "\n";
		return texto;
	}
	
	public void confirmarVenta() {
		ventas++;
	}
	public static ArrayList<Vendedor> selectorVend(Auto o) {
		String vende=null;
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
			vende="Vitrina";
			for (Vendedor vendedor : getVendedores()) {
    	        if (vende.equals(vendedor.getPuesto())) {
    	            vendedores.add(vendedor);
    	        }
		}
			return vendedores;		
	}
	public static ArrayList<Vendedor> selectorVend(Articulo o) {
		String vende=null;
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		vende="Repuestos";
			for (Vendedor vendedor : getVendedores()) {
    	        if (vende.equals(vendedor.getPuesto())) {
    	            vendedores.add(vendedor);
    	        }
		}
			return vendedores;		
	}
}