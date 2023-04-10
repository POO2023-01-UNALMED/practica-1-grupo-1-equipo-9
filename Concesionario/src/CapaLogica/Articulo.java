package CapaLogica;

public class Articulo {
    private  String tipoArticulo;
    private  String tipoVehiculo;
    private  double precio;
    private  String marca;
    
    // Constructor
    public Articulo(String tipoArticulo, String tipoVehiculo, String marca, double precio ) {
        this.tipoArticulo = tipoArticulo;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.marca = marca;
        InventarioArticulo.articulos.add(this);
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
		String informacion = tipoArticulo + " " + tipoVehiculo + " " + marca + " " + precio + "\n"  ;
		
		return informacion; 
	}
   
    
}


    