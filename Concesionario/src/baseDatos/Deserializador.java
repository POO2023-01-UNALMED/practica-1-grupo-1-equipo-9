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

public class Deserializador {
	
	public static <T> void deserializarArrays(ArrayList<T> array , String name) {
		
		File archivo = new File("");
		
		try {
			
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/temp/"+name+".txt");
			
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream(ruta));
			
			array.addAll((ArrayList<T>) recuperando_fichero.readObject());
			
			recuperando_fichero.close();

		} catch (FileNotFoundException e) {
			System.out.print("FileNotFound");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("IOException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFoundException");
			e.printStackTrace();
		}
	}
	
	public static void deserializarArrays() {
		Deserializador.deserializarArrays(InventarioAuto.getAutos(), "Autos");
		Deserializador.deserializarArrays(Cliente.getClientes(), "Clientes");
		Deserializador.deserializarArrays(Mecanico.getMecanicos(), "Mecanicos");
		Deserializador.deserializarArrays(Vendedor.getVendedores(), "Vendedores");
		Deserializador.deserializarArrays(InventarioArticulo.getArticulos(), "Articulos");
		Deserializador.deserializarArrays(InventarioArticulo.getRepuesto(), "Repuestos");
		Deserializador.deserializarArrays(Transaccion.getTransacciones(), "Transacciones");
		Deserializador.deserializarArrays(TransaccionVenta.getTransaccionesven(), "TransaccionesVentas");
		Deserializador.deserializarArrays(TransaccionVentaTaller.getTransaccionesven(), "TransaccionesVentaTaller");
		Deserializador.deserializarArrays(TransaccionTaller.getTransaccionestal(), "TransaccionesTaller");
		Deserializador.deserializarArrays(TransaccionModificacion.getTransaccionesmod(), "TransaccionesModificacion");
	}

}
