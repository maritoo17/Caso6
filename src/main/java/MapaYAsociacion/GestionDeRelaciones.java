package MapaYAsociacion;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GestionDeRelaciones extends JFrame {
    private Map<Integer, String> numerosYLetras;
    private Map<Integer, String> numerosYTextos;
    private JTextArea textArea;
    private JTextField numeroField;
    private JTextField textoField;

    public GestionDeRelaciones() {
        numerosYLetras = new HashMap<>();
        numerosYTextos = new HashMap<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        numeroField = new JTextField(10);
        textoField = new JTextField(10);
        JButton addButton = new JButton("Agregar Relación");
        textArea = new JTextArea(10, 30);

        add(new JLabel("Número:"));
        add(numeroField);
        add(new JLabel("Texto:"));
        add(textoField);
        add(addButton);
        add(new JScrollPane(textArea));

        addButton.addActionListener(e -> {
            int numero = Integer.parseInt(numeroField.getText());
            String texto = textoField.getText();
            agregarRelacionNumerosYTextos(numero, texto);
        });
    }

    public void agregarRelacionNumerosYTextos(int numero, String texto) {
        numerosYTextos.put(numero, texto);
        textArea.append("Número: " + numero + ", Texto: " + texto + "\n");
    }

    public String obtenerTextoDeNumero(int numero) {
        return numerosYTextos.get(numero);
    }

    public void mostrarEnVentana() {
        this.setVisible(true);
    }
}