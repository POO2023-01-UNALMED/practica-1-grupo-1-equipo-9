package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import personal.Cliente;

public class deserialClientes {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void desearializar(Cliente clt) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file:docs) {
			if (file.getAbsolutePath().contains("clientes")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					clt.setClientes((ArrayList<Cliente>) ois.readObject());
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
