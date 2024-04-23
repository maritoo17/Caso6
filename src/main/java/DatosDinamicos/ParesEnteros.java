package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ParesEnteros extends JFrame {
    private List<Pareja<Integer, Integer>> lista;
    private JTextField primerNumeroField;
    private JTextField segundoNumeroField;
    private JTextArea textArea;

    public ParesEnteros() {
        this.lista = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        primerNumeroField = new JTextField(10);
        segundoNumeroField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        JButton addButton = new JButton("Agregar Par");

        add(new JLabel("Primer número:"));
        add(primerNumeroField);
        add(new JLabel("Segundo número:"));
        add(segundoNumeroField);
        add(addButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer primerNumero = Integer.parseInt(primerNumeroField.getText());
                Integer segundoNumero = Integer.parseInt(segundoNumeroField.getText());
                Pareja<Integer, Integer> pareja = new Pareja<>(primerNumero, segundoNumero);
                lista.add(pareja);
                updateTextArea();
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Pareja<Integer, Integer> pareja : lista) {
            textArea.append(pareja.getPrimerElemento() + ", " + pareja.getSegundoElemento() + "\n");
        }
    }

    public void mostrarEnVentana() {
        this.setVisible(true);
    }

    public List<Pareja<Integer, Integer>> obtenerLista() {
        return lista;
    }
}