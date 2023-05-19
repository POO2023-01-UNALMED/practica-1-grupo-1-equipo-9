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
    
    
    public static long[] estResults(long[] listaFinanzas) {
        /// suma en ventas de carros y servicios y venta artículos del taller}
    	// carros
        long ventasautos = 0;
        for (TransaccionVenta transaccauto: TransaccionVenta.getTransaccionesven()) {
            ventasautos += transaccauto.getIngreso();
        }
        
        // taller
        long ventastaller = 0;
        for (TransaccionTaller transacctaller: TransaccionTaller.getTransaccionestal()) {
        	ventastaller +=transacctaller.getIngreso();
        }
        
        // articulos taller
        long arttaller=0;
        for (TransaccionVentaTaller t:TransaccionVentaTaller.getTransaccionesven()) {
        	arttaller+=t.getIngreso();
        }
        
        // transaccion modificacion
        long transaccmod=0;
        for (TransaccionModificacion m:TransaccionModificacion.getTransaccionesmod()) {
        	transaccmod+=m.getIngreso();
        }
        
        long ventas = ventasautos + ventastaller + arttaller + transaccmod;
        
        listaFinanzas[0]=ventas;
        
        /// suma en costos (pago vendedores y mecanicos)
        long pagoEmpleados=0;
        for (Vendedor vendedor:Vendedor.getVendedores()) {
        	pagoEmpleados+=vendedor.getSalario();
        }
        
        for (Mecanico mecanico:Mecanico.getMecanicos()) {
        	pagoEmpleados+=mecanico.getSalario();
        }
        
        listaFinanzas[1]=pagoEmpleados;
        
        /// suma en gastos (comisiones, servicios, y gastos fijos(?))
        long gastos = 0;
        
        //comisiones
        gastos+=ventasautos*0.02;
        // servicios y gastos fijos
        gastos+=10000000+7000000;
        
        listaFinanzas[2]=gastos;
        
        // impuestos (utilidad bruta * 33%)
        
        if (ventas-pagoEmpleados-gastos<0) {
        	listaFinanzas[3]=(long) (((ventas-pagoEmpleados-gastos)*0.33)*-1);
        } else {
        	listaFinanzas[3]=(long) ((ventas-pagoEmpleados-gastos)*0.33);
        }

        return listaFinanzas;
    }
    
    public abstract String info(); 
    
}
	


