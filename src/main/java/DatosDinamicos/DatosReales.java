package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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