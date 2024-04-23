package AnalisisYOrganizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        ventas.sort(Comparator.comparing(Venta::getCantidad));
    }

    public void ordenarVentasPorCategoria() {
        ventas.sort(Comparator.comparing(Venta::getCategoria));
    }

    public List<Venta> filtrarVentasPorMonto(double monto) {
        return ventas.stream()
                .filter(venta -> venta.getCantidad() >= monto)
                .collect(Collectors.toList());
    }

    public List<Venta> filtrarVentasPorCategoria(String categoria) {
        return ventas.stream()
                .filter(venta -> venta.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    }

    public void mostrarEnVentana() {
        JFrame frame = new JFrame("OrdenacionYBusqueda");
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(this.ventas.toString());
        frame.getContentPane().add(label, BorderLayout.CENTER);

        JButton backButton = new JButton("Atrás");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(backButton, BorderLayout.SOUTH);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}