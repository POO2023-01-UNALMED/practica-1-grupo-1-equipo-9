package CapaLogica;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public static Auto autosModelo(String modelo) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Auto> autosMod = new ArrayList<Auto>();
	    String result = String.format("%-10s%-10s%-10s\n", "   Modelo", "   Precio", "   Color");
	    int i = 0;
	    for (Auto auto : getAutosDisponibles()) {
	        if (modelo.equals(auto.getModelo())) {
	            i++;
	            autosMod.add(auto);
	            String carInfo = String.format("%-10s%-10s%-10s\n", auto.getModelo(), auto.getPrecio(), auto.getColor());
	            result += String.format("%-3d%s", i, carInfo);
	        }
	    }
	    Auto auto = null;
	    if (autosMod.size()>1){
		    System.out.println("Los carros de modelo " + modelo + " disponibles son:\n");
		    System.out.println(result);
		    /*falta hacer control de errores cuando se ingresa una opcion no valida*/
		    System.out.println("Seleccione el numero del carro" + "[1-" + autosMod.size() + "] ");
	    } else if (autosMod.size()==1) {
	    	System.out.println("El unico carro de modelo " + modelo + " disponible es:\n");
		    System.out.println(result);
		    System.out.println("Lo desea seleccionar? (y/n): ");
		    String resp = sc.nextLine();
		    if (resp.equals("y")) {
		    	auto=autosMod.get(0);
		    } else {
		    	auto=null;
		    }
	    } else if (autosMod.size()==0) {
	    	System.out.println("No hay carros disponibles del modelo seleccionado");
	    	auto=null;
	    }
	    return auto;
	}
	
	public static String autosMarca() {
		
	}
	
	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	}



}
