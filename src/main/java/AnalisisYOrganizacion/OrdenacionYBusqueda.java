package AnalisisYOrganizacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacionYBusqueda {
    private List<Venta> ventas;

    public OrdenacionYBusqueda() {
        this.ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> obtenerVentas() {
        return ventas;
    }

    public void ordenarVentasPorMonto() {
        ventas.sort(Comparator.comparing(Venta::getMonto));
    }

    public void ordenarVentasPorCategoria() {
        ventas.sort(Comparator.comparing(Venta::getCategoria));
    }

    public List<Venta> filtrarVentasPorMonto(double monto) {
        return ventas.stream()
                .filter(venta -> venta.getMonto() >= monto)
                .collect(Collectors.toList());
    }

    public List<Venta> filtrarVentasPorCategoria(String categoria) {
        return ventas.stream()
                .filter(venta -> venta.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        OrdenacionYBusqueda ordenacionYBusqueda = new OrdenacionYBusqueda();
        ordenacionYBusqueda.agregarVenta(new Venta("Carlos", 200.0, "Electrónicos"));
        ordenacionYBusqueda.agregarVenta(new Venta("Ana", 150.0, "Ropa"));
        ordenacionYBusqueda.agregarVenta(new Venta("Luis", 300.0, "Electrónicos"));
        ordenacionYBusqueda.agregarVenta(new Venta("Maria", 100.0, "Ropa"));

        ordenacionYBusqueda.ordenarVentasPorMonto();
        System.out.println("Ventas ordenadas por monto: " + ordenacionYBusqueda.obtenerVentas());

        ordenacionYBusqueda.ordenarVentasPorCategoria();
        System.out.println("Ventas ordenadas por categoría: " + ordenacionYBusqueda.obtenerVentas());

        List<Venta> ventasFiltradasPorMonto = ordenacionYBusqueda.filtrarVentasPorMonto(200.0);
        System.out.println("Ventas filtradas por monto (>= 200.0): " + ventasFiltradasPorMonto);

        List<Venta> ventasFiltradasPorCategoria = ordenacionYBusqueda.filtrarVentasPorCategoria("Ropa");
        System.out.println("Ventas filtradas por categoría (Ropa): " + ventasFiltradasPorCategoria);
    }
}