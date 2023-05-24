package gestorAplicacion.personal;

import java.io.Serializable;


public interface Persona {
    String getNombre();
    long getCedula();
    long getTelefono();
    String getCorreo();
    String getDireccion();
    void setNombre(String nombre);
    void setCedula(long cedula);
    void setTelefono(long telefono);
    void setCorreo(String correo);
    void setDireccion(String direccion);
    public String info();
}


