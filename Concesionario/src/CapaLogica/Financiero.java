package CapaLogica;

import java.util.*;  

public class Financiero {
	
	public static void procesoVenta() {
		Scanner sc = new Scanner(System.in);
		InventarioAuto.autosDisponibles();
		System.out.print("Escriba el modelo del carro a escoger: ");
		String modelo = sc.nextLine();
		String confirmar = null;
		while(confirmar=="no") {
			System.out.print("Introduzca la cédula del comprador: ");
			long cedula = sc.nextLong();
			Cliente.getClientePorCedula(cedula).toString();
			System.out.print("¿Confirmar cliente? (si/no)");
			confirmar = sc.nextLine();
		}if(confirmar=="si") {
			String confirmarVendedor = null;
			while(confirmarVendedor=="no") {
				System.out.print("Introduzca el vendedor asociado a la compra: ");
				long cedulaVendedor = sc.nextLong();
				Vendedor.getVendedorPorCedula(cedulaVendedor).toString();
				System.out.print("¿Confirmar vendedor? (si/no)");
				confirmarVendedor = sc.nextLine();
			}

		}
		
		
	}
	
}
