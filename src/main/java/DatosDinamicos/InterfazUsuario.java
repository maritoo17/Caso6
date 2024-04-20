package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfazUsuario extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private JButton addButton;
    private JButton deleteButton;
    private List<Double> lista;

    public InterfazUsuario() {
        lista = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        addButton = new JButton("Agregar");
        deleteButton = new JButton("Eliminar");

        add(textField);
        add(addButton);
        add(deleteButton);
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
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Double dato : lista) {
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