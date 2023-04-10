package CapaLogica;

import java.util.ArrayList;

public class InventarioArticulo {
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
}
