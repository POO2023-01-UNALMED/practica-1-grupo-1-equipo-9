package CapaLogica;

import java.util.ArrayList;

public class InventarioAuto {
    static ArrayList<Auto> autos= new ArrayList<Auto>();
    
    public void agregarAuto(Auto auto) {
        autos.add(auto);
    }

    public void eliminarAuto(Auto auto) {
        autos.remove(auto);
    }
    public static ArrayList<Auto> getAutos() {
        return autos;
    }

    public static void setAutos(ArrayList<Auto> autos) {
        InventarioAuto.autos = autos;
    }
    
    public static String autosDisponibles() {
        String resultado = "Autos Disponibles:\n";
        for (Auto auto : getAutosDisponibles()) {
            resultado += auto.getMarca() + " " + auto.getPrecio() + " " + auto.getColor() + "\n";
        }
        return resultado;
    }
    
    public static ArrayList<Auto> getAutosDisponibles() {
        ArrayList<Auto> disponibles = new ArrayList<Auto>();
        for (Auto auto : autos) {
            if (auto.isDisponible()) {
                disponibles.add(auto);
            }
        }
        return disponibles;
}
}   
