package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import gestorAplicacion.activos.*;
import gestorAplicacion.personal.*;

public class Serializador {
	
	public static void serializarArrays(ArrayList<? extends Object> array, String name) {
		
		File archivo = new File("");
		
		try{
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/temp/"+name+".txt");
			
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(ruta));
			
			escribiendo_fichero.writeObject(array);
			
			escribiendo_fichero.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.print("FileNotFound");
		} catch (IOException e) {
			System.out.print("IOException");
		}
	}
	
	public static void serializarArrays() {
		Serializador.serializarArrays(InventarioAuto.getAutos(), "Autos");
		Serializador.serializarArrays(Cliente.getClientes(), "Clientes");
		Serializador.serializarArrays(Mecanico.getMecanicos(), "Mecanicos");
		Serializador.serializarArrays(Vendedor.getVendedores(), "Vendedores");
		Serializador.serializarArrays(InventarioArticulo.getArticulos(), "Articulos");
		Serializador.serializarArrays(InventarioArticulo.getRepuesto(), "Repuestos");
		Serializador.serializarArrays(Transaccion.getTransacciones(), "Transacciones");
		Serializador.serializarArrays(TransaccionVenta.getTransaccionesven(), "TransaccionesVentas");
		Serializador.serializarArrays(TransaccionVentaTaller.getTransaccionesven(), "TransaccionesVentaTaller");
		Serializador.serializarArrays(TransaccionTaller.getTransaccionestal(), "TransaccionesTaller");
		Serializador.serializarArrays(TransaccionModificacion.getTransaccionesmod(), "TransaccionesModificacion");
		Serializador.serializarArrays(TransaccionVenta.getAutosV(), "AutosV");
		Serializador.serializarArrays(TransaccionVenta.getMarcas(), "Marcas");
		Serializador.serializarArrays(TransaccionVenta.getVend(), "Vend");
		
	}
	
}