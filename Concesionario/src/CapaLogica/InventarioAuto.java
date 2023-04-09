package CapaLogica;

import java.util.ArrayList;

public class InventarioAuto {
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
		String resultado = "Autos Disponibles:\n";
		for (Auto auto : getAutosDisponibles()) {
			resultado += auto.getMarca() + " " + auto.getPrecio() + " " + auto.getColor() + "\n";
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
	
	public static String autosMarca(String marca) {
		/*Falta validar cuando no hay carros disponibles del modelo*/
		System.out.println("Tenemos los siguientes carros de la marca " + marca + ":\n");
	    String result = String.format("%-10s%-10s%-10s\n", "   Marca", "   Precio", "   Color");
	    int i = 0;
	    for (Auto auto : getAutosDisponibles()) {
	        if (marca.equals(auto.getMarca())) {
	            i++;
	            String carInfo = String.format("%-10s%-10s%-10s\n", auto.getMarca(), auto.getPrecio(), auto.getColor());
	            result += String.format("%-3d%s", i, carInfo);
	        }
	    }
	    return result;
	}


}
