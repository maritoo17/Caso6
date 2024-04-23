package AnalisisYOrganizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Venta extends JFrame {
    private String nombre;
    private double monto;
    private String categoria;
    private JTextField nombreField;
    private JTextField montoField;
    private JTextField categoriaField;
    private JTextArea textArea;
    private List<Venta> ventas;

    public Venta() {
        ventas = new ArrayList<>();
        createUI();
    }

    public Venta(String nombre, double monto, String categoria) {
        this.nombre = nombre;
        this.monto = monto;
        this.categoria = categoria;
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        nombreField = new JTextField(10);
        montoField = new JTextField(10);
        categoriaField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        JButton addButton = new JButton("Agregar Venta");

        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Monto:"));
        add(montoField);
        add(new JLabel("Categoría:"));
        add(categoriaField);
        add(addButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double monto = Double.parseDouble(montoField.getText());
                String categoria = categoriaField.getText();
                Venta venta = new Venta(nombre, monto, categoria);
                ventas.add(venta);
                updateTextArea();
            }
        });
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

    private void updateTextArea() {
        textArea.setText("");
        for (Venta venta : ventas) {
            textArea.append(venta.getNombre() + ", " + venta.getMonto() + ", " + venta.getCategoria() + "\n");
        }
    }
}