package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import activos.InventarioArticulo;

public class serialArticulos {
	private static File rutaTemp = new File("src\\baseDatos\\temp")
;
	public static void serializar(InventarioArticulo articulos) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;
		
		
		for (File file:docs) {
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		for (File file:docs) {
			
			if (file.getAbsolutePath().contains("articulos")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(articulos.getArticulos());
				} catch (FileNotFoundException e ) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
