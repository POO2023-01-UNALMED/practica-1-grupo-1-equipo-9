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
	
	public static Transaccion getTransaccionPorTransfer(int transfer) {
		
		Transaccion obj = null;
		
		for (Transaccion t:transacciones) {
			if (t.getTransfer()==transfer) {
				obj=t;
				break;
			}
		}
		return obj;
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
    
    
    public static ArrayList<Long> estResults(ArrayList<Long> lista) {
        // suma en ventas
        long ventas = 0;
        long c = 0;
        for (Transaccion transaccion: transacciones) {
            ventas += transaccion.getIngreso();
        }
        lista.set(0, ventas);
        
        // suma en costos (pago vendedores y mechs)
        long pagoEmpleados=0;
        for (Vendedor vendedor:Vendedor.getVendedores()) {
        	pagoEmpleados+=vendedor.getSalario();
        }
        
        for (Mecanico mecanico:Mecanico.getMecanicos()) {
        	pagoEmpleados+=mecanico.getSalario();
        }
        
        lista.set(1, pagoEmpleados);
        
        //suma en gastos (comisiones, servicios, y gastos fijos(?))
        // utilidad bruta
        // utilidad neta (-33%)

        return lista;
    }

    
    
    public abstract String info(); 
    
}
	


