package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import CapaLogica.Auto;
import CapaLogica.InventarioAuto;

public class deserialAutos {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void desearializar(InventarioAuto autos) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file:docs) {
			if (file.getAbsolutePath().contains("autos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					autos.setAutos((ArrayList<Auto>) ois.readObject());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
