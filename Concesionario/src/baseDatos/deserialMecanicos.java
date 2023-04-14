package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import CapaLogica.Mecanico;

public class deserialMecanicos {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void desearializar(Mecanico mecanicos) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file:docs) {
			if (file.getAbsolutePath().contains("mecanicos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					mecanicos.setMecanicos((ArrayList<Mecanico>) ois.readObject());
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