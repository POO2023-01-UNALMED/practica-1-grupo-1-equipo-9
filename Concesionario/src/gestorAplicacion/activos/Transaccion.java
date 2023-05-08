package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.personal.*;

public abstract class Transaccion implements Serializable{
	private static final long serialVersionUID = 1L;
	static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
	String tipo;
	int transfer;
	Mecanico mecanico;
	long ingreso;
	Cliente cliente;
	Articulo articulo;
	static long numtrans=00000001;
	
	
	public Transaccion(String tipo,long ingreso,Cliente cliente, int transfer) {
		this.tipo=tipo;
		this.ingreso=ingreso;
		this.cliente=cliente;
		this.transfer=transfer;
		transacciones.add(this);
		++numtrans;
	}
	
	public static ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}
	
    public void setTipo(String tipo) {
        this.tipo = tipo;
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


    public String getTipo() {
        return tipo;
    }
    
    public void setTransfer(int transfer) {
        this.transfer = transfer;
    }
    
    public int getTransfer() {
        return transfer;
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
    



    public static long getNumtrans() {
        return numtrans;
    }

    public static void setNumtrans(long numtrans) {
        Transaccion.numtrans = numtrans;
    }
    
    public abstract String info(); 
    
    
    
}
	


