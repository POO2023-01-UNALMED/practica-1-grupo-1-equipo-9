package gestorAplicacion.personal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.activos.*;

public class Cliente implements Persona, Serializable{

	private static final long serialVersionUID = 1L;
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	protected String nombre;
	protected long cedula;
	protected long telefono;
	protected String correo;
	protected String direccion;
	private String modeloInteres;
	private long presupuesto;
	private Auto auto;

	public Cliente(String nombre, long cedula, long telefono, String correo, String direccion, String modeloInteres,
			long presupuesto) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.modeloInteres = modeloInteres;
		this.presupuesto = presupuesto;
		Cliente.clientes.add(this);
	}

	public Cliente(String nombre, long cedula, long telefono, String correo, String modeloInteres, long presupuesto) {
		this(nombre,cedula,telefono,correo,"Medellin",modeloInteres,presupuesto);
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
	@Override
	public String info() {
		String texto = "Nombre del cliente: " + getNombre() + "\n";
		return texto;
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
}
