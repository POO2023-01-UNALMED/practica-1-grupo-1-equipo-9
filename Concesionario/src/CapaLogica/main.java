package CapaLogica;
import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Auto a1= new Auto("Cupra Leon", "Cupra", 20000000, 5400, "verde fofo", true, false);
		Auto a2= new Auto("Corolla", "Toyota", 456, 5, "negro", false, true);
		Auto a3= new Auto("Hybrid", "Mazda", 111, 6, "azul", true, true);
		Auto a4= new Auto("Highlander", "Toyota", 789, 10, "blanco", false, true);
		Auto a5= new Auto("Hybrid", "Mazda", 122, 6, "cafe", true, true);
		Auto a6= new Auto("Hybrid", "Mazda", 333, 6, "verde", false, true);
		Auto a7= new Auto("Hybrid", "Mazda", 444, 6, "rosa", false, false);
		Cliente c1= new Cliente("Ernesto",123443222,556655,"trtr","avenida siempreviva","cupra",23000000);
		Mecanico mecanico = new Mecanico("Juan Perez", 1234567890L, 9876543210L, "juanperez@example.com", "Calle 123", 2000.0, "Banco X", 1234567890123456L,new String[] {"Toyota","Mazda"});
		Vendedor vendedor1 = new Vendedor("Juan", 123456789, 5551234, "juan@ejemplo.com", "Av. Siempre Viva 123", 1000.0, "Banco Ejemplo", 987654321);
		Vendedor vendedor2 = new Vendedor("Pedro", 987654321, 5554321, "pedro@ejemplo.com", 1500.0, "Banco Otro Ejemplo", 123456789);

		System.out.print(a1.isDisponible());
		System.out.println();
		System.out.print(c1.getCorreo());
		System.out.println();
		System.out.print(mecanico.getBanco());
		System.out.println();
		System.out.print(vendedor1.getDireccion());
		System.out.println();
		System.out.print(vendedor2.getCuentaBanco());
		System.out.println();
		System.out.println(InventarioAuto.autosDisponibles());
		/*INTERFAZ*/
		byte input;
		String salir = null;
		do {
			System.out.println("\n\nMenú principal Concesionario");
			System.out.println("1. Empezar proceso de venta.");
			System.out.print("Ingrese el número de la opción que va a utilizar: ");
			
			input = sc.nextByte();
			
			switch (input) {
			case 1:
				Financiero.procesoVenta();
				break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			}
		}while(salir=="no");
		
		/*INTERFAZ*/
	}

}
