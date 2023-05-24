package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.personal.*;

public class InventarioArticulo implements Serializable{
	private static final long serialVersionUID = 1L;
	protected static Scanner sc = new Scanner(System.in);
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
    public static ArrayList<Articulo> articuloDispo(Mecanico mecanico) {
  	   ArrayList<Articulo> prods = new ArrayList<Articulo>();
  	    for (Articulo articulo : getArticulos()) {
  	    	if (mecanico.getEspecialidad().equalsIgnoreCase("ModificacionPintura") && articulo.getEspecialidad().equalsIgnoreCase("Pintura") && articulo.getCantidad()>=1 ) {
  	    		prods.add(articulo);
  	    	}
  	    	else if (mecanico.getEspecialidad().equalsIgnoreCase("ModificacionLlantas") && articulo.getEspecialidad().equalsIgnoreCase("Llantas") && articulo.getCantidad()>=1) {
  	    		prods.add(articulo);
  	    	}
  	    	else if (mecanico.getEspecialidad().equalsIgnoreCase("ModificacionSonido") && articulo.getEspecialidad().equalsIgnoreCase("Sonido") && articulo.getCantidad()>=1) {
  	    		prods.add(articulo);
  	    	}
  	    	else if (mecanico.getEspecialidad().equalsIgnoreCase("ModificacionFrenos") && articulo.getEspecialidad().equalsIgnoreCase("Frenos") && articulo.getCantidad()>=1) {
  	    		prods.add(articulo);
  	    	}
  	    	else if (mecanico.getEspecialidad().equalsIgnoreCase("ModificacionEscape") && articulo.getEspecialidad().equalsIgnoreCase("Escape") && articulo.getCantidad()>=1) {
  	    		prods.add(articulo);
  	    	}
  	    	else if (mecanico.getEspecialidad().equals(articulo.getEspecialidad())&& articulo.getCantidad()>=1) {
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
            case 5: 
            	especialidad="Pintura";
            	for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 6: 
            	especialidad="Llanta";
            	for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 7: 
            	especialidad="Sonido";
            	for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 8: 
            	especialidad="Frenos";
            	for (Articulo articulo : InventarioArticulo.getRepuesto()) {
        	        if (especialidad.equals(articulo.getEspecialidad())) {
        	            artic.add(articulo);
        	        }
        	        salir="si";
        	    }
                break;
            case 9: 
            	especialidad="Escape";
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
    public static ArrayList<Articulo> selectorCalidad(ArrayList<Articulo> artic) {
    	String salir=null;
		 byte input;
		 String calidad=null;
		 ArrayList<Articulo> articul = new ArrayList<Articulo>();
		do {
	        input = sc.nextByte();
	        switch (input) {
	        case 1:
               calidad="premium";
	       	    for (Articulo ar : artic) {
	       	        if (calidad.equals(ar.getCalidad())) {
	       	            articul.add(ar);
	       	        }
	       	    }
	       	 salir="si";
	       	    
               break;
           case 2:
               calidad="Basico";
	       	    for (Articulo ar : artic) {
	       	        if (calidad.equals(ar.getCalidad())) {
	       	            articul.add(ar);
	       	        }
	       	    }
	       	 salir="si";
	       	    
               break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
		}while(salir==null);
		return articul;
   }
    public static ArrayList<Articulo> selectorMarca(ArrayList<Articulo> artic) {
    	String salir=null;
		 byte input;
		 String marca=null;
		 ArrayList<Articulo> articul = new ArrayList<Articulo>();
		do {

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
    public static ArrayList<Articulo> selectorTipoLlantas(ArrayList<Articulo> llantas) {
    	String salir=null;
		 byte input;
		 String tipoLlanta=null;
		 ArrayList<Articulo> articul = new ArrayList<Articulo>();
		do {
	        input = sc.nextByte();
	        switch (input) {
	        case 1:
               tipoLlanta="Llanta todo terreno";
	       	    for (Articulo ar : llantas) {
	       	        if (tipoLlanta.equals(ar.getTipoArticulo())) {
	       	            articul.add(ar);
	       	        }
	       	    }
	       	 salir="si";
	       	    
               break;
           case 2:
        	   tipoLlanta="Llanta terreno de barro";
	       	    for (Articulo ar : llantas) {
	       	        if (tipoLlanta.equals(ar.getTipoArticulo())) {
	       	            articul.add(ar);
	       	        }
	       	    }
	       	 salir="si";
	       	    
               break;
           case 3:
        	   tipoLlanta="Llanta terreno de asfalto";
	       	    for (Articulo ar : llantas) {
	       	        if (tipoLlanta.equals(ar.getTipoArticulo())) {
	       	            articul.add(ar);
	       	        }
	       	    }
	       	 salir="si";
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
		}while(salir==null);
		return articul;
   }
}
