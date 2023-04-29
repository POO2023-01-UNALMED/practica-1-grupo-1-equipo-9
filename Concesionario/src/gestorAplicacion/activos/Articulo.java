package gestorAplicacion.activos;

import java.io.Serializable;

public class Articulo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String calidad;
	private String tipo;
	private String especialidad;
    private  String tipoArticulo;
    private  String tipoVehiculo;
    private  double precio;
    private  String marca;
    public int cantidad; 
    private String marcaVehiculo;
    public long referencia;
    
    // Constructor
    public Articulo(String calidad,String tipo,String especialidad,String tipoArticulo, String tipoVehiculo, String marca, double precio, int cantidad,long referencia ) {
        this.calidad=calidad;
    	this.tipo=tipo;
    	this.tipoArticulo = tipoArticulo;
        this.especialidad = especialidad;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
        this.referencia=referencia;
        
        if(tipo.equals("taller")) {
        	InventarioArticulo.articulos.add(this);
        	this.marcaVehiculo="Generico";
        }
        else if(tipo.equals("repuesto")) {
        	InventarioArticulo.repuestos.add(this);
        	this.marcaVehiculo="Generico";
        }
        
    }
    public Articulo(String calidad,String tipo,String especialidad,String tipoArticulo, String tipoVehiculo, String marca, double precio, int cantidad,String marcaVehiculo,long referencia ) {
        this.marcaVehiculo=marcaVehiculo;
    	this.calidad=calidad;
    	this.tipo=tipo;
    	this.tipoArticulo = tipoArticulo;
        this.especialidad = especialidad;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
        this.referencia=referencia;
        
        if(tipo.equals("taller")) {
        	InventarioArticulo.articulos.add(this);
        }
        else if(tipo.equals("repuesto")) {
        	InventarioArticulo.repuestos.add(this);
        }
        
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}
	public void setReferencia(long referencia) {
		this.referencia=referencia;
	}
	public long getReferencia() {
		return referencia;
	}
	public static Articulo getArticuloPorReferencia(long referencia){
		Articulo finder = null;
		for(Articulo articulo: InventarioArticulo.articulos) {
			if(articulo.getReferencia() == referencia) {
				finder = articulo;
				break;
			}
		}
		return finder;
	}

	public static Articulo getRepuestoPorReferencia(long referencia){
		Articulo finder = null;
		for(Articulo articulo: InventarioArticulo.repuestos) {
			if(articulo.getReferencia() == referencia) {
				finder = articulo;
				break;
			}
		}
		return finder;
	}
	
	
   
    
}


    