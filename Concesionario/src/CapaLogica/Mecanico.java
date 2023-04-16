package CapaLogica;

import java.util.ArrayList;
import java.util.Scanner;

public class Mecanico extends Trabajador {
	static ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
	String autos;
	long pagoSvcs=0;

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, String autos) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = autos;
		Mecanico.mecanicos.add(this);
	}

	public String getAutos() {
		return autos;
	}

	public void setAutos(String autos) {
		this.autos = autos;
	}
	
	public static ArrayList<Mecanico> getMecanicos() {
		return mecanicos;
	}
	
	public static void setMecanicos(ArrayList<Mecanico> mecanicos) {
		Mecanico.mecanicos = mecanicos;
	}
	public static Mecanico mecanicoDisponible(String modelo) {
	    Scanner sc = new Scanner(System.in);
	    ArrayList<Mecanico> mechs = new ArrayList<Mecanico>();
	    String result = String.format("%-10s%-10s%n", "   Nombre", "   Atiende");
	    int i = 0;
	    for (Mecanico mecanico : getMecanicos()) {
	        if (modelo.equals(mecanico.getAutos())) {
	            i++;
	            mechs.add(mecanico);
	            String mechInfo = String.format("%-10s%-10s%n", mecanico.getNombre(), mecanico.getAutos());
	            result += String.format("%-3d%s", i, mechInfo);
	        }
	    }
	    Mecanico mecanico = null;
	    if (mechs.size() > 1) {
	        System.out.println("Los mecanicos que atienden " + modelo + " disponibles son:\n");
	        System.out.println(result);
	        int num = 0;
	        while (num <= 0 || num > mechs.size()) {
	            System.out.println("Seleccione el numero del mecanico" + "[1-" + mechs.size() + "]: ");
	            if (sc.hasNextInt()) {
	                num = sc.nextInt();
	            } else {
	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + mechs.size() + ".");
	                sc.nextLine(); // Limpiar la entrada no válida
	            }
	        }
	        mecanico = mechs.get(num - 1);

	    } else if (mechs.size() == 1) {
	        System.out.println("El unico mecanico que atiende " + modelo + " disponible es:\n");
	        System.out.println(result);
	        System.out.println("Lo desea seleccionar? (si/no): ");
	        String resp = sc.nextLine();
	        if (resp.equals("si")) {
	            mecanico = mechs.get(0);
	        }
	    } else if (mechs.size() == 0) {
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
