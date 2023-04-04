package CapaLogica;
/*Clase auto*/
public class Auto {
	private String marca;
	private int precio;
	private int cilindraje;
	private String color;
	private boolean fullEquipo;
	private boolean disponible;

	public Auto(String marca, int precio, int cilindraje, String color, boolean fullEquipo, boolean disponible) {
		this.marca = marca;
		this.precio = precio;
		this.cilindraje = cilindraje;
		this.color = color;
		this.fullEquipo = fullEquipo;
		this.disponible = disponible;
		InventarioAuto.autos.add(this);
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
}
