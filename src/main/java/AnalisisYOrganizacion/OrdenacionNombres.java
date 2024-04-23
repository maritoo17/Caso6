package AnalisisYOrganizacion;

import java.util.TreeSet;

public class OrdenacionNombres {
    private TreeSet<String> nombres;

    public OrdenacionNombres() {
        this.nombres = new TreeSet<>();
    }

    public void agregarNombre(String nombre) {
        nombres.add(nombre);
    }

    public TreeSet<String> obtenerNombresOrdenados() {
        return nombres;
    }
}
