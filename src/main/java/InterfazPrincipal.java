import DatosDinamicos.*;
import AnalisisYOrganizacion.*;
import MapaYAsociacion.*;
import IndexacionYVisualizacion.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfazPrincipal extends JFrame {
    public InterfazPrincipal() {
        setLayout(new FlowLayout());

        JButton boton1 = new JButton("Ejecutar Pareja");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pareja pareja = new Pareja();
                pareja.setVisible(true);
            }
        });

        JButton boton2 = new JButton("Ejecutar ParesEnteros");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParesEnteros paresEnteros = new ParesEnteros();
                String continuar;
                do {
                    String primerElementoStr = JOptionPane.showInputDialog("Ingrese el primer elemento del par:");
                    String segundoElementoStr = JOptionPane.showInputDialog("Ingrese el segundo elemento del par:");
                    int primerElemento = Integer.parseInt(primerElementoStr);
                    int segundoElemento = Integer.parseInt(segundoElementoStr);
                    paresEnteros.agregarPareja(primerElemento, segundoElemento);
                    continuar = JOptionPane.showInputDialog("¿Desea agregar otro par de enteros? (s/n):");
                } while (continuar.equalsIgnoreCase("s"));
                paresEnteros.mostrarEnVentana();
            }
        });

        JButton boton3 = new JButton("Ejecutar DatosReales");
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosReales datosReales = new DatosReales();
                String continuar;
                do {
                    String datoStr = JOptionPane.showInputDialog("Ingrese el dato real a agregar:");
                    double dato = Double.parseDouble(datoStr);
                    datosReales.agregarDato(dato);
                    continuar = JOptionPane.showInputDialog("¿Desea agregar otro dato real? (s/n):");
                } while (continuar.equalsIgnoreCase("s"));
                datosReales.mostrarEnVentana();
            }
        });

        JButton boton4 = new JButton("Ejecutar InterfazUsuario");
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazUsuario interfazUsuario = new InterfazUsuario();
                interfazUsuario.setVisible(true);
            }
        });

        JButton boton5 = new JButton("Ejecutar OrdenacionYBusqueda");
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenacionYBusqueda ordenacionYBusqueda = new OrdenacionYBusqueda();
                ordenacionYBusqueda.agregarVenta(new Venta());
                ordenacionYBusqueda.ordenarVentasPorMonto();
                ordenacionYBusqueda.mostrarEnVentana();
            }
        });

        JButton botonVenta = new JButton("Ejecutar Venta");
        botonVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Venta venta = new Venta();
                venta.setVisible(true);
            }
        });

        add(botonVenta);

        JButton boton6 = new JButton("Ejecutar GestionDeRelaciones");
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionDeRelaciones gestionDeRelaciones = new GestionDeRelaciones();
                gestionDeRelaciones.agregarRelacionNumerosYLetras(1, "Uno");
                gestionDeRelaciones.mostrarEnVentana();
            }
        });

        JButton boton7 = new JButton("Ejecutar IndexacionRecursiva");
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexacionRecursiva indexacionRecursiva = new IndexacionRecursiva();
                indexacionRecursiva.indexarDirectorio("/path/to/directory");
                indexacionRecursiva.mostrarEnVentana();
            }
        });

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        add(boton7);

        setSize(800, 600);
        getContentPane().setBackground(Color.WHITE);
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