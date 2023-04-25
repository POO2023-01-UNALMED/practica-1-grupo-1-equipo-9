package personal;

public class Persona {
	String nombre;
	long cedula;
	long telefono;
	String correo;
	String direccion;

	public Persona(String nombre, long cedula, long telefono, String correo, String direccion) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}

	public Persona(String nombre, long cedula, long telefono, String correo) {
		this(nombre, cedula, telefono, correo, "Medellin");
	}

	public String getNombre() {
		return nombre;
	}

	public long getCedula() {
		return cedula;
	}

	public long getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
