package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Pareja <T, U> extends JFrame {
    private T primerElemento;
    private U segundoElemento;
    private static List<Pareja> parejas = new ArrayList<>();
    private JTextField numeroField;
    private JTextField numeroLetrasField;
    private JTextArea textArea;

    public Pareja() {
        parejas = new ArrayList<>();
        createUI();
    }

    public Pareja(T primerElemento, U segundoElemento) {
        this.primerElemento = primerElemento;
        this.segundoElemento = segundoElemento;
        parejas.add(this);
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        numeroField = new JTextField(10);
        numeroLetrasField = new JTextField(10);
        textArea = new JTextArea(10, 30);
        JButton addButton = new JButton("Agregar Pareja");

        add(new JLabel("Número:"));
        add(numeroField);
        add(new JLabel("Número en letras:"));
        add(numeroLetrasField);
        add(addButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numero = Integer.parseInt(numeroField.getText());
                String numeroLetras = numeroLetrasField.getText();
                Pareja<Integer, String> pareja = new Pareja<>(numero, numeroLetras);
                updateTextArea();
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Pareja pareja : parejas) {
            textArea.append(pareja.getPrimerElemento() + ", " + pareja.getSegundoElemento() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pareja().setVisible(true);
            }
        });
    }

    public T getPrimerElemento() {
        return primerElemento;
    }

    public U getSegundoElemento() {
        return segundoElemento;
    }

    public static List<Pareja> getParejas() {
        return parejas;
    }
}