package CapaLogica;

import java.util.ArrayList;
import java.util.Scanner;

public class InventarioArticulo {
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Articulo> articulos = new ArrayList<>();
    static ArrayList<Articulo> repuestos = new ArrayList<>();
    
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
    // Método para agregar un artículo al inventario
    public static void agregarRepuesto(Articulo repuesto) {
        repuestos.add(repuesto);
    }
    
    //Metodo para eliminar un articulo del inventario
    public void eliminarRepuesto(Articulo repuesto) {
    	repuestos.remove(repuesto);
    }
    
    //Metodo para obtener articulos
    
    public static ArrayList<Articulo> getRepuesto() {
    	return repuestos;
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
			System.out.println("1. Aceites");
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
   public static ArrayList<Articulo> articuloDispo(Mecanico mecanico) {
 	   ArrayList<Articulo> prods = new ArrayList<Articulo>();
 	    for (Articulo articulo : getArticulos()) {
 	        if (mecanico.getEspecialidad().equals(articulo.getEspecialidad())) {
 	            prods.add(articulo);
 	        }
 	    }
 	    return prods;
 		
 	}
    public static ArrayList<Articulo> selectorEspecial() {

		String salir=null;
		 byte input;
		 String especialidad=null;
		 ArrayList<Articulo> artic = new ArrayList<Articulo>();
		do {
			System.out.print("¿Que repuesto deseas Comprar?"+"\n");
	        System.out.println("1. Repuestos de Motor");
	        System.out.println("2. Escapes");
	        System.out.println("3. Sistema de Sonido");
	        System.out.println("4. Suspension");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");
	        input = sc.nextByte();

	        switch (input) {
	        case 1:
                especialidad="Motor";
        	    for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 2:
                especialidad="Escape";
        	    for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 3:
                especialidad="Sonido";
        	    for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 4:
                especialidad="Suspension";
        	    for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
		}while(salir==null);
		return artic;
    }
    public static Articulo selectorCalidad(ArrayList<Articulo> artic) {
    	String salir=null;
    	Articulo articulo=null;
		 byte input;
		 String calidad=null;
		 ArrayList<Articulo> articul = new ArrayList<Articulo>();
		do {
			System.out.print("¿Que calidad desea?"+"\n");
	        System.out.println("1. Premium");
	        System.out.println("2. Basico");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");
	        input = sc.nextByte();

	        switch (input) {
	        case 1:
               calidad="premium";
               String result = String.format("%-40s%-20s%-10s%n", "   Producto", "   Marca", "   Precio");
	       	    int i = 0;
	       	    for (Articulo ar : artic) {
	       	        if (calidad.equals(ar.getCalidad())) {
	       	            i++;
	       	            articul.add(ar);
	       	            String articulinfo = String.format("%-40s%-20s%-10s%n", ar.getTipoArticulo(), ar.getMarca(),ar.getPrecio());
	       	            result += String.format("%-3d%s", i, articulinfo);
	       	        }
	       	    }
;
	       	    if (articul.size() >= 1) {
	       	        System.out.println("Los productos " + calidad + " disponibles son:\n");
	       	        System.out.println(result);
	       	        int num = 0;
	       	        while (num <= 0 || num > articul.size()) {
	       	            System.out.println("Seleccione el numero del producto" + "[1-" + articul.size() + "]: ");
	       	            if (sc.hasNextInt()) {
	       	                num = sc.nextInt();
	       	            } else {
	       	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + articul.size() + ".");
	       	                sc.nextLine(); // Limpiar la entrada no válida
	       	            }
	       	        }
	       	        articulo = articul.get(num - 1);
	
	       	    } else if (articul.size() == 0) {
	       	        System.out.println("No hay productos disponibles que atiendan su vehiculo");
	       	    }
	       	 salir="si";
	       	    
               break;
           case 2:
               calidad="Basico";
               String result1 = String.format("%-40s%-20s%-10s%n", "   Producto", "   Marca", "   Precio");
	       	    int j = 0;
	       	    for (Articulo ar : artic) {
	       	        if (calidad.equals(ar.getCalidad())) {
	       	            j++;
	       	            articul.add(ar);
	       	            String articulinfo = String.format("%-40s%-20s%-10s%n", ar.getTipoArticulo(), ar.getMarca(),ar.getPrecio());
	       	            result1 += String.format("%-3d%s", j, articulinfo);
	       	        }
	       	    }
;
	       	    if (articul.size() >= 1) {
	       	        System.out.println("Los productos " + calidad + " disponibles son:\n");
	       	        System.out.println(result1);
	       	        int num = 0;
	       	        while (num <= 0 || num > articul.size()) {
	       	            System.out.println("Seleccione el numero del producto" + "[1-" + articul.size() + "]: ");
	       	            if (sc.hasNextInt()) {
	       	                num = sc.nextInt();
	       	            } else {
	       	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + articul.size() + ".");
	       	                sc.nextLine(); // Limpiar la entrada no válida
	       	            }
	       	        }
	       	        articulo = articul.get(num - 1);
	
	       	    } else if (articul.size() == 0) {
	       	        System.out.println("No hay productos disponibles que atiendan su vehiculo");
	       	    }
	       	 salir="si";
	       	    
               break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
		}while(salir==null);
		return articulo;
   }
    public static ArrayList<Articulo> selectorMarca(ArrayList<Articulo> artic) {
    	String salir=null;
		 byte input;
		 String marca=null;
		 ArrayList<Articulo> articul = new ArrayList<Articulo>();
		do {
			System.out.print("¿Que Marca de auto posee?"+"\n");
	        System.out.println("1. Toyota");
	        System.out.println("2. Mazda");
	        System.out.println("3. Chevrolet");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");
	        input = sc.nextByte();

	        switch (input) {
	        case 1:
                marca="Toyota";
        	    for (Articulo ar : artic) {
        	        if (marca.equals(ar.getMarcaVehiculo())) {
        	            articul.add(ar);
        	        }
        	        salir="si";
        	    }
                break;
            case 2:
                marca="Mazda";
        	    for (Articulo ar : artic) {
        	        if (marca.equals(ar.getMarcaVehiculo()) ) {
        	            articul.add(ar);
        	        }
        	        salir="si";
        	    }
                break;
            case 3:
                marca="Chevrolet";
        	    for (Articulo ar : artic) {
        	        if (marca.equals(ar.getMarcaVehiculo()) ) {
        	            articul.add(ar);
        	        }
        	        salir="si";
        	    }
                break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
		}while(salir==null);
		return articul;
   }	
}

