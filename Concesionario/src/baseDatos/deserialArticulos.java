package baseDatos;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import activos.Articulo;
import activos.InventarioArticulo;

public class deserialArticulos {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void desearializar(InventarioArticulo articulos) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file:docs) {
			if (file.getAbsolutePath().contains("articulos")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					articulos.setArticulos((ArrayList<Articulo>) ois.readObject());
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