package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.personal.*;

public class TransaccionVenta extends Transaccion implements Serializable{
	private static final long serialVersionUID = 1L;
	private Auto auto;
	private Vendedor vendedor;
	static ArrayList<TransaccionVenta> transaccionesven = new ArrayList<TransaccionVenta>();
	static ArrayList<Auto> autosV = new ArrayList<Auto>();
	static ArrayList<Vendedor> vend = new ArrayList<Vendedor>();
	static ArrayList<String> marcas = new ArrayList<>();
	
	public TransaccionVenta(String tipo, long ingreso, Cliente cliente, Auto auto, Vendedor vendedor, int transfer) {
		super(tipo, ingreso, cliente, transfer);
		this.auto=auto;
		this.vendedor=vendedor;
		transaccionesven.add(this);
		autosV.add(this.auto);
	}
	
	@Override
	public String info() {
		 String txt = String.format("Transacción #%08d: venta realizada por %s para el cliente %s por un total de $%d por el auto %s",
		            transfer, vendedor.getNombre(), cliente.getNombre(), auto.getPrecio(), auto.getModelo());
			
		
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
	
	// metodo para obtener los vendedores de las ventas realizadas y agregarlos a la lista "vendedores"
	public static ArrayList<Vendedor> vendedoresVentas(ArrayList<TransaccionVenta> ventas) {
	    for (TransaccionVenta transacc: ventas) {
	    	if (vend.contains(transacc.getVendedor())) {
	    	} else {
	    		vend.add(transacc.getVendedor());
	    	}
	    }
	    return vend;
	}
	
	public static ArrayList<String> marcasVentas(ArrayList<Auto> autosIniciales){
		for (Auto a: autosIniciales) {
			if (marcas.contains(a.getMarca())) {
			} else {
				marcas.add(a.getMarca());
			}
		}
		return marcas;
	}
	
	public static ArrayList<Auto> getAutosV(){
		return autosV;
	}
	
	public static long getIngresoPorAuto(Auto auto){
		for (TransaccionVenta transacc: TransaccionVenta.getTransaccionesven()) {
			if (transacc.getAuto()==auto) {
				return transacc.getIngreso();
			}
		}
		return 0;
	}
    public static ArrayList<Vendedor> getVend() {
        return vend;
    }

    public static void setVend(ArrayList<Vendedor> vendedores) {
        vend = vendedores;
    }

    public static ArrayList<String> getMarcas() {
        return marcas;
    }

    public static void setMarcas(ArrayList<String> listaMarcas) {
        marcas = listaMarcas;
    }
}
