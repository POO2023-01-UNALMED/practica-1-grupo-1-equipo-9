package CapaLogica;
import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Autos
		Auto a1= new Auto("Cupra Leon", "Toyota", 20000000, 5400, "verde fofo", true, true);
		Auto a2= new Auto("Corolla", "Toyota", 456, 5, "negro", false, true);
		Auto a3= new Auto("Hybrid", "Mazda", 111, 6, "azul", true, true);
		Auto a4= new Auto("Highlander", "Toyota", 789, 10, "blanco", false, true);
		Auto a5= new Auto("Hybrid", "Chevrolet", 222, 6, "cafe", true, true);
		Auto a6= new Auto("Hybrid", "Mazda", 333, 6, "verde", false, true);
		Auto a7= new Auto("Hybrid", "Mazda", 444, 6, "rosa", false, true);
		//Clientes
		Cliente c1= new Cliente("Ana González", 305478921, 87654321, "Calle 5ta, #10-23", "Bogotá", "Toyota", 40000000);
		Cliente c2= new Cliente("Juan Pérez", 102367459, 300987654, "Carrera 12, #34-56", "Medellín", "Toyota", 35000000);
		Cliente c3= new Cliente("María Sánchez", 745631982, 500123456, "Calle 8, #19-45", "Cali", "Mazda", 60000000);
		Cliente c4= new Cliente("Javier Castro", 958762341, 900654321, "Avenida Las Palmas, #6-78", "Barranquilla", "Chevrolet", 55000000);
		Cliente c5= new Cliente("Roberto Palacio", 123443226, 556656, "Carrera 20 #2-55", "Medellin", "Hybrid", 30000000);
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

		
		Vendedor vendedor1 = new Vendedor("Juan", 123456789, 5551234, "juan@ejemplo.com", "Av. Siempre Viva 123", 1000.0, "Banco Ejemplo", 987654321);
		Vendedor vendedor2 = new Vendedor("Pedro", 987654321, 5554321, "pedro@ejemplo.com", 1500.0, "Banco Otro Ejemplo", 123456789);
		Transaccion tr1=new Transaccion ("venta",vendedor1,2345738,c1,a1);
		Transaccion tr2=new Transaccion ("venta",vendedor1,2345738,c2,a2);
		Transaccion tr3=new Transaccion ("venta",vendedor1,2345738,c3,a3);
		Transaccion tr4=new Transaccion ("venta",vendedor1,2345738,c4,a4);
		
		//Articulos aceites
		Articulo articulo1= new Articulo("Motor","aceite mineral", "automovil y camioneta", "SHELL HELIX HX5 15W-50", 45000, 100);
		Articulo articulo2= new Articulo("Motor","aceite sintetico", "automovil y camioneta", "Aceite 5w20 Mobil 2000 – cuarto", 33900, 100);
		Articulo articulo3= new Articulo("Motor","aceite semisintetico", "automovil y camioneta", "Aceite 5w40 Mobil 3000 – cuarto", 34900, 100);
				
		//Articulos llantas
		Articulo articulo4= new Articulo("Llantas","Llanta todo terreno", "automovil y camioneta", "GoodYear", 745000, 100);
		Articulo articulo5= new Articulo("Llantas","Llanta todo terreno", "automovil y camioneta", "Michelin", 1150000, 99);
		Articulo articulo6= new Articulo("Llantas","Llanta terreno de barro", "automovil y camioneta", "Bridgestone", 750000, 100);
		Articulo articulo7= new Articulo("Llantas","Llanta terreno de barro", "automovil y camioneta", "Yokohama Geolanda", 1899000, 100);
		Articulo articulo8= new Articulo("Llantas","Llanta terreno de asfalto", "automovil y camioneta", "Goodyear", 650000, 100);
		Articulo articulo9= new Articulo("Llantas","Llanta terreno de asfalto", "automovil y camioneta", "michelin", 1000000, 100);
		//Articulos frenos
		Articulo articulo10 = new Articulo("Frenos", "Frenos de disco delanteros", "automóvil", "Brembo", 980000, 50);
		Articulo articulo11 = new Articulo("Frenos", "Frenos de disco traseros", "automóvil", "Ferodo", 640000, 35);
		Articulo articulo12 = new Articulo("Frenos", "Frenos de tambor delanteros", "automovil y camioneta", "Wabco", 2350000, 25);
		Articulo articulo13 = new Articulo("Frenos", "Frenos de tambor traseros", "automovil y camioneta", "Bendix", 2150000, 30);
		Articulo articulo14 = new Articulo("Frenos", "Frenos de disco delanteros y traseros", "automovil y camioneta", "Beringer", 440000, 20);
		Articulo articulo15 = new Articulo("Frenos", "Frenos de tambor delanteros y traseros", "automovil y camioneta", "Wabco", 88000, 50);
		//Articulos Pintura
		Articulo articulo16 = new Articulo("Pintura", "Pintura acrílica blanca", "interior y exterior", "Behr", 300000, 50);
		Articulo articulo17 = new Articulo("Pintura", "Pintura acrílica gris", "interior y exterior", "Sherwin Williams", 250000, 60);
		Articulo articulo18 = new Articulo("Pintura", "Pintura esmalte roja", "interior y exterior", "Pintuco", 200000, 70);
		Articulo articulo19 = new Articulo("Pintura", "Pintura para pizarrón negro", "interior", "Rust-Oleum", 100000, 30);
		Articulo articulo20 = new Articulo("Pintura", "Pintura en spray dorada", "interior y exterior", "Krylon", 50000, 80);
		Articulo articulo21 = new Articulo("Pintura", "Pintura acrílica verde oliva", "interior y exterior", "Glidden", 280000, 45);

	
		/*INTERFAZ*/
		byte input;
		String salir = null;
		do {
			System.out.println("\n\nMenú principal Concesionario");
			System.out.println("1. Empezar proceso de venta.");
			System.out.println("2. Taller");
			System.out.println("3. inventario de Articulos");
			System.out.print("Ingrese el número de la opción que va a utilizar: ");
			
			input = sc.nextByte();
			
			switch (input) {
			case 1:
				Financiero.procesoVenta();
				break;
			case 2:
				Financiero.procesoTaller();
				break;
			case 3:
				System.out.println("Articulos Disponibles:\n");
				InventarioArticulo.buscarPorTipoArticulo();
				break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			}
		}while(salir=="no");
		
		
		/*INTERFAZ*/
		
	}

}
