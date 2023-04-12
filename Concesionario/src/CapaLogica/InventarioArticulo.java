package CapaLogica;

import java.util.ArrayList;
import java.util.Scanner;

public class InventarioArticulo {
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Articulo> articulos = new ArrayList<>();
    
    // Método para agregar un artículo al inventario
    public static void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }
    
    //Metodo para eliminar un articulo del inventario
    public void eliminarArticulo(Articulo articulo) {
    	articulos.remove(articulo);
    }
    
    //Metodo para obtener articulos
    
    public static ArrayList<Articulo> getArticulos() {
    	return articulos;
    }
    
    /* Metodo para  reemplazar la lista completa de articulos en el inventario 
     * con una nueva lista proporcionada.*/
    public static void setArticulos(ArrayList<Articulo> Articulos) {
    	InventarioArticulo.articulos = Articulos;
    }
    /*
    public static String articulosDisponibles() {
		String informacion = "Articulos Disponibles:\n";
		for (Articulo articulo : getArticulosDisponibles()) {
			informacion += articulo.getTipoArticulo() + " " + articulo.getTipoVehiculo() + " " + articulo.getMarca() + " " + articulo.getPrecio() + "\n";
		}
		return informacion; 
	}

	public static ArrayList<Articulo> getArticulosDisponibles() {
		ArrayList<Articulo> disponibles = new ArrayList<Articulo>();
		for (Articulo articulo : articulos) {
			if (articulo.isDisponible()) {
				disponibles.add(articulo);
			}
		}
		return disponibles;
	}
	*/
    // Método para mostrar la información de todos los artículos en el inventario
    public static void mostrarInventario() {
        System.out.println("Inventario de Artículos:");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.articulosDisponibles());
        }
    }
    public static  void buscarPorTipoArticulo() {
    	byte input;
		String salir = null;
		do {
			System.out.println("Seleccione el tipo de producto que necesita");
			System.out.println("1. Aceeites");
			System.out.println("2. Llantas");
			System.out.println("3. Frenos");
			System.out.print("Ingrese el número de la opción que va a utilizar: \n");
			
			input = sc.nextByte();
			
			switch (input) {
			case 1:
				byte input2;
				String salir2 = null;
				do {
					System.out.println("Seleccione el tipo de Aceite que necesita \n");
					System.out.println("1. aceite mineral");
					System.out.println("2. aceite sintetico");
					System.out.println("3. aceite semisintetico");
					System.out.print("Ingrese el número de la opción que va a utilizar: \n");
					
					input2 = sc.nextByte();
					
					switch (input2) {
					case 1:
						for (Articulo articulo : articulos) {
				    		if (articulo.getTipoArticulo() == "aceite mineral") {
				    			System.out.println(articulo.getTipoArticulo() + " Marca " + articulo.getMarca() + " para " + articulo.getTipoVehiculo());
				    			System.out.println("Precio: " + articulo.getPrecio());
				    			System.out.println("cantidad disponible: " + articulo.getCantidad());
				    		}	 
				    	}
						break;
					case 2:
						for (Articulo articulo : articulos) {
				    		if (articulo.getTipoArticulo() == "aceite sintetico") {
				    			System.out.println(articulo.getTipoArticulo() + " Marca " + articulo.getMarca() + " para " + articulo.getTipoVehiculo());
				    			System.out.println("Precio: " + articulo.getPrecio());
				    			System.out.println("cantidad disponible: " + articulo.getCantidad());
				    		}
						}
						break;
					case 3:
						for (Articulo articulo : articulos) {
				    		if (articulo.getTipoArticulo() == "aceite semisintetico") {
				    			System.out.println(articulo.getTipoArticulo() + " Marca " + articulo.getMarca() + " para " + articulo.getTipoVehiculo());
				    			System.out.println("Precio: " + articulo.getPrecio());
				    			System.out.println("cantidad disponible: " + articulo.getCantidad());
				    		}
						}
						break;
					default:
						System.out.print("\n¿Salir? (si/no)");
						salir2 = sc.nextLine();
						
					}
				}while(salir2=="no");
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
				
			case 2:
				byte input3;
				String salir3 = null;
				do {
					System.out.println("Seleccione el tipo de Aceite que necesita \n");
					System.out.println("1. Llanta todo terreno");
					System.out.println("2. Llanta terreno de barro");
					System.out.println("3. Llanta terreno de asfalto");
					System.out.print("Ingrese el número de la opción que va a utilizar: \n");
					
					input3 = sc.nextByte();
					
					switch (input3) {
					case 1:
						for (Articulo articulo : articulos) {
				    		if (articulo.getTipoArticulo() == "Llanta todo terreno") {
				    			System.out.println(articulo.getTipoArticulo() + " Marca " + articulo.getMarca() + " para " + articulo.getTipoVehiculo());
				    			System.out.println("Precio: " + articulo.getPrecio());
				    			System.out.println("cantidad disponible: " + articulo.getCantidad());
				    		}	 
				    	}
						break;
					case 2:
						for (Articulo articulo : articulos) {
				    		if (articulo.getTipoArticulo() == "Llanta terreno de barro") {
				    			System.out.println(articulo.getTipoArticulo() + " Marca " + articulo.getMarca() + " para " + articulo.getTipoVehiculo());
				    			System.out.println("Precio: " + articulo.getPrecio());
				    			System.out.println("cantidad disponible: " + articulo.getCantidad());
				    		}
						}
						break;
					case 3:
						for (Articulo articulo : articulos) {
				    		if (articulo.getTipoArticulo() == "Llanta terreno de asfalto") {
				    			System.out.println(articulo.getTipoArticulo() + " Marca " + articulo.getMarca() + " para " + articulo.getTipoVehiculo());
				    			System.out.println("Precio: " + articulo.getPrecio());
				    			System.out.println("cantidad disponible: " + articulo.getCantidad());
				    		}
						}
						break;
					default:
						System.out.print("\n¿Salir? (si/no)");
						salir3 = sc.nextLine();
						
					}
				}while(salir3=="no");
			}
		}while(salir=="no");
				
    	/*for (Articulo articulo : articulos) {
    		if (articulo.getTipoArticulo() == tipoArticulo) {
    			System.out.println(articulo.articulosDisponibles());
    		}	 
    	}*/
    }
}
