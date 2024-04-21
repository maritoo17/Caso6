package DatosDinamicos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DatosReales {
    private List<Double> lista;

    public DatosReales() {
        this.lista = new ArrayList<>();
    }

    public void agregarDato(double dato) {
        lista.add(dato);
    }

    public List<Double> obtenerLista() {
        return lista;
    }

    public void mostrarEnVentana() {
        JFrame frame = new JFrame("DatosReales");
        JLabel label = new JLabel(this.lista.toString());
        frame.getContentPane().add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}