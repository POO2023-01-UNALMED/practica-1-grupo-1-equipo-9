package CapaLogica;

public class Articulo {
	private String especialidad;
    private  String tipoArticulo;
    private  String tipoVehiculo;
    private  double precio;
    private  String marca;
    private int cantidad; 
    
    // Constructor
    public Articulo(String especialidad,String tipoArticulo, String tipoVehiculo, String marca, double precio, int cantidad ) {
        this.tipoArticulo = tipoArticulo;
        this.especialidad = especialidad;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String info() {
		String texto = "Producto: " + getTipoArticulo() + "\n";
		return texto;
	}
	
   
    
}


    