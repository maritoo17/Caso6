package MapaYAsociacion;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GestionDeRelaciones extends JFrame {
    private Map<Integer, String> numerosYLetras;
    private Map<Integer, String> numerosYTextos;
    private JTextArea textArea;

    public GestionDeRelaciones() {
        numerosYLetras = new HashMap<>();
        numerosYTextos = new HashMap<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        textArea = new JTextArea(10, 30);
        add(new JScrollPane(textArea));
    }

    public void agregarRelacionNumerosYLetras(int numero, String letra) {
        numerosYLetras.put(numero, letra);
        textArea.append("Número: " + numero + ", Letra: " + letra + "\n");
    }

    public void agregarRelacionNumerosYTextos(int numero, String texto) {
        numerosYTextos.put(numero, texto);
        textArea.append("Número: " + numero + ", Texto: " + texto + "\n");
    }

    public String obtenerLetraDeNumero(int numero) {
        return numerosYLetras.get(numero);
    }

    public String obtenerTextoDeNumero(int numero) {
        return numerosYTextos.get(numero);
    }

    public void mostrarEnVentana() {
        this.setVisible(true);
    }
}