package DatosDinamicos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ParesEnteros {
    private List<Pareja<Integer, Integer>> lista;

    public ParesEnteros() {
        this.lista = new ArrayList<>();
    }

    public void agregarPareja(int primero, int segundo) {
        lista.add(new Pareja<>(primero, segundo));
    }

    public List<Pareja<Integer, Integer>> obtenerLista() {
        return lista;
    }

    public void mostrarEnVentana() {
        JFrame frame = new JFrame("ParesEnteros");
        JLabel label = new JLabel(this.lista.toString());
        frame.getContentPane().add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}