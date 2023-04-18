package CapaLogica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona implements Serializable{
	/**
	 * 
	 */
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
		if(finder == null) {
			Scanner sc = new Scanner(System.in);
			String confirmar = "no";
			while(confirmar.equals("no")) {
				System.out.println("Eres un cliente nuevo, procederemos a crear tu usuario ");
				System.out.print("Introduzca su Nombre: ");
				String nombre = sc.nextLine(); 
				System.out.print("Introduzca su Cedula: ");
				Long cedula1 = sc.nextLong(); 
				sc.nextLine();
				System.out.print("Introduzca su Telefono: ");
				Long telefono = sc.nextLong(); 
				System.out.print("Introduzca su Correo: ");
				String correo = sc.nextLine(); 
				sc.nextLine();
				System.out.print("Introduzca su Dirección: ");
				String direccion = sc.nextLine(); 
				
				System.out.print("Introduzca su Marca de Interes: ");
				String modelo = sc.nextLine(); 
			
				System.out.print("Introduzca su Presupuesto: ");
				long presupuesto = sc.nextLong(); 
				Cliente cli = new Cliente(nombre, cedula1, telefono, correo, direccion, modelo, presupuesto);
				System.out.print(cli.toString());
				System.out.print("Confirmar cliente (si/no): ");
				confirmar = sc.nextLine(); 
				finder = cli;
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
