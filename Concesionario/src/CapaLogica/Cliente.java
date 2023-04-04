package CapaLogica;

public class Cliente extends Persona {
    String modeloInteres;
    int presupuesto;

    public Cliente(String nombre, long cedula, long telefono, String correo, String direccion, String modeloInteres, int presupuesto) {
        super(nombre, cedula, telefono, correo, direccion);
        this.modeloInteres = modeloInteres;
        this.presupuesto = presupuesto;
    }

    public Cliente(String nombre, long cedula, long telefono, String correo, String modeloInteres, int presupuesto) {
        super(nombre, cedula, telefono, correo);
        this.modeloInteres = modeloInteres;
        this.presupuesto = presupuesto;
    }

    public String getModeloInteres() {
        return modeloInteres;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setModeloInteres(String modeloInteres) {
        this.modeloInteres = modeloInteres;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
}
