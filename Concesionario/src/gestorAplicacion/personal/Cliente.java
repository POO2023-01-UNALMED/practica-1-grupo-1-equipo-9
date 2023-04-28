package gestorAplicacion.personal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.activos.*;

public class Cliente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private String modeloInteres;
	private long presupuesto;
	private Auto auto;

	public Cliente(String nombre, long cedula, long telefono, String correo, String direccion, String modeloInteres,
			long presupuesto) {
		super(nombre, cedula, telefono, correo, direccion);
		this.modeloInteres = modeloInteres;
		this.presupuesto = presupuesto;
		Cliente.clientes.add(this);
	}

	public Cliente(String nombre, long cedula, long telefono, String correo, String modeloInteres, long presupuesto) {
		super(nombre, cedula, telefono, correo);
		this.modeloInteres = modeloInteres;
		this.presupuesto = presupuesto;
		Cliente.clientes.add(this);
	}

	public String getModeloInteres() {
		return modeloInteres;
	}

	public long getPresupuesto() {
		return presupuesto;
	}

	public void setModeloInteres(String modeloInteres) {
		this.modeloInteres = modeloInteres;
	}

	public void setPresupuesto(long presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public Auto getAuto() {
		return auto;
	}
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public static Cliente getClientePorCedula(long cedula){
		Cliente finder = null;
		for(Cliente cliente: clientes) {
			if(cliente.getCedula() == cedula) {
				finder = cliente;
				break;
			}
		}
		return finder;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Cliente.clientes = clientes;
	}
	
	public String info() {
		String texto = "Nombre del cliente: " + getNombre() + "\n";
		return texto;
	}
}
