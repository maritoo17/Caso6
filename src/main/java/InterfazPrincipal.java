import DatosDinamicos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {
    public InterfazPrincipal() {
        setLayout(new FlowLayout());

        JButton boton1 = new JButton("Ejecutar Pareja");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pareja<Integer, String> pareja = new Pareja<>(1, "Uno");
                pareja.mostrarEnVentana();
            }
        });

        JButton boton2 = new JButton("Ejecutar ParesEnteros");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParesEnteros paresEnteros = new ParesEnteros();
                paresEnteros.agregarPareja(1, 2);
                paresEnteros.mostrarEnVentana();
            }
        });

        // Agrega botones similares para las otras opciones...

        add(boton1);
        add(boton2);
        // Agrega los otros botones al panel...

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }
}