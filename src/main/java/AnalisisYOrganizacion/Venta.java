package AnalisisYOrganizacion;

public class Venta implements Comparable<Venta> {
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

    @Override
    public int compareTo(Venta o) {
        return Double.compare(this.monto, o.monto);
    }
}