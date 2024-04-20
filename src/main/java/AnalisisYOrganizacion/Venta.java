package AnalisisYOrganizacion;

public class Venta {
    private String nombre;
    private double monto;
    private String categoria;

    public Venta(String nombre, double monto, String categoria) {
        this.nombre = nombre;
        this.monto = monto;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }

    public String getCategoria() {
        return categoria;
    }
}