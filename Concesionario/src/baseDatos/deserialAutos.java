package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import activos.Auto;
import activos.InventarioAuto;

public class deserialAutos {
	private static File rutaTemp = new File("\\temp");
	
	public static void desearializarAutos() {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file:docs) {
			if (file.getAbsolutePath().contains("autos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					InventarioAuto.setAutos((ArrayList<Auto>) ois.readObject());
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
	}
}
