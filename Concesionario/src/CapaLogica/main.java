package CapaLogica;
import java.util.*;
import java.time.LocalDate;
import java.time.format.TextStyle;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Articulos default
		Articulo llanta= new Articulo("Basico","taller","Llanta","Serie", "automovil y camioneta", "Serie", 0, 10000);
		Articulo sonido= new Articulo("Basico","taller","Sonido","Serie", "automovil y camioneta", "Serie", 0, 10000);
		Articulo escape= new Articulo("Basico","taller","Escape","Serie", "automovil y camioneta", "Serie", 0, 10000);
		Articulo suspension= new Articulo("Basico","taller","Suspension","Serie", "automovil y camioneta", "Serie", 0, 10000);
		//Autos
		Auto a1= new Auto("Cupra Leon", "Toyota", 20000000, 5400, "verde fofo", true, true,llanta,suspension,sonido,escape);
		Auto a2= new Auto("Corolla", "Chevrolet", 456, 5, "negro", false, true,llanta,suspension,sonido,escape);
		Auto a3= new Auto("Hybrid", "Mazda", 111, 6, "azul", true, true,llanta,suspension,sonido,escape);
		Auto a4= new Auto("Highlander", "Toyota", 789, 10, "blanco", false, true,llanta,suspension,sonido,escape);
		Auto a5= new Auto("Hybrid", "Chevrolet", 222, 6, "cafe", true, true,llanta,suspension,sonido,escape);
		Auto a6= new Auto("Hybrid", "Mazda", 333, 6, "verde", false, true,llanta,suspension,sonido,escape);
		Auto a7= new Auto("Hybrid", "Mazda", 444, 6, "rosa", false, true,llanta,suspension,sonido,escape);
		
		//Clientes
		Cliente c1= new Cliente("Ana González", 305478921, 87654321, "Calle 5ta, #10-23", "Bogotá", "Toyota", 40000000);
		Cliente c2= new Cliente("Juan Pérez", 102367459, 300987654, "Carrera 12, #34-56", "Medellín", "Toyota", 35000000);
		Cliente c3= new Cliente("María Sánchez", 745631982, 500123456, "Calle 8, #19-45", "Cali", "Mazda", 60000000);
		Cliente c4= new Cliente("Javier Castro", 958762341, 900654321, "Avenida Las Palmas, #6-78", "Barranquilla", "Chevrolet", 55000000);
		Cliente c5= new Cliente("Roberto Palacio", 1000413512, 556656, "Carrera 20 #2-55", "Medellin", "Hybrid", 30000000);
		//Mecanicos
		Mecanico mecanico = new Mecanico("Carlos Martinez", 1234567890L, 9876543210L, "carlos@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123456L,"Toyota","Pintura",340000);
		Mecanico mecanico1 = new Mecanico("Laura Hernandez", 1234567891L, 9876543211L, "laura@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123457L,"Mazda","Pintura",340000);
		Mecanico mecanico2 = new Mecanico("Mario Gonzalez", 1234567892L, 9876543212L, "mario@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123458L,"Chevrolet","Pintura",340000);
		Mecanico mecanico3 = new Mecanico("Daniela Ramirez", 1234567893L, 9876543213L, "daniela@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123459L,"Toyota","Llantas",50000);
		Mecanico mecanico4 = new Mecanico("Manuel Torres", 1234567894L, 9876543214L, "manuel@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123460L,"Mazda","Llantas",50000);
		Mecanico mecanico5 = new Mecanico("Lucia Perez", 1234567895L, 9876543215L, "lucia@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123461L,"Chevrolet","Llantas",50000);
		Mecanico mecanico6 = new Mecanico("Andres Castro", 1234567896L, 9876543216L, "andres@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123462L,"Toyota","Motor",15000);
		Mecanico mecanico7 = new Mecanico("Sofia Hernandez", 1234567897L, 9876543217L, "sofia@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123463L,"Mazda","Motor",15000);
		Mecanico mecanico8 = new Mecanico("Javier Diaz", 1234567898L, 9876543218L, "javier@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123464L,"Chevrolet","Motor",15000);
		Mecanico mecanico9 = new Mecanico("Monica Rodriguez", 1234567899L, 9876543219L, "monica@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123465L,"Toyota","Frenos",57000);
		Mecanico mecanico10 = new Mecanico("Juadsadn Perez", 1234567894L, 9876543210L, "juanperez@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123456L,"Mazda","Frenos",57000);
		Mecanico mecanico11 = new Mecanico("Juaco Gomez", 1234567895L, 9876543211L, "jgomez@example.com", "Calle 456", 2500.0, "Banco Y", 2345678901234567L, "Chevrolet", "Frenos",57000);
		Mecanico mecanico12 = new Mecanico("Pedro Rodriguez", 1234567896L, 9876543212L, "pedrorodriguez@example.com", "Calle 789", 3000.0, "Banco Z", 3456789012345678L, "Toyota", "Pintura",340000);
		Mecanico mecanico13 = new Mecanico("Maria Martinez", 1234567897L, 9876543213L, "mariamartinez@example.com", "Calle 012", 3500.0, "Banco X", 4567890123456789L, "Mazda", "Llantas",50000);
		Mecanico mecanico14 = new Mecanico("Juan Lopez", 1234567898L, 9876543214L, "juanlopez@example.com", "Calle 345", 4000.0, "Banco Y", 5678901234567890L, "Chevrolet", "Motor",15000);

		// Vendedor
		Vendedor vendedor1 = new Vendedor("Juan", 123456789, 5551234, "juan@ejemplo.com", "Av. Siempre Viva 123", 1000.0, "Banco Ejemplo", 987654321,"Vitrina");
		Vendedor vendedor2 = new Vendedor("Pedro", 987654321, 5554321, "pedro@ejemplo.com", 1500.0, "Banco Otro Ejemplo", 123456789,"Repuestos");
		Vendedor vendedor3 = new Vendedor("María", 456789123, 5557890, "maria@ejemplo.com", "Calle Principal 456", 1200.0, "Banco Ejemplo", 654321987,"Vitrina");
		Vendedor vendedor4 = new Vendedor("Luis", 789123456, 5552468, "luis@ejemplo.com", 1800.0, "Banco Otro Ejemplo", 321654987,"Repuestos");
		Vendedor vendedor5 = new Vendedor("Ana", 321654987, 5551357, "ana@ejemplo.com", "Avenida Central 789", 900.0, "Banco Ejemplo", 147258369,"Vitrina");
		Vendedor vendedor6 = new Vendedor("Jorge", 654789321, 5558642, "jorge@ejemplo.com", 2000.0, "Banco Otro Ejemplo", 963852741,"Repuestos");
		Vendedor vendedor7 = new Vendedor("Carla", 789654123, 5552795, "carla@ejemplo.com", "Calle Secundaria 321", 1500.0, "Banco Ejemplo", 369852147,"Vitrina");

		//Articulos aceites
		Articulo articulo1= new Articulo("Basico","taller","Motor","aceite mineral", "automovil y camioneta", "SHELL HELIX HX5 15W-50", 45000, 100);
		Articulo articulo2= new Articulo("Basico","taller","Motor","aceite sintetico", "automovil y camioneta", "Aceite 5w20 Mobil 2000 – cuarto", 33900, 100);
		Articulo articulo3= new Articulo("Basico","taller","Motor","aceite semisintetico", "automovil y camioneta", "Aceite 5w40 Mobil 3000 – cuarto", 34900, 100);
				
		//Articulos llantas
		Articulo articulo4= new Articulo("Basico","taller","Llantas","Llanta todo terreno", "automovil y camioneta", "GoodYear", 745000, 100);
		Articulo articulo5= new Articulo("Basico","taller","Llantas","Llanta todo terreno", "automovil y camioneta", "Michelin", 1150000, 99);
		Articulo articulo6= new Articulo("Basico","taller","Llantas","Llanta terreno de barro", "automovil y camioneta", "Bridgestone", 750000, 100);
		Articulo articulo7= new Articulo("Basico","taller","Llantas","Llanta terreno de barro", "automovil y camioneta", "Yokohama Geolanda", 1899000, 100);
		Articulo articulo8= new Articulo("Basico","taller","Llantas","Llanta terreno de asfalto", "automovil y camioneta", "Goodyear", 650000, 100);
		Articulo articulo9= new Articulo("Basico","taller","Llantas","Llanta terreno de asfalto", "automovil y camioneta", "michelin", 1000000, 100);
		//Articulos frenos
		Articulo articulo10 = new Articulo("Basico","taller","Frenos", "Frenos de disco delanteros", "automóvil", "Brembo", 980000, 50);
		Articulo articulo11 = new Articulo("Basico","taller","Frenos", "Frenos de disco traseros", "automóvil", "Ferodo", 640000, 35);
		Articulo articulo12 = new Articulo("Basico","taller","Frenos", "Frenos de tambor delanteros", "automovil y camioneta", "Wabco", 2350000, 25);
		Articulo articulo13 = new Articulo("Basico","taller","Frenos", "Frenos de tambor traseros", "automovil y camioneta", "Bendix", 2150000, 30);
		Articulo articulo14 = new Articulo("Basico","taller","Frenos", "Frenos de disco delanteros y traseros", "automovil y camioneta", "Beringer", 440000, 20);
		Articulo articulo15 = new Articulo("Basico","taller","Frenos", "Frenos de tambor delanteros y traseros", "automovil y camioneta", "Wabco", 88000, 50);
		//Articulos Pintura
		Articulo articulo16 = new Articulo("Basico","taller","Pintura", "Pintura acrílica blanca", "interior y exterior", "Behr", 300000, 50);
		Articulo articulo17 = new Articulo("Basico","taller","Pintura", "Pintura acrílica gris", "interior y exterior", "Sherwin Williams", 250000, 60);
		Articulo articulo18 = new Articulo("Basico","taller","Pintura", "Pintura esmalte roja", "interior y exterior", "Pintuco", 200000, 70);
		Articulo articulo19 = new Articulo("Basico","taller","Pintura", "Pintura para pizarrón negro", "interior", "Rust-Oleum", 100000, 30);
		Articulo articulo20 = new Articulo("Basico","taller","Pintura", "Pintura en spray dorada", "interior y exterior", "Krylon", 50000, 80);
		Articulo articulo21 = new Articulo("Basico","taller","Pintura", "Pintura acrílica verde oliva", "interior y exterior", "Glidden", 280000, 45);
		
		Articulo articulo22 = new Articulo("premium", "repuesto", "Motor", "Bomba de agua", "automóvil", "Airtex", 350000, 10, "Toyota");
		Articulo articulo23 = new Articulo("premium", "repuesto", "Escape", "Silenciador", "automóvil", "MagnaFlow", 1200000, 5, "Chevrolet");
		Articulo articulo24 = new Articulo("premium", "repuesto", "Sonido", "Sistema de audio", "automóvil", "JBL", 1500000, 3, "Mazda");
		Articulo articulo25 = new Articulo("premium", "repuesto", "Suspension", "Amortiguador", "camioneta", "Bilstein", 850000, 8, "Toyota");
		Articulo articulo26 = new Articulo("premium", "repuesto", "Motor", "Filtro de aire", "automóvil", "K&N", 180000, 20, "Chevrolet");
		Articulo articulo27 = new Articulo("premium", "repuesto", "Escape", "Sistema de escape deportivo", "automóvil", "BORLA", 2500000, 2, "Mazda");
		Articulo articulo28 = new Articulo("premium", "repuesto", "Sonido", "Subwoofer", "automóvil", "Alpine", 650000, 6, "Toyota");
		Articulo articulo29 = new Articulo("premium", "repuesto", "Suspension", "Kit de levante", "camioneta", "Rancho", 3200000, 1, "Chevrolet");
		Articulo articulo30 = new Articulo("premium", "repuesto", "Motor", "Bujías de alto rendimiento", "automóvil", "NGK", 140000, 15, "Mazda");
		Articulo articulo31 = new Articulo("premium", "repuesto", "Escape", "Cabezal de escape", "automóvil", "Gibson", 2100000, 4, "Toyota");

		Articulo articulo32 = new Articulo("Basico","repuesto","Motor", "Filtro de aire", "automóvil", "FRAM", 45000, 100, "Mazda");
		Articulo articulo33 = new Articulo("Basico","repuesto","Motor", "Bujías", "automóvil", "NGK", 40000, 80, "Toyota");
		Articulo articulo34 = new Articulo("Basico","repuesto","Escape", "Silenciador", "automóvil", "Walker", 150000, 50, "Chevrolet");
		Articulo articulo35 = new Articulo("Basico","repuesto","Escape", "Tubo de escape", "automóvil", "Bosal", 80000, 60, "Mazda");
		Articulo articulo36 = new Articulo("Basico","repuesto","Sonido", "Radio FM/AM", "automóvil", "Sony", 180000, 30, "Toyota");
		Articulo articulo37 = new Articulo("Basico","repuesto","Sonido", "Parlantes", "automóvil", "Pioneer", 120000, 40, "Chevrolet");
		Articulo articulo38 = new Articulo("Basico","repuesto","Suspension", "Amortiguador", "automóvil", "Monroe", 100000, 70);
		Articulo articulo39 = new Articulo("Basico","repuesto","Suspension", "Esfera de suspensión", "automóvil", "Sachs", 65000, 90);
		Articulo articulo40 = new Articulo("Basico","repuesto","Motor", "Bomba de agua", "automóvil", "Gates", 80000, 60);
		Articulo articulo41 = new Articulo("Basico","repuesto","Motor", "Correa de distribución", "automóvil", "Continental", 60000, 80);
		//Transaccion
		Transaccion tr1=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		Transaccion tr2=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		Transaccion tr3=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		Transaccion tr4=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		
		Transaccion tr5=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		Transaccion tr6=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		Transaccion tr7=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		Transaccion tr8=new TransaccionVenta ("efectivo",100,c1,a1,vendedor5);
		
		Transaccion tr9=new TransaccionVenta ("efectivo",100,c1,a1,vendedor1);
		Transaccion tr10=new TransaccionVenta ("efectivo",100,c1,a1,vendedor1);
		Transaccion tr11=new TransaccionVenta ("efectivo",100,c1,a1,vendedor1);
		Transaccion tr12=new TransaccionVenta ("efectivo",100,c1,a1,vendedor1);
		
		Transaccion tr13=new TransaccionTaller ("efectivo",100,c1,a1,articulo4,mecanico1);
		Transaccion tr14=new TransaccionTaller ("efectivo",100,c1,a1,articulo4,mecanico1);
		Transaccion tr15=new TransaccionTaller ("efectivo",100,c1,a1,articulo4,mecanico1);
		Transaccion tr16=new TransaccionTaller ("efectivo",100,c1,a1,articulo4,mecanico1);
		
		Transaccion tr17=new TransaccionVenta ("efectivo",200,c1,a1,vendedor2);
		Transaccion tr18=new TransaccionVenta ("efectivo",200,c1,a1,vendedor2);
		Transaccion tr19=new TransaccionVenta ("efectivo",200,c1,a1,vendedor2);
		Transaccion tr20=new TransaccionVenta ("efectivo",200,c1,a1,vendedor2);
		
		Transaccion tr21=new TransaccionVenta ("efectivo",300,c1,a1,vendedor3);
		Transaccion tr22=new TransaccionVenta ("efectivo",300,c1,a1,vendedor3);
		Transaccion tr23=new TransaccionVenta ("efectivo",300,c1,a1,vendedor3);
		Transaccion tr24=new TransaccionVenta ("efectivo",300,c1,a1,vendedor3);

	
		/*INTERFAZ*/
		byte input;
		String salir = null;
		do {
			System.out.println("\n\nMenú principal Concesionario");
			System.out.println("1. Venta de Autos");
			System.out.println("2. Venta de Repuestos");
			System.out.println("3. Taller");
			System.out.println("4. Consultar estadisticas de ventas");
			System.out.print("Ingrese el número de la opción que va a utilizar: ");
			
			input = sc.nextByte();
			
			switch (input) {
			case 1:
				procesoVenta();
				break;
			case 2:
				ventaRepuestos();
				break;
			case 3:
				procesoTaller();
				break;
			case 4:
				stats();
				break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			}
		}while(salir=="no");
		
		
		/*INTERFAZ*/
		
	}
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
		if (sc.nextInt()==0) {
			System.out.println("1. Mostrar Autos por Marca");
			System.out.println("2. Mostrar Autos por precio");
			System.out.println("3. Mostrar todos los autos");
			System.out.println("4. Volver");
			System.out.println("Seleccione una opción");
			switch (sc.nextInt()){
				case 1:
					InventarioAuto.autosMarca();
					break;
				case 2:
					int cont = 1;
					for (Auto carro: InventarioAuto.getAutosporPrecio()) {
						System.out.println(cont + ". " + carro.info());
						++cont;
					}
					break;
				case 3:
					System.out.println(InventarioAuto.autosDisponibles());
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
			TransaccionVenta transaccion = null;
			
		while (propietario == null || transaccion == null) {
			System.out.print("Introduzca la cédula del propietario: ");
			long cedula = sc.nextLong(); 
			sc.nextLine();
			propietario = TransaccionVenta.getClientePorCedula(cedula);
			transaccion = TransaccionVenta.getTransaccionporCedula(cedula);
			
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
				propietario = TransaccionVenta.getClientePorCedula(cedula);
				transaccion = TransaccionVenta.getTransaccionporCedula(cedula);
				System.out.print(propietario.info());
				
				if (propietario == null || transaccion == null) {
					System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.");
				}
			}
			
		}
		if (confirmarPrp.equals("si")) {
			String confirmarMech=null;
	        System.out.println("\n\nQue deseas hacerle al Vehiculo");
	        System.out.println("1. Latoneria y pintura");
	        System.out.println("2. Cambio de Llantas y alineacion");
	        System.out.println("3. Cambio de Aceite");
	        System.out.println("4. Cambio de Frenos");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");
			ArrayList<Mecanico> mecanicos=Mecanico.mecanicoDisponible();
			Mecanico mecanico=Mecanico.selector(mecanicos, transaccion.auto);
			System.out.print(mecanico.info());
			while (confirmarMech==null||confirmarMech.equals("no")) {
				
				System.out.print("¿Confirmar mecanico? (si/no)");
				confirmarMech = sc.nextLine();
				if (confirmarMech.equals("no")) {
					mecanicos=Mecanico.mecanicoDisponible();
					mecanico=Mecanico.selector(mecanicos, transaccion.auto);
					System.out.print(mecanico.info());
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
					
					System.out.print(new TransaccionTaller("taller",costoTotal,propietario,propietario.getAuto(),producto, mecanico).info()+"\n");
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
			
			for (TransaccionVenta transacc: TransaccionVenta.getTransaccionesven())
			{
				if (vendedores1.contains(transacc.getVendedor().getNombre())){
					
				} else {
					vendedores1.add(transacc.getVendedor().getNombre());
				}
			}
			
			float num = ((float)vendedores1.size() / Vendedor.getVendedores().size()) * 100;
			int roundedNum = Math.round(num);

			System.out.println("-------- De los " + Vendedor.getVendedores().size() + " vendedores, " + vendedores1.size()+ " (el " + roundedNum + "%) han logrado ventas en el mes, son: --------");
			
			for (String vend: vendedores1)
			{
				System.out.println(vend);
			}
			
			// para saber la cantidad total de dinero en ventas y # total de ventas:
			int sumaTotal=0;
			int contadorTotal=0;
			for (Transaccion trans1: Transaccion.getTransacciones())
				{sumaTotal+=trans1.getIngreso();
				contadorTotal+=1;}
			// para saber la cantidad total de dinero en ventas y # total de ventas:
			
			System.out.println("-------- Suma de dinero en ventas por vendedor: --------");
			
			for (String vend: vendedores1)
			{
				int suma = 0;
				int contador=0;
				for (TransaccionVenta trans1: TransaccionVenta.getTransaccionesven())
				{
					if (vend.equals(trans1.getVendedor().getNombre())){
						suma+=trans1.getIngreso();
						contador+=1;
					}
				}
				float num2 = ((float)suma / sumaTotal) * 100;
				int roundedSum = Math.round(num2);
				System.out.println(vend + ": " + suma + " $, el " + roundedSum + " % del total de ingresos por ventas de autos.");
			}
			
			System.out.println("-------- # de ventas, y promedio de ingreso por venta de cada vendedor: --------");
			
			for (String vend: vendedores1)
			{
				int contador=0;
				int suma2 = 0;
				for (TransaccionVenta trans1: TransaccionVenta.getTransaccionesven())
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
				
				System.out.println(vend + ": " + contador + ", el " + roundedNum4 + "% del número total de ventas, promediando " + num3 + " $ por venta.");
			}
			
			LocalDate fecha = LocalDate.now();
			int dia = fecha.getDayOfMonth();
			String nombreMes = fecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
			
			float num5 = ((float)sumaTotal/dia);
			int roundedNum5 = Math.round(num5);
			System.out.println("-------- Suma de ingresos total, y promedio de ingresos diarios en lo corrido del mes de " + nombreMes + ": --------");
			System.out.println("Suma total de ingresos: " + sumaTotal + ", promedio de ingresos diarios en lo corrido del mes de " + nombreMes + ": " + roundedNum5 + " $.");
			
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
	public static void personalizarAuto() {
		
	}


}
