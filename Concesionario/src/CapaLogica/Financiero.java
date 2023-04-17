package CapaLogica;

import java.util.*;  

public class Financiero {
	
	public static void procesoVenta() {
		Cliente comprador = null;
		Vendedor vendedor = null;
		Auto auto = null;
		Scanner sc = new Scanner(System.in);
		
		while (comprador==null) {
			System.out.println("Escriba la cédula del comprador: ");
			long cedula = sc.nextLong();
			comprador = Cliente.getClientePorCedula(cedula);
			if (comprador==null) {
				System.out.println("La cédula ingresada no se encuentra registrada. Por favor, vuelva a ingresarla.");
			}
		}
		
		/*Selección del carro*/
		int opcion = 0;
		System.out.println("Estos son los Modelos de interés para el cliente disponibles en este momento: ");
		InventarioAuto.autosModelo(comprador.getModeloInteres());
		System.out.println("0. Más opciones de busqueda...");
		System.out.println("Seleccione el Auto en el que está interesado o use las otras opciones de busqueda: ");
		if (sc.nextInt()!=0) {
			System.out.println("1. Mostrar Autos por Marca");
			System.out.println("2. Mostrar Autos por precio");
			System.out.println("3. Mostrar todos los autos");
			System.out.println("4. Volver");
			switch (sc.nextInt()){
				case 1:
					break;
				case 2:
					break;
				case 3:
					InventarioAuto.autosDisponibles();
					break;
				case 4:
					break;
			}
		}
		

		/*Selección del carro*/
		
		/*InventarioAuto.autosDisponibles();
		System.out.print("Escriba el modelo del carro a escoger: ");
		String modelo = sc.nextLine();
		auto=InventarioAuto.autosModelo(modelo);
		
		System.out.println(auto);
		String confirmarCliente = null;
		
		while(confirmarCliente==null||confirmarCliente.equals("no")) {
			System.out.print("Introduzca la cédula del comprador: ");
			long cedula = sc.nextLong(); 
			sc.nextLine();
			
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

		}*/
		
		
	}
	public static void procesoTaller() {
		Scanner sc = new Scanner(System.in);
		Cliente propietario = null;
		Transaccion transaccion = null;
		
		while (propietario == null || transaccion == null) {
			System.out.print("Introduzca la cédula del propietario: ");
			long cedula = sc.nextLong(); 
			sc.nextLine();
			propietario = Transaccion.getClientePorCedula(cedula);
			transaccion = Transaccion.getTransaccionporCedula(cedula);
			
			if (propietario == null || transaccion == null) {
				System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.");
			}
		}
		
		System.out.print(propietario.info());
		String confirmarPrp=null;

		while (confirmarPrp==null||confirmarPrp.equals("no")) {
			System.out.print("¿Confirmar propietario? (si/no)");
			confirmarPrp = sc.nextLine();
			
		}
		if (confirmarPrp.equals("si")) {
			String confirmarMech=null;
			Mecanico mecanico=Mecanico.mecanicoDisponible(transaccion.auto.getMarca());
			System.out.print(mecanico.info());
			while (confirmarMech==null||confirmarMech.equals("no")) {
				System.out.print("¿Confirmar mecanico? (si/no)");
				confirmarMech = sc.nextLine();
		}if(confirmarMech.equals("si")) {
			String confirmarProd=null; 
			Articulo producto=InventarioArticulo.articuloDispo(mecanico.getEspecialidad());
			System.out.print(producto.info());
			while (confirmarProd==null||confirmarProd.equals("no")) {
				System.out.print("¿Confirmar mecanico? (si/no)");
				confirmarProd = sc.nextLine();
		}if(confirmarProd.equals("si")) {
			String confirmarSvc=null;
			long costoTotal=(long) (mecanico.getManoObra()+producto.getPrecio());
			System.out.print("El precio total por su Servicio es:"+costoTotal);
			if(producto.getEspecialidad().equals("Motor")) {
				System.out.print("El procedimiento a realizar es: Cambio de aceite con "+producto.getTipoArticulo()+", y su mecanico será"+mecanico.info());
			}
			else if(producto.getEspecialidad().equals("Llantas")) {
				System.out.print("El procedimiento a realizar es: Cambio de Llantas con "+producto.getTipoArticulo()+", y su mecanico será"+mecanico.info());
			}
			else if(producto.getEspecialidad().equals("Pintura")) {
				System.out.print("El procedimiento a realizar es: Latoneria y pintura con "+producto.getTipoArticulo()+", y su mecanico será"+mecanico.info());
			}
			else if(producto.getEspecialidad().equals("Frenos")) {
				System.out.print("El procedimiento a realizar es: Cambio de frenos con "+producto.getTipoArticulo()+", y su mecanico será"+mecanico.info());
			}
			while (confirmarSvc==null||confirmarSvc.equals("no")) {
				System.out.print("¿Confirmar Transaccion? (si/no)");
				String confirmarTrans= sc.nextLine();
				if(confirmarTrans.equals("si")) {
					new Transaccion("taller", mecanico, costoTotal, propietario, propietario.getAuto(), producto);
					System.out.print(new Transaccion("taller", mecanico, costoTotal, propietario, propietario.getAuto(), producto).info());
				}
				else {
					System.out.print("Transaccion cancelada");
					break;
				}
				System.out.print("esperemos verlo de nuevo en nuestro Consecionario,desea terminar el servicio(si/no)");
				confirmarSvc= sc.nextLine();
			}if (confirmarSvc.equals("si")) {
				System.out.print("Hasta luego");
			}
		}
	}
	}
	}
}
