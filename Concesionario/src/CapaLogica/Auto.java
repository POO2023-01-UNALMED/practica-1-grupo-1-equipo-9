package CapaLogica;

public class Auto {
	private String modelo;
	private String marca;
	private int precio;
	private int cilindraje;
	private String color;
	private boolean fullEquipo;
	private boolean disponible;
	private Cliente dueno;

	public Auto(String modelo, String marca, int precio, int cilindraje, String color, boolean fullEquipo, boolean disponible) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.cilindraje = cilindraje;
		this.color = color;
		this.fullEquipo = fullEquipo;
		this.disponible = disponible;
		InventarioAuto.autos.add(this);
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getMarca() {
		return marca;
	}

	public int getPrecio() {
		return precio;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public String getColor() {
		return color;
	}

	public boolean isFullEquipo() {
		return fullEquipo;
	}
	
	public Cliente getDueno() {
		return dueno;
	}
	
	public void setDueno(Cliente dueno) {
		this.dueno = dueno;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setFullEquipo(boolean fullEquipo) {
		this.fullEquipo = fullEquipo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
	    String fullEquipoStr = fullEquipo ? "Fullequipo" : "No Fullequipo";
	    return String.format("Datos del Carro: Modelo %s, Marca %s, Precio %d, Color %s, %s",
	            modelo, marca, precio, color, fullEquipoStr);
	}
}


