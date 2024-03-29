package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.personal.*;

public class TransaccionVentaTaller extends Transaccion implements Serializable{
	private static final long serialVersionUID = 1L;
	private Articulo articulo;
	private Vendedor vendedor;
	static ArrayList<TransaccionVentaTaller> transaccionesvental = new ArrayList<TransaccionVentaTaller>();
	
	public TransaccionVentaTaller(String tipo, long  ingreso, Cliente cliente, Articulo articulo, Vendedor vendedor, int transfer) {
		super(tipo, ingreso, cliente, transfer);
		this.articulo=articulo;
		this.vendedor=vendedor;
		TransaccionVentaTaller.transaccionesvental.add(this);
	}
	@Override
	public String info() {
		 String txt = String.format("Transacción #%08d: venta realizada por %s para el cliente %s por un total de $%d por el articulo %s",
		            transfer, vendedor.getNombre(), cliente.getNombre(), articulo.getPrecio(), articulo.getMarca());
			
		
		return txt;
	}
	public static Cliente getClientePorCedula(long cedula){
		Transaccion finder = null;
		Cliente cli=null;
		
		for(Transaccion trans: transaccionesvental) {
			if(trans.getClienteCed()== cedula) {
				finder = trans;
				cli=finder.getCliente();
				break;
			}
		}
		return cli;
	}
	public static Articulo getTransaccionporCedula(long cedula) {
		Articulo finder = null;
		for (TransaccionVentaTaller trans: transaccionesvental) {
			if(trans.getClienteCed()== cedula) {
				finder = trans.getArticulo();
				break;
			}
		}
		return finder;
	}

	public void setArticulo(Articulo articulo) {
	    this.articulo = articulo;
	}

	public Articulo getArticulo() {
	    return articulo;
	}
	public void setVendedor(Vendedor vendedor) {
	    this.vendedor = vendedor;
	}

	public Vendedor getVendedor() {
	    return vendedor;
	}
	public static void agregarTransaccion(TransaccionVentaTaller transaccion) {
	    transaccionesvental.add(transaccion);
	}

	public static void eliminarTransaccion(TransaccionVentaTaller transaccion) {
	    transaccionesvental.remove(transaccion);
	}

	public static ArrayList<TransaccionVentaTaller> getTransaccionesven() {
	    return transaccionesvental;
	}
	
}

