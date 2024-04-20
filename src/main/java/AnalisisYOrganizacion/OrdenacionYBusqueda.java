package AnalisisYOrganizacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenacionYBusqueda {
    public static void main(String[] args) {
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta("Carlos", 200.0, "Electrónicos"));
        ventas.add(new Venta("Ana", 150.0, "Ropa"));
        ventas.add(new Venta("Luis", 300.0, "Electrónicos"));
        ventas.add(new Venta("Maria", 100.0, "Ropa"));

        ventas.sort(Comparator.comparing(Venta::getMonto));
        System.out.println("Ventas ordenadas por monto: " + ventas);

        ventas.sort(Comparator.comparing(Venta::getCategoria));
        System.out.println("Ventas ordenadas por categoría: " + ventas);
    }
}