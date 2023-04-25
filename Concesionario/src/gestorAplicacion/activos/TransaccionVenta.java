package activos;

import java.util.ArrayList;

import personal.Cliente;
import personal.Vendedor;

public class TransaccionVenta extends Transaccion {
	Auto auto;
	Vendedor vendedor;
	static ArrayList<TransaccionVenta> transaccionesven = new ArrayList<TransaccionVenta>();
	
	public TransaccionVenta(String tipo, long ingreso, Cliente cliente, Auto auto, Vendedor vendedor) {
		super(tipo, ingreso, cliente);
		this.auto=auto;
		this.vendedor=vendedor;
		transaccionesven.add(this);
	}
	@Override
	public String info() {
		 String txt = String.format("Transacción #%08d: venta realizada por %s para el cliente %s por un total de $%d por el auto %s",
		            numtrans, vendedor.getNombre(), cliente.getNombre(), auto.getPrecio(), auto.getModelo());
			
		
		return txt;
	}
	public static Cliente getClientePorCedula(long cedula){
		Transaccion finder = null;
		Cliente cli=null;
		
		for(Transaccion trans: transaccionesven) {
			if(trans.getClienteCed()== cedula) {
				finder = trans;
				cli=finder.getCliente();
				break;
			}
		}
		return cli;
	}
	public static Auto getTransaccionporCedula(long cedula) {
		Auto finder = null;
		for (TransaccionVenta trans: transaccionesven) {
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
	public void setVendedor(Vendedor vendedor) {
	    this.vendedor = vendedor;
	}

	public Vendedor getVendedor() {
	    return vendedor;
	}
	public static void agregarTransaccion(TransaccionVenta transaccion) {
	    transaccionesven.add(transaccion);
	}

	public static void eliminarTransaccion(TransaccionVenta transaccion) {
	    transaccionesven.remove(transaccion);
	}

	public static ArrayList<TransaccionVenta> getTransaccionesven() {
	    return transaccionesven;
	}
	
}
