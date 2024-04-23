package DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Pareja <T, U> {
    private T primerElemento;
    private U segundoElemento;
    private static List<Pareja> parejas = new ArrayList<>();

    public Pareja(T primerElemento, U segundoElemento) {
        this.primerElemento = primerElemento;
        this.segundoElemento = segundoElemento;
        parejas.add(this);
    }

    public T getPrimerElemento() {
        return primerElemento;
    }

    public void setPrimerElemento(T primerElemento) {
        this.primerElemento = primerElemento;
    }

    public U getSegundoElemento() {
        return segundoElemento;
    }

    public void setSegundoElemento(U segundoElemento) {
        this.segundoElemento = segundoElemento;
    }

    @Override
    public String toString() {
        return "(" + primerElemento + ", " + segundoElemento + ")";
    }

    public void mostrarEnVentana() {
        JFrame frame = new JFrame("Pareja");
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(this.toString());
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

    public static List<Pareja> getParejas() {
        return parejas;
    }
}