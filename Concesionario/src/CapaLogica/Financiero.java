package CapaLogica;

import java.util.*;  

public class Financiero {
	
	public static void procesoVenta() {
		Cliente comprador = null;
		Vendedor vendedor = null;
		Auto auto = null;
		Scanner sc = new Scanner(System.in);
		InventarioAuto.autosDisponibles();
		System.out.print("Escriba el modelo del carro a escoger: ");
		String modelo = sc.nextLine();
		auto = InventarioAuto.getAutoporModelo(modelo);
		System.out.println(InventarioAuto.autosMarca(modelo));
		String confirmarCliente = null;
		while(confirmarCliente=="no") {
			System.out.print("Introduzca la cédula del comprador: ");
			long cedula = sc.nextLong();
			comprador = Cliente.getClientePorCedula(cedula);
			comprador.toString();
			System.out.print("¿Confirmar cliente? (si/no)");
			confirmarCliente = sc.nextLine();
		}if(confirmarCliente=="si") {
			String confirmarVendedor = null;
			while(confirmarVendedor=="no") {
				System.out.print("Introduzca el vendedor asociado a la compra: ");
				long cedulaVendedor = sc.nextLong();
				vendedor = Vendedor.getVendedorPorCedula(cedulaVendedor);
				vendedor.toString();
				System.out.print("¿Confirmar vendedor? (si/no)");
				confirmarVendedor = sc.nextLine();
				if(confirmarVendedor=="si") {
					if(comprador.getPresupuesto()>=auto.getPrecio()) {
						int diferencia = comprador.getPresupuesto()-auto.getPrecio();
						comprador.setPresupuesto(diferencia);
						comprador.setAuto(auto);
						auto.setDisponible(false);
						vendedor.confirmarVenta();
						auto.setDueno(comprador);
					}else if(comprador.getPresupuesto()<=auto.getPrecio()) {
						System.out.println("El cliente no tiene el presupuesto suficiente.");
					}
				}
			}

		}
		
		
	}
	
}
