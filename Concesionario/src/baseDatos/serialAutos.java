package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import CapaLogica.Auto;

import java.io.IOException;
import java.io.FileNotFoundException;

public class serialAutos {
	
	static File archivo = new File("");
	
	public static void main(String[] args) {
		
		Auto a1= new Auto("Cupra", 20000000, 5400, "verde fofo", true, false);
		
		try {
		FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+"/temp/autos.txt"));
	
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		// Escribir objectos a un Archivo
		o.writeObject(a1);
		// Cerrar conexiones abiertas
		o.close();
		f.close();
		
		FileInputStream fi = new FileInputStream(new File(archivo.getAbsolutePath()+"/temp/autos.txt"));

				ObjectInputStream oi = new ObjectInputStream(fi);
				// Leer objectos
				Auto ar1 = (Auto) oi.readObject();
				System.out.println(ar1.toString());
				// Cerrar conexiones abiertas
				oi.close();
				fi.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("No se encuentra archivo");
			}
			catch (IOException e) {
			System.out.println("Error flujo de inicialización");
			}
			catch (ClassNotFoundException e) {
			// TODO Auto‐generated catch block
			e.printStackTrace();
			}

	}
}
