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
			System.out.print(comprador.toString());
			System.out.print("¿Confirmar cliente? (si/no)");
			confirmarCliente = sc.nextLine();
		}if(confirmarCliente.equals("si")) {
			String confirmarVendedor = null;
			while(confirmarVendedor==null||confirmarVendedor.equals("no")) {
				System.out.print("Introduzca el vendedor asociado a la compra: ");
				long cedulaVendedor = sc.nextLong();
				sc.nextLine();
				vendedor = Vendedor.getVendedorPorCedula(cedulaVendedor);
				System.out.print(vendedor.toString());
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
						System.out.println(transaccion.toString());
					}else if(comprador.getPresupuesto()<=auto.getPrecio()) {
						System.out.println("El cliente no tiene el presupuesto suficiente.");
					}
				}
			}

		}
		
		
	}
	public static void procesoTaller() {
	    Cliente comprador = null;
	    Auto auto ;
	    Mecanico mecanico=null;
	    Transaccion transaccion=null;
	    String marca;
	    Scanner sc = new Scanner(System.in);
	    String confirmarSvc = null;



	    while(confirmarSvc == null || confirmarSvc.equals("no")) {
	        System.out.print("Introduzca la cédula del propietario: ");
	        long cedula = sc.nextLong();
	        transaccion=Transaccion.getTransaccionporCedula(cedula);
	        comprador = Transaccion.getClientePorCedula(cedula);
	        System.out.print(comprador.toString());
	        if (comprador.getAuto() == null) {
	            System.out.println("Error: Este cliente no tiene un auto registrado.");
	            return;
	        }

	        auto = comprador.getAuto();
	        marca=auto.getMarca();
	        auto = comprador.getAuto();
	        marca=auto.getMarca();
	        System.out.print("¿Confirmar propietario? (si/no)");
	        confirmarSvc = sc.nextLine();
	        sc.nextLine();
	    }
	    if(!confirmarSvc.equals("no")) {
	        String confirmarMech = null;
	        while(confirmarMech == null || confirmarMech.equals("no")) {
	        	mecanico=Mecanico.mecanicoDisponible(auto.getMarca());
	        	System.out.print(mecanico);
	        	System.out.print("Presione Enter para continuar...");
	        	sc.nextLine();
	            System.out.print("¿Confirmar mecanico? (si/no)");
	            confirmarMech = sc.nextLine();


	        
	        }	        
	    }        
	}

	
}
