package CapaLogica;

import java.util.ArrayList;

public class Cliente extends Persona {
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	String modeloInteres;
	int presupuesto;

	public Cliente(String nombre, long cedula, long telefono, String correo, String direccion, String modeloInteres,
			int presupuesto) {
		super(nombre, cedula, telefono, correo, direccion);
		this.modeloInteres = modeloInteres;
		this.presupuesto = presupuesto;
		Cliente.clientes.add(this);
	}

	public Cliente(String nombre, long cedula, long telefono, String correo, String modeloInteres, int presupuesto) {
		super(nombre, cedula, telefono, correo);
		this.modeloInteres = modeloInteres;
		this.presupuesto = presupuesto;
		Cliente.clientes.add(this);
	}

	public String getModeloInteres() {
		return modeloInteres;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setModeloInteres(String modeloInteres) {
		this.modeloInteres = modeloInteres;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public static Cliente getClientePorCedula(long cedula){
		Cliente finder = null;
		for(Cliente cliente: clientes) {
			if(cliente.getCedula()==cedula) {
				finder = cliente;
			} 
		
		}return finder;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Cliente.clientes = clientes;
	}
	
	public String toString() {
		String texto = "Nombre del cliente: " + super.getNombre() + "\n";
		return texto;
	}
}
