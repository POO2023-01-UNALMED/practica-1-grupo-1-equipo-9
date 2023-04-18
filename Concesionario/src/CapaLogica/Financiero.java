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
		String salir=null;
		do {
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
			if (confirmarPrp.equals("no")) {
				System.out.print("Introduzca la cédula del propietario: ");
				long cedula = sc.nextLong(); 
				sc.nextLine();
				propietario = Transaccion.getClientePorCedula(cedula);
				transaccion = Transaccion.getTransaccionporCedula(cedula);
				System.out.print(propietario.info());
				
				if (propietario == null || transaccion == null) {
					System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.");
				}
			}
			
		}
		if (confirmarPrp.equals("si")) {
			String confirmarMech=null;
			Mecanico mecanico=Mecanico.mecanicoDisponible(transaccion.auto.getMarca());
			System.out.print(mecanico.info());
			while (confirmarMech==null||confirmarMech.equals("no")) {
				
				System.out.print("¿Confirmar mecanico? (si/no)");
				confirmarMech = sc.nextLine();
				if (confirmarMech.equals("no")) {
					mecanico=Mecanico.mecanicoDisponible(transaccion.auto.getMarca());
					System.out.print(mecanico.info());
				}
		}if(confirmarMech.equals("si")) {
			String confirmarProd=null; 
			Articulo producto=InventarioArticulo.articuloDispo(mecanico.getEspecialidad());
			System.out.print(producto.info());
			while (confirmarProd==null||confirmarProd.equals("no")) {
				System.out.print("¿Confirmar producto? (si/no)");
				confirmarProd = sc.nextLine();
				if (confirmarProd.equals("no")) {
					producto=InventarioArticulo.articuloDispo(mecanico.getEspecialidad());
					System.out.print(producto.info());
				}
		}if(confirmarProd.equals("si")) {
			String confirmarTrans=null;
			long costoTotal=(long) (mecanico.getManoObra()+producto.getPrecio());
			System.out.print("El precio total por su Servicio es:"+costoTotal+"\n");
			if(producto.getEspecialidad().equals("Motor")) {
				System.out.print("El procedimiento a realizar es: Cambio de aceite con "+producto.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			else if(producto.getEspecialidad().equals("Llantas")) {
				System.out.print("El procedimiento a realizar es: Cambio de Llantas con "+producto.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			else if(producto.getEspecialidad().equals("Pintura")) {
				System.out.print("El procedimiento a realizar es: Latoneria y pintura con "+producto.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			else if(producto.getEspecialidad().equals("Frenos")) {
				System.out.print("El procedimiento a realizar es: Cambio de frenos con "+producto.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			while (confirmarTrans==null||confirmarTrans.equals("no")) {
				System.out.print("¿Confirmar Transaccion? (si/no)");
				confirmarTrans= sc.nextLine();
				if(confirmarTrans.equals("si")) {
					System.out.print(new Transaccion("taller", mecanico, costoTotal, propietario, propietario.getAuto(), producto).info()+"\n");
				}
				else {
					System.out.print("Transaccion cancelada"+"\n");
					System.out.print("Hasta luego, desea otro servicio relacionado con taller (si/no)");
					salir=sc.nextLine();
					break;
				}
				System.out.print("esperemos verlo de nuevo en nuestro Consecionario");
				;
			}if (confirmarTrans.equals("si")) {
				System.out.print("Hasta luego, desea otro servicio relacionado con taller (si/no)");
				salir=sc.nextLine();
			}
			
			}
			}
		}
		}while(salir.equals("si"));
	}
	public static void ventaRepuestos() {
		System.out.print("Bienvenido a nuestro portal de Ventas de Repuestos"+"\n");
		Cliente comprador = null;
		Vendedor vendedor = null;
		Auto auto = null;
		Scanner sc = new Scanner(System.in);
		while (comprador==null) {
			System.out.println("Escriba la cédula del comprador: ");
			long cedula = sc.nextLong();
			comprador = Cliente.getClientePorCedula(cedula);
			System.out.print(comprador.info());
		}
		String confirmarComp=null;
		while(confirmarComp==null||confirmarComp.equals("no")) {
			System.out.print("¿Confirmar cliente? (si/no)");
			confirmarComp = sc.nextLine();
			sc.nextLine();
			if (!confirmarComp.equals("si")){
				System.out.println("Escriba la cédula del comprador: ");
				long cedula = sc.nextLong();
				comprador = Cliente.getClientePorCedula(cedula);
				System.out.print(comprador.info());

			}
		}if(!confirmarComp.equals("no")) {
			String confirmarTipo=null;
			ArrayList<Articulo> repuesto=InventarioArticulo.selectorEspecial();
			System.out.print("Usted Va a comprar un repuesto de: "+repuesto.get(0).getEspecialidad()+"\n");
			while(confirmarTipo==null||confirmarTipo.equals("no")) {
				System.out.print("¿Confirmar Tipo de repuesto? (si/no)");
				confirmarTipo = sc.nextLine();
				sc.nextLine();
				if (confirmarTipo.equals("no")){
					repuesto=InventarioArticulo.selectorEspecial();
					System.out.print("Usted Va a comprar un repuesto de: "+repuesto.get(0).getEspecialidad()+"\n");
					
				}
			}if(confirmarTipo.equals("si")) {
				String confirmarMarca=null;
				ArrayList<Articulo> marca=InventarioArticulo.selectorMarca(repuesto);
				System.out.print("Usted Va a comprar un repuesto de: "+marca.get(0).getMarcaVehiculo()+"\n");
				while(confirmarMarca==null||confirmarMarca.equals("no")) {
					System.out.print("¿Confirmar Tipo de Vehiculo? (si/no)");
					confirmarMarca = sc.nextLine();
					sc.nextLine();
					if (confirmarTipo.equals("no")){
						marca=InventarioArticulo.selectorMarca(repuesto);
						System.out.print("Usted Va a comprar un repuesto de: "+marca.get(0).getMarcaVehiculo()+"\n");
						
					}
				}if(confirmarTipo.equals("si")) {
					Articulo articulo=InventarioArticulo.selectorCalidad(marca);
					System.out.print(articulo.getTipoArticulo());
				}

			}
		}
	}
	
	public static void stats() {
		Scanner sc = new Scanner(System.in);
		byte opcion;
		System.out.println("¿Qué estadisticas en particular quiere consultar?");
		//static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
		System.out.println("1. Ventas por Vendedor");
		System.out.println("2. Ventas por Marca");
		System.out.println("Selecciona: ");
		opcion = sc.nextByte();
		switch (opcion){
		case 1:
			
			//System.out.println(Vendedor.getVendedores());
			//Arraylist<Vendedor> vendedores = Vendedor.getVendedores();

			ArrayList<String> vendedores1 = new ArrayList<String>();
			
			for (Transaccion transacc: Transaccion.getTransacciones())
			{
				if (vendedores1.contains(transacc.getVendedor().getNombre())){
					
				} else {
					vendedores1.add(transacc.getVendedor().getNombre());
				}
			}
			
			float num = ((float)vendedores1.size() / Vendedor.getVendedores().size()) * 100;
			int roundedNum = Math.round(num);

			System.out.println("De los " + Vendedor.getVendedores().size() + " vendedores que trabajan actualmente en el concesionario, " + vendedores1.size()+ " (el " + roundedNum + "%) han logrado ventas en lo que va del mes, estos son:");
			
			for (String vend: vendedores1)
			{
				System.out.println(vend);
			}
			
			// para saber la cantidad total en ventas:
			int sumaTotal=0;
			int contadorTotal=0;
			for (Transaccion trans1: Transaccion.getTransacciones())
				{sumaTotal+=trans1.getIngreso();
				contadorTotal+=1;}
			// para saber la cantidad total en ventas:
			
			System.out.println("Los cuales suman la siguiente cantidad de dinero en ventas: ");
			
			for (String vend: vendedores1)
			{
				int suma = 0;
				int contador=0;
				for (Transaccion trans1: Transaccion.getTransacciones())
				{
					if (vend.equals(trans1.getVendedor().getNombre())){
						suma+=trans1.getIngreso();
						contador+=1;
					}
				}
				float num2 = ((float)suma / sumaTotal) * 100;
				int roundedSum = Math.round(num2);
				System.out.println(vend + ": " + suma + ", el " + roundedSum + " % del total de ingresos por ventas de autos.");
			}
			
			System.out.println("A continuacion, el # de ventas que han realizado, y el promedio de ingreso por venta: ");
			
			for (String vend: vendedores1)
			{
				int contador=0;
				int suma2 = 0;
				for (Transaccion trans1: Transaccion.getTransacciones())
				{
					if (vend.equals(trans1.getVendedor().getNombre())){
						contador+=1;
						suma2+=trans1.getIngreso();
					}
				}
				int num3 = (suma2 / contador);
				float num4 = ((float)contador/contadorTotal)*100;
				int roundedNum4 = Math.round(num4);
				//int roundedNum3 = Math.round(num3);
				
				System.out.println(vend + ": " + contador + ", el " + roundedNum4 + "% del total de ventas, promediando " + num3 + " $ por venta.");
			}
			
			break;
			
		case 2:
			break;
		}
		//System.out.println("has seleccionado " + opcion);
		
		
	}
	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	}
}