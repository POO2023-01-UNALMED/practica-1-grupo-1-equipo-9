package CapaLogica;

import java.util.ArrayList;

public class Transaccion {
	static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
	String tipo;
	Vendedor vendedor;
	Mecanico mecanico;
	long ingreso;
	Cliente cliente;
	Auto auto;
	Articulo articulo;
	static long numtrans=00000001;
	
	
	public Transaccion(String tipo,Vendedor vendedor,long ingreso,Cliente cliente,Auto auto) {
		this.tipo=tipo;
		this.vendedor=vendedor;
		this.ingreso=ingreso;
		this.cliente=cliente;
		this.auto=auto;
		transacciones.add(this);
		++numtrans;
	}
	public Transaccion(String tipo,Mecanico mecanico,long ingreso,Cliente cliente,Auto auto,Articulo articulo) {
		this.tipo=tipo;
		this.mecanico=mecanico;
		this.ingreso=ingreso;
		this.cliente=cliente;
		this.auto=auto;
		this.articulo=articulo;
		transacciones.add(this);
		++numtrans;
	}
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public void setIngreso(long ingreso) {
        this.ingreso = ingreso;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getTipo() {
        return tipo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public long getIngreso() {
        return ingreso;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public long getClienteCed() {
        return cliente.getCedula();
    }
    
	public static Cliente getClientePorCedula(long cedula){
		Transaccion finder = null;
		Cliente cli=null;
		
		for(Transaccion trans: transacciones) {
			if(trans.getClienteCed()== cedula) {
				finder = trans;
				cli=finder.getCliente();
				break;
			}
		}
		return cli;
	}
	public static Transaccion getTransaccionporCedula(long cedula) {
		Transaccion finder = null;
		for (Transaccion trans: transacciones) {
			if(trans.getClienteCed()== cedula) {
				finder = trans;
				
				break;
			}
		}
		return finder;
	}

    public Auto getAuto() {
        return auto;
    }

    public static long getNumtrans() {
        return numtrans;
    }

    public static void setNumtrans(long numtrans) {
        Transaccion.numtrans = numtrans;
    }
    public String info() {
    	String txt = null;
		if(getTipo().equals("venta")){
		   txt = String.format("Transacción #%08d: %s realizada por %s para el cliente %s por un total de $%d por el auto %s",
		            numtrans, getTipo(), vendedor.getNombre(), cliente.getNombre(), auto.getPrecio(), auto.getModelo());
			
		}
		else {
			txt = String.format("Transacción #%08d: %s realizado por %s para el cliente %s por un total de $%d por el auto %s",
		            numtrans, getTipo(), getMecanico(), getCliente(), getIngreso(), getAuto());
			
			
		}
		return txt;
	}
    
}
	


