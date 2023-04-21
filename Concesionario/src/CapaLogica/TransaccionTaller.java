package CapaLogica;

import java.util.ArrayList;

public class TransaccionTaller extends Transaccion {
	Auto auto;
	Mecanico mecanico;
	Articulo articulo;
	static ArrayList<TransaccionTaller> transaccionestal = new ArrayList<TransaccionTaller>();
	
	public TransaccionTaller(String tipo, long ingreso, Cliente cliente, Auto auto,Articulo articulo, Mecanico mecanico) {
		super(tipo, ingreso, cliente);
		this.auto=auto;
		this.mecanico=mecanico;
		this.articulo=articulo;
	}
	@Override
	public String info() {
		String txt = String.format("Transacción #%08d: %s realizado por %s para el cliente %s por un total de $%d",
	            numtrans, getTipo(), mecanico.getNombre(), cliente.getNombre(), getIngreso());
			
		
		return txt;
	}
	public static Cliente getClientePorCedula(long cedula){
		Transaccion finder = null;
		Cliente cli=null;
		
		for(Transaccion trans: transaccionestal) {
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
		for (TransaccionTaller trans: transaccionestal) {
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
	public static void agregarTransaccion(TransaccionTaller transaccion) {
	    transaccionestal.add(transaccion);
	}

	public static void eliminarTransaccion(TransaccionTaller transaccion) {
	    transaccionestal.remove(transaccion);
	}

	public static ArrayList<TransaccionTaller> getTransaccionestal() {
	    return transaccionestal;
	}
}



