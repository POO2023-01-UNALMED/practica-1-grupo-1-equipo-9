package CapaLogica;

import java.util.ArrayList;

public class TransaccionModificacion extends Transaccion{
	

	Auto auto;
	Mecanico mecanico;
	Vendedor vendedor;
	Articulo articulo;
	
	public TransaccionModificacion(String tipo, long ingreso, Cliente cliente, Auto auto, Mecanico mecanico, Vendedor vendedor, Articulo articulo) {
		super(tipo, ingreso, cliente);
		this.auto=auto;
		this.mecanico=mecanico;
		this.vendedor=vendedor;
		this.articulo=articulo;
		
	}
	
	static ArrayList<TransaccionModificacion> transaccionesmod = new ArrayList<TransaccionModificacion>();
	
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return null;
	}
		
	public static Cliente getClientePorCedula(long cedula){
		Transaccion finder = null;
		Cliente client=null;
		
		for(Transaccion trans: transaccionesmod) {
			if(trans.getClienteCed()== cedula) {
				finder = trans;
				client=finder.getCliente();
				break;
			}
		}
		return client;
	}
	
	public static TransaccionModificacion getTransaccionporCedula(long cedula) {
		TransaccionModificacion finder = null;
		for (TransaccionModificacion trans: transaccionesmod) {
			if(trans.getClienteCed()== cedula) {
				finder = trans;
				break;
			}
		}
		return finder;
	}
	public void setAuto(Auto auto) {
	    this.auto = auto;
	}

	public Auto getAuto() {
	    return auto;
	}
	public void setMecanico(Mecanico mecanico) {
	    this.mecanico = mecanico;
	}

	public Mecanico getMecanico() {
	    return mecanico;
	}
	public void setArticulo(Articulo articulo) {
	    this.articulo = articulo;
	}

	public Articulo getArticulo() {
	    return articulo;
	}
	public static void agregarTransaccion(TransaccionModificacion transaccion) {
	    transaccionesmod.add(transaccion);
	}

	public static void eliminarTransaccion(TransaccionModificacion transaccion) {
	    transaccionesmod.remove(transaccion);
	}

	public static ArrayList<TransaccionModificacion> getTransaccionesmod() {
	    return transaccionesmod;
	}

	
	
}
