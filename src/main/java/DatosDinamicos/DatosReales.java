package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DatosReales extends JFrame {
    private List<Double> lista;
    private JTextField datoField;
    private JTextArea textArea;

    public DatosReales() {
        this.lista = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        datoField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        JButton addButton = new JButton("Agregar Dato");

        add(new JLabel("Dato:"));
        add(datoField);
        add(addButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double dato = Double.parseDouble(datoField.getText());
                lista.add(dato);
                updateTextArea();
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Double dato : lista) {
            textArea.append(dato + "\n");
        }
    }

    public void mostrarEnVentana() {
        this.setVisible(true);
    }

    public List<Double> obtenerLista() {
        return lista;
    }
}