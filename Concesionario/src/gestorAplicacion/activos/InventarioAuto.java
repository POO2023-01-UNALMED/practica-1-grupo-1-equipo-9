package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InventarioAuto implements Serializable{
	private static final long serialVersionUID = 1L;
	static ArrayList<Auto> autos = new ArrayList<Auto>();

	public void agregarAuto(Auto auto) {
		autos.add(auto);
	}

	public void eliminarAuto(Auto auto) {
		autos.remove(auto);
	}

	public static ArrayList<Auto> getAutos() {
		return autos;
	}

	public static void setAutos(ArrayList<Auto> autos) {
		InventarioAuto.autos = autos;
	}

	public static String autosDisponibles() {
		int cont = 1;
		String resultado = "Autos Disponibles:\n";
		for (Auto auto : getAutosDisponibles()) {
			resultado += cont + ". " + auto.getModelo() + " " +  auto.getMarca() + " " + auto.getPrecio() + " " + auto.getColor() + "\n";
			cont++;
		}
		return resultado;
	}

	public static ArrayList<Auto> getAutosDisponibles() {
		ArrayList<Auto> disponibles = new ArrayList<Auto>();
		for (Auto auto : autos) {
			if (auto.isDisponible()) {
				disponibles.add(auto);
			}
		}
		return disponibles;
	}
	
	public static ArrayList<Auto> AutosVendidos(ArrayList<Auto> autosinic) {
		ArrayList<Auto> vendidos = new ArrayList<>();
		for (Auto auto : autosinic) {
			if (auto.isDisponible()) {
			} else {
				vendidos.add(auto);
			}
		}
		return vendidos;
	}
	
	public static Auto getAutoporModelo(String modelo) {
		Auto finder = null;
		for (Auto auto : getAutosDisponibles()) {
			if(modelo==auto.getModelo()) {
				finder = auto;
			}else {
				return finder;
			}
		}return finder;
	}
	
	public static ArrayList<Auto> getAutosporPrecio() {
		ArrayList<Auto> autosPrecio = new ArrayList<Auto>();
		for (Auto auto: InventarioAuto.getAutosDisponibles()) {
			autosPrecio.add(auto);
		}
		Collections.sort(autosPrecio, new Sortbyroll());
		return autosPrecio;
	}
	
	public static ArrayList<Auto> getAutosporModelo(String modelo) {
		ArrayList<Auto> modelosInteres = new ArrayList<Auto>();
		for (Auto auto: getAutosDisponibles()) {
			if(modelo==auto.getModelo()) {
				modelosInteres.add(auto);
			}
		}if (modelosInteres.size()==0) {
			System.out.println("No existen carros de este modelo disponibles en este momento.");
		}return modelosInteres;
	}
	
	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	}

	



}
