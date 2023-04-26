package gestorAplicacion.activos;

import java.io.Serializable;
import java.util.Comparator;

import gestorAplicacion.personal.*;

public class Auto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Articulo llantas;
	private Articulo suspension;
	private Articulo sonido;
	private Articulo escape;
	private String modelo;
	private String marca;
	private long precio;
	private int cilindraje;
	private String color;
	private boolean fullEquipo;
	private boolean disponible;
	private Cliente dueno;

	public Auto(String modelo, String marca, int precio, int cilindraje, String color, boolean fullEquipo, boolean disponible,Articulo llantas,Articulo suspension,Articulo sonido, Articulo escape) {
		this.llantas=llantas;
		this.suspension=suspension;
		this.sonido=sonido;
		this.escape=escape;
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

	public long getPrecio() {
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

	public void setPrecio(long precio) {
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

	public String info() {
	    String fullEquipoStr = fullEquipo ? "Fullequipo" : "No Fullequipo";
	    return String.format("Datos del Carro: Modelo %s, Marca %s, Precio %d, Color %s, %s",
	            modelo, marca, precio, color, fullEquipoStr);
	}

	public Articulo getLlantas() {
		return llantas;
	}

	public void setLlantas(Articulo llantas) {
		this.llantas = llantas;
	}

	public Articulo getSuspension() {
		return suspension;
	}

	public void setSuspension(Articulo suspension) {
		this.suspension = suspension;
	}

	public Articulo getSonido() {
		return sonido;
	}

	public void setSonido(Articulo sonido) {
		this.sonido = sonido;
	}

	public Articulo getEscape() {
		return escape;
	}

	public void setEscape(Articulo escape) {
		this.escape = escape;
	}
}

class Sortbyroll implements Comparator<Auto>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Auto a, Auto b)
    {
        return (int) (b.getPrecio() - a.getPrecio());
    }
}
