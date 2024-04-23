import DatosDinamicos.*;
import AnalisisYOrganizacion.*;
import MapaYAsociacion.*;
import IndexacionYVisualizacion.*;

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
                Pareja pareja = new Pareja();
                pareja.setVisible(true);
            }
        });

        JButton boton2 = new JButton("Ejecutar ParesEnteros");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParesEnteros paresEnteros = new ParesEnteros();
                paresEnteros.setVisible(true);
            }
        });

        JButton boton3 = new JButton("Ejecutar DatosReales");
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosReales datosReales = new DatosReales();
                datosReales.setVisible(true);
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
                ordenacionYBusqueda.agregarVenta(new Venta("Venta 1", 100.0, "Categoria 1"));
                ordenacionYBusqueda.agregarVenta(new Venta("Venta 2", 200.0, "Categoria 2"));
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