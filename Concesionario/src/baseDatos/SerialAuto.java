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

import CapaLogica.Auto;
import CapaLogica.InventarioAuto;

public class SerialAuto {
	
	public static void serializarAuto() {
		
		try{
			
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("D:\\Eclipse\\workspace\\practica-1-grupo-1-equipo-9\\Concesionario\\src\\baseDatos\\temp\\autos.txt"));
			
			escribiendo_fichero.writeObject(InventarioAuto.getAutos());
			
			escribiendo_fichero.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.print("FileNotFound");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("IOException");
			e.printStackTrace();
		}
	}
	
	public static void deserializarAuto() {
		try {
			
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("D:\\Eclipse\\workspace\\practica-1-grupo-1-equipo-9\\Concesionario\\src\\baseDatos\\temp\\autos.txt"));
			
			ArrayList<Auto> autos_recuperados = (ArrayList<Auto>) recuperando_fichero.readObject();
			
			recuperando_fichero.close();
			
			for(Auto auto:autos_recuperados) {
				System.out.println(auto.info());
			}
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
	
}

