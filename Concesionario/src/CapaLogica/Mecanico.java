package CapaLogica;

import java.util.ArrayList;
import java.util.Scanner;

public class Mecanico extends Trabajador {
	static ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
	String autos;
	String especialidad;
	long pagoSvcs=0;
	long manoObra;

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, String autos,String especialidad,long manoObra) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = autos;
		this.manoObra=manoObra;
		this.especialidad=especialidad;
		Mecanico.mecanicos.add(this);
	}
    public long  getManoObra() {
        return manoObra;
    }

    public void setManoObra(long manoObra) {
        this.manoObra = manoObra;
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
	public static ArrayList<Mecanico> mecanicoDisponible() {
	    Scanner sc = new Scanner(System.in);
	    byte input;
	    String salir = null;
	    String especialidad=null;
	    ArrayList<Mecanico> mechs = new ArrayList<Mecanico>();
	    
	    do {

	        input = sc.nextByte();

	        switch (input) {
	        case 1:
                especialidad="Pintura";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 2:
                especialidad="Llantas";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 3:
                especialidad="Motor";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 4:
                especialidad="Frenos";
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
	    return mechs;
	}
	public static Mecanico selector(ArrayList<Mecanico> mechs,Auto auto) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Mecanico> mechas = new ArrayList<Mecanico>();
	    String result = String.format("%-20s%-10s%-10s%n", "   Nombre", "   Atiende", "   Especialidad");
	    int i = 0;
	    for (Mecanico mecanico : mechs) {
	        if (auto.getMarca().equals(mecanico.getAutos())) {
	            i++;
	            mechas.add(mecanico);
	            String mechInfo = String.format("%-20s%-10s%-10s%n", mecanico.getNombre(), mecanico.getAutos(),mecanico.getEspecialidad());
	            result += String.format("%-3d%s", i, mechInfo);
	        }
	    }
	    Mecanico mecanico = null;
	    
	    if (mechas.size() >= 1) {
	        System.out.println("Los mecanicos que atienden " + auto.getMarca() + " disponibles son:\n");
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
