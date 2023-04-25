package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import CapaLogica.InventarioAuto;

public class serialAutos {
	private static File rutaTemp = new File("\\temp")
;
	public static void serializarAutos() {
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
			
			if (file.getAbsolutePath().contains("autos")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(InventarioAuto.getAutos());
				} catch (FileNotFoundException e ) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
