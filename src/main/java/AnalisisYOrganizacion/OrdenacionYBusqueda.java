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
        JButton sortMontoButton = new JButton("Ordenar por Monto");
        JButton sortCategoriaButton = new JButton("Ordenar por Categoría");

        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Cantidad:"));
        add(cantidadField);
        add(new JLabel("Categoría:"));
        add(categoriaField);
        add(addButton);
        add(sortMontoButton);
        add(sortCategoriaButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double monto = Double.parseDouble(cantidadField.getText());
                String categoria = categoriaField.getText();
                Venta venta = new Venta(nombre, monto, categoria);
                ventas.add(venta);
                updateTextArea();
            }
        });

        sortMontoButton.addActionListener(new ActionListener() {
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