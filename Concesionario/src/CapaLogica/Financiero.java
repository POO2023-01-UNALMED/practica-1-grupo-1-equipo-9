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
		auto=InventarioAuto.autosModelo(modelo);
		
		System.out.println(auto);
		String confirmarCliente = null;
		
		while(confirmarCliente==null||confirmarCliente.equals("no")) {
			System.out.print("Introduzca la cédula del comprador: ");
			long cedula = sc.nextLong(); 
			sc.nextLine();
			comprador = Cliente.getClientePorCedula(cedula);
			System.out.print(comprador.info());
			System.out.print("¿Confirmar cliente? (si/no)");
			confirmarCliente = sc.nextLine();
		}if(confirmarCliente.equals("si")) {
			String confirmarVendedor = null;
			while(confirmarVendedor==null||confirmarVendedor.equals("no")) {
				System.out.print("Introduzca el vendedor asociado a la compra: ");
				long cedulaVendedor = sc.nextLong();
				sc.nextLine();
				vendedor = Vendedor.getVendedorPorCedula(cedulaVendedor);
				System.out.print(vendedor.info());
				System.out.print("¿Confirmar vendedor? (si/no)");
				confirmarVendedor = sc.nextLine();
				if(confirmarVendedor.equals("si")) {
					if(comprador.getPresupuesto()>=auto.getPrecio()) {
						long diferencia = comprador.getPresupuesto()-auto.getPrecio();
						comprador.setPresupuesto(diferencia);
						comprador.setAuto(auto);
						auto.setDisponible(false);
						vendedor.confirmarVenta();
						auto.setDueno(comprador);
						System.out.println("Compra efectuada Con exito");
						Transaccion transaccion=new Transaccion("venta",vendedor,auto.getPrecio(),comprador,auto);
						System.out.println(transaccion.info());
					}else if(comprador.getPresupuesto()<=auto.getPrecio()) {
						System.out.println("El cliente no tiene el presupuesto suficiente.");
					}
				}
			}

		}
		
		
	}
	public static void procesoTaller() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la cédula del propietario: ");
		long cedula = sc.nextLong(); 
		sc.nextLine();
		Cliente propietario = Transaccion.getClientePorCedula(cedula);
		System.out.print(propietario.info());
		Transaccion transaccion=Transaccion.getTransaccionporCedula(cedula);
		String ConfirmarPrp=null;

		while (ConfirmarPrp==null||ConfirmarPrp.equals("no")) {
			System.out.print("¿Confirmar propietario? (si/no)");
			ConfirmarPrp = sc.nextLine();
			
		}
		if (ConfirmarPrp.equals("si")) {
			String confirmarMech=null;
			
			Mecanico mecanico=Mecanico.mecanicoDisponible(transaccion.auto.getMarca());
			System.out.print(mecanico.info());
			
			
			
		}

		
		
		
		
	}

}