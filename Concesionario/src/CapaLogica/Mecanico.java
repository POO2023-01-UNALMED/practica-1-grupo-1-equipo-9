package CapaLogica;

import java.util.ArrayList;
import java.util.Scanner;

public class Mecanico extends Trabajador {
	static ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
	String autos;
	String especialidad;
	long pagoSvcs=0;

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, String autos,String especialidad) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = autos;
		this.especialidad=especialidad;
		Mecanico.mecanicos.add(this);
	}

	public String getAutos() {
		return autos;
	}

	public void setAutos(String autos) {
		this.autos = autos;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad=especialidad;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	
	public static ArrayList<Mecanico> getMecanicos() {
		return mecanicos;
	}
	
	public static void setMecanicos(ArrayList<Mecanico> mecanicos) {
		Mecanico.mecanicos = mecanicos;
	}
	public static Mecanico mecanicoDisponible(String modelo) {
	    Scanner sc = new Scanner(System.in);
	    byte input;
	    String salir = null;
	    String especialidad=null;
	    ArrayList<Mecanico> mechs = new ArrayList<Mecanico>();
	    ArrayList<Mecanico> mechas = new ArrayList<Mecanico>();
	    do {
	        System.out.println("\n\nQue deseas hacerle al Vehiculo");
	        System.out.println("1. Latoneria y pintura");
	        System.out.println("2. Cambio de Llantas y alineacion");
	        System.out.println("3. Cambio de Aceite");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");

	        input = sc.nextByte();

	        switch (input) {
	        case 1:
                especialidad="Latonero";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 2:
                especialidad="General";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 3:
                especialidad="General";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
        
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
	    } while(salir.equals(null));
	    
	    String result = String.format("%-10s%-10s%n", "   Nombre", "   Atiende");
	    int i = 0;
	    for (Mecanico mecanico : mechs) {
	        if (modelo.equals(mecanico.getAutos())) {
	            i++;
	            mechas.add(mecanico);
	            String mechInfo = String.format("%-10s%-10s%n", mecanico.getNombre(), mecanico.getAutos());
	            result += String.format("%-3d%s", i, mechInfo);
	        }
	    }
	    Mecanico mecanico = null;
	    if (mechas.size() >= 1) {
	        System.out.println("Los mecanicos que atienden " + modelo + " disponibles son:\n");
	        System.out.println(result);
	        int num = 0;
	        while (num <= 0 || num > mechas.size()) {
	            System.out.println("Seleccione el numero del mecanico" + "[1-" + mechas.size() + "]: ");
	            if (sc.hasNextInt()) {
	                num = sc.nextInt();
	            } else {
	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + mechas.size() + ".");
	                sc.nextLine(); // Limpiar la entrada no válida
	            }
	        }
	        mecanico = mechas.get(num - 1);

	    } else if (mechas.size() == 0) {
	        System.out.println("No hay mecanicos disponibles que atiendan su vehiculo");
	    }
	    return mecanico;
		
	}

	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	}

	@Override
	int calcularSalario() {
		return (int) (pagoSvcs+getSalario());
	}
	public String info() {
		String texto = "Nombre del Mecanico: " + getNombre() + "\n";
		return texto;
	}
}
