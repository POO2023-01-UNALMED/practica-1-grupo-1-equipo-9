package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Vendedor;

public class TransaccionVentaPersonalizacion extends Transaccion implements Serializable{
	private static final long serialVersionUID = 1L;
	Articulo articulo;
	Vendedor vendedor;
	static ArrayList<TransaccionVentaPersonalizacion> transaccionesventaPersonalizacion = new ArrayList<TransaccionVentaPersonalizacion>();
	
	public TransaccionVentaPersonalizacion(String tipo, long ingreso, Cliente cliente, Articulo articulo, Vendedor vendedor) {
		super(tipo, ingreso, cliente);
		this.articulo=articulo;
		this.vendedor=vendedor;
		TransaccionVentaPersonalizacion.transaccionesventaPersonalizacion.add(this);
	}
	@Override
	public String info() {
		 String txt = String.format("Transacción #%08d: venta realizada por %s para el cliente %s por un total de $%d por el articulo %s",
		            numtrans, vendedor.getNombre(), cliente.getNombre(), articulo.getPrecio(), articulo.getMarca());
			
		
		return txt;
	}
	public static Cliente getClientePorCedula(long cedula){
		Transaccion finder = null;
		Cliente cli=null;
		
		for(Transaccion trans: transaccionesventaPersonalizacion) {
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
		for (TransaccionVentaPersonalizacion trans: transaccionesventaPersonalizacion) {
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
	public static void agregarTransaccion(TransaccionVentaPersonalizacion transaccion) {
		transaccionesventaPersonalizacion.add(transaccion);
	}

	public static void eliminarTransaccion(TransaccionVentaPersonalizacion transaccion) {
		transaccionesventaPersonalizacion.remove(transaccion);
	}

	public static ArrayList<TransaccionVentaPersonalizacion> getTransaccionespersonalizacion() {
	    return transaccionesventaPersonalizacion;
	}
	
}
