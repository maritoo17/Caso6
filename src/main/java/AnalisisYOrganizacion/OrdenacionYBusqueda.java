package AnalisisYOrganizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacionYBusqueda extends JFrame {
    private List<Venta> ventas;
    private JTextField nombreField;
    private JTextField cantidadField;
    private JTextField categoriaField;
    private JTextArea textArea;

    public OrdenacionYBusqueda() {
        this.ventas = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        nombreField = new JTextField(10);
        cantidadField = new JTextField(10);
        categoriaField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        JButton addButton = new JButton("Agregar Venta");
        JButton sortNombreButton = new JButton("Ordenar por Nombre");
        JButton sortCantidadButton = new JButton("Ordenar por Cantidad");
        JButton sortCategoriaButton = new JButton("Ordenar por Categoría");

        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Cantidad:"));
        add(cantidadField);
        add(new JLabel("Categoría:"));
        add(categoriaField);
        add(addButton);
        add(sortNombreButton);
        add(sortCantidadButton);
        add(sortCategoriaButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double cantidad = Double.parseDouble(cantidadField.getText());
                String categoria = categoriaField.getText();
                Venta venta = new Venta(nombre, cantidad, categoria);
                ventas.add(venta);
                updateTextArea();
            }
        });

        sortNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarVentasPorNombre();
                updateTextArea();
            }
        });

        sortCantidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarVentasPorCantidad();
                updateTextArea();
            }
        });

        sortCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarVentasPorCategoria();
                updateTextArea();
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Venta venta : ventas) {
            textArea.append("Nombre: " + venta.getNombre() + ", Cantidad: " + venta.getCantidad() + ", Categoría: " + venta.getCategoria() + "\n");
        }
    }

    public void ordenarVentasPorNombre() {
        ventas.sort(Comparator.comparing(Venta::getNombre));
    }

    public void ordenarVentasPorCantidad() {
        ventas.sort(Comparator.comparing(Venta::getCantidad));
    }

    public void ordenarVentasPorCategoria() {
        ventas.sort(Comparator.comparing(Venta::getCategoria));
    }

    public void mostrarEnVentana() {
        this.setVisible(true);
    }
}