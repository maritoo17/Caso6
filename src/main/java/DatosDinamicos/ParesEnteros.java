package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(this.lista.toString());
        frame.getContentPane().add(label, BorderLayout.CENTER);

        JButton backButton = new JButton("Atrás");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(backButton, BorderLayout.SOUTH);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}