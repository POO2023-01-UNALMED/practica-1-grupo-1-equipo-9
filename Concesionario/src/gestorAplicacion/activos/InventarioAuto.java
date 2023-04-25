package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InventarioAuto  implements Serializable{
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
		Scanner sc = new Scanner(System.in);
		String marca = ""; 
		System.out.println("1. Mazda");
		System.out.println("2. Toyota");
		System.out.println("3. Chevrolet");
		System.out.println("Seleccione la marca [1-3]: ");
		switch (sc.nextInt()){
		case 1:
			marca = "Mazda";
			break;
		case 2:
			marca = "Toyota";
			break;
		case 3:
			marca = "Chevrolet";
			break;
		}		
		ArrayList<Auto> autosMarca = new ArrayList<Auto>();
		for(Auto auto:getAutosDisponibles()) {
			if(auto.getMarca()==marca) {
				autosMarca.add(auto);
			}
		}
		System.out.println("Estos son los carros disponibles de esta marca: ");
		int cont = 1;
		for (Auto auto:autosMarca){
			System.out.println(cont + ". " + auto.info());
			cont++;
		}
		return "";
		
		
		
	}
	
	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	}



}
