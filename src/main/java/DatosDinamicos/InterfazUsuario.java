package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterfazUsuario extends JFrame {
    private JTextField textField;
    private JTextField filterField;
    private JTextArea textArea;
    private JButton addButton;
    private JButton deleteButton;
    private JButton sortButton;
    private JButton filterButton;
    private List<Double> lista;

    public InterfazUsuario() {
        lista = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        filterField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        addButton = new JButton("Agregar");
        deleteButton = new JButton("Eliminar");
        sortButton = new JButton("Ordenar");
        filterButton = new JButton("Filtrar");

        add(textField);
        add(addButton);
        add(deleteButton);
        add(sortButton);
        add(filterField);
        add(filterButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double dato = Double.parseDouble(textField.getText());
                lista.add(dato);
                updateTextArea();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double dato = Double.parseDouble(textField.getText());
                lista.remove(dato);
                updateTextArea();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(lista);
                updateTextArea();
            }
        });

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double filterValue = Double.parseDouble(filterField.getText());
                List<Double> filteredList = lista.stream()
                        .filter(dato -> dato >= filterValue)
                        .collect(Collectors.toList());
                updateTextArea(filteredList);
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Double dato : lista) {
            textArea.append(dato + "\n");
        }
    }

    private void updateTextArea(List<Double> list) {
        textArea.setText("");
        for (Double dato : list) {
            textArea.append(dato + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazUsuario().setVisible(true);
            }
        });
    }
}