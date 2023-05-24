package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.personal.*;

public class TransaccionModificacion extends Transaccion implements Serializable{
	private static final long serialVersionUID = 1L;
	Auto auto;
	Mecanico mecanico;
	Vendedor vendedor;
	
	public TransaccionModificacion(String tipo, long ingreso, Cliente cliente, Auto auto, Mecanico mecanico, Articulo articulo, int transfer) {
		super(tipo, ingreso, cliente, transfer);
		this.auto=auto;
		this.mecanico=mecanico;
		this.articulo=articulo;
		TransaccionModificacion.transaccionesmod.add(this);
		
	}
	public TransaccionModificacion(String tipo, long ingreso, Cliente cliente, Auto auto, Vendedor vendedor, Articulo articulo, int transfer) {
		super(tipo, ingreso, cliente, transfer);
		this.auto=auto;
		this.vendedor=vendedor;
		this.articulo=articulo;
		TransaccionModificacion.transaccionesmod.add(this);
		
	}
	
	static ArrayList<TransaccionModificacion> transaccionesmod = new ArrayList<TransaccionModificacion>();
	
	@Override
	public String info() {
		String txt = String.format("Transacción" + transfer + getTipo() + "realizada por el vendedor" + vendedor.getNombre() + "para el cliente"  
				+ cliente.getNombre()+ "que adquirio el producto:  " + articulo.getTipoArticulo()+ "de la marca: " +  articulo.getMarca() + "con precio total de" + getIngreso());
		return txt;
	}
	public String info2() {
		String txt = String.format("Transacción" + transfer + getTipo() + "realizada por el mecanico" + mecanico.getNombre() + "para el cliente"  
				+ cliente.getNombre()+ "que adquirio el producto:  " + articulo.getTipoArticulo()+ "de la marca: " +  articulo.getMarca() + "con precio total de" + getIngreso());
		return txt;
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
	
	public static Auto getTransaccionporCedula(long cedula) {
		Auto finder = null;
		for (TransaccionModificacion trans: transaccionesmod) {
			if(trans.getClienteCed()== cedula) {
				finder = trans.getAuto();
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
