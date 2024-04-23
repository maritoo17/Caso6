package AnalisisYOrganizacion;

import java.util.Comparator;
import java.util.TreeMap;

public class OrdenacionVentas {
    private TreeMap<Venta, String> ventas;

    public OrdenacionVentas() {
        this.ventas = new TreeMap<>(Comparator.comparing(Venta::getMonto));
    }

    public void agregarVenta(Venta venta) {
        ventas.put(venta, venta.getNombre());
    }

    public TreeMap<Venta, String> obtenerVentasOrdenadasPorMonto() {
        return ventas;
    }
}