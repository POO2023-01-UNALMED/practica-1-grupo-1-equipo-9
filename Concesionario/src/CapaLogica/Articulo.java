package CapaLogica;

public class Articulo {
    private static String tipoArticulo;
    private static String tipoVehiculo;
    private static double precio;
    private static String marca;
    
    // Constructor
    public Articulo(String tipoArticulo, String tipoVehiculo, double precio, String marca) {
        this.tipoArticulo = tipoArticulo;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.marca = marca;
    }
    
    // Getters y Setters
    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
	
	public String articulosDisponibles() {
		String informacion = "Articulos Disponibles:\n";
		informacion += tipoArticulo + " " + tipoVehiculo + " " + marca + " " + precio + "\n";
		
		return informacion; 
	}
   
    
}


    