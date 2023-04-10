package CapaLogica;
import java.util.*;
import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Auto a1= new Auto("Cupra Leon", "Cupra", 20000000, 5400, "verde fofo", true, false);
		Auto a2= new Auto("Corolla", "Toyota", 456, 5, "negro", false, true);
		Auto a3= new Auto("Hybrid", "Mazda", 111, 6, "azul", true, true);
		Auto a4= new Auto("Highlander", "Toyota", 789, 10, "blanco", false, false);
		Auto a5= new Auto("Hybrid", "Mazda", 222, 6, "cafe", true, true);
		Auto a6= new Auto("Hybrid", "Mazda", 333, 6, "verde", false, true);
		Auto a7= new Auto("Hybrid", "Mazda", 444, 6, "rosa", false, false);
		Cliente c1= new Cliente("Ernesto",123443222,556655,"trtr","avenida siempreviva","cupra",23000000);
		Mecanico mecanico = new Mecanico("Juan Perez", 1234567890L, 9876543210L, "juanperez@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123456L,new String[] {"Toyota","Mazda"});
		Vendedor vendedor1 = new Vendedor("Juan", 123456789, 5551234, "juan@ejemplo.com", "Av. Siempre Viva 123", 1000.0, "Banco Ejemplo", 987654321);
		Vendedor vendedor2 = new Vendedor("Pedro", 987654321, 5554321, "pedro@ejemplo.com", 1500.0, "Banco Otro Ejemplo", 123456789);
		
		//Articulos aceites
		Articulo articulo1= new Articulo("aceite mineral", "automovil y camioneta", "SHELL HELIX HX5 15W-50", 45000);
		Articulo articulo2= new Articulo("aceite sintetico", "automovil y camioneta", "Aceite 5w20 Mobil 2000 – cuarto", 33900);
		Articulo articulo3= new Articulo("aceite semisintetico", "automovil y camioneta", "Aceite 5w40 Mobil 3000 – cuarto", 34900);
				
		//Articulos llantas
		Articulo articulo4= new Articulo("Llanta todo tereno", "automovil y camioneta", "GoodYear", 745000);
		Articulo articulo5= new Articulo("Llanta todo tereno", "automovil y camioneta", "Michelin", 1150000);
		Articulo articulo6= new Articulo("llanta tereno de barro", "automovil y camioneta", "Bridgestone", 750000);
		Articulo articulo7= new Articulo("llanta tereno de barro", "automovil y camioneta", "Yokohama Geolanda", 1899000);
		Articulo articulo8= new Articulo("llanta terreno de asfalto", "automovil y camioneta", "Goodyear", 650000);
		Articulo articulo9= new Articulo("llanta terreno de asfalto", "automovil y camioneta", "michelin", 1000000);
		
	
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
				InventarioArticulo.mostrarInventario();
				break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			}
		}while(salir=="no");
		
		
		/*INTERFAZ*/
		
	}

}
