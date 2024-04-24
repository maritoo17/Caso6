import DatosDinamicos.*;
import AnalisisYOrganizacion.*;
import MapaYAsociacion.*;
import IndexacionYVisualizacion.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

public class InterfazPrincipal extends JFrame {
    private final OrdenadorYListado ordenadorYListado = new OrdenadorYListado();

    public InterfazPrincipal() {
        setLayout(new FlowLayout());

        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/ruta/a/UAX.png"));
        JLabel labelFondo = new JLabel();
        labelFondo.setIcon(imagenFondo);
        add(labelFondo);
        labelFondo.setBounds(0, 0, imagenFondo.getIconWidth(), imagenFondo.getIconHeight());

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

        JButton botonGestionRelaciones = new JButton("Ejecutar GestionDeRelaciones");
        botonGestionRelaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionDeRelaciones gestionDeRelaciones = new GestionDeRelaciones();
                gestionDeRelaciones.agregarRelacionNumerosYLetras(1, "Uno");
                gestionDeRelaciones.agregarRelacionNumerosYTextos(2, "Dos");
                gestionDeRelaciones.mostrarEnVentana();
            }
        });

        add(botonGestionRelaciones);

        JButton boton7 = new JButton("Ejecutar IndexacionRecursiva");
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    IndexacionRecursiva indexacionRecursiva = new IndexacionRecursiva();
                    indexacionRecursiva.indexar(selectedDirectory);
                    Map<String, String> index = indexacionRecursiva.getIndex();
                    StringBuilder archivosIndexados = new StringBuilder("La indexación ha finalizado\n");
                    for (Map.Entry<String, String> entry : index.entrySet()) {
                        archivosIndexados.append("Archivo: ").append(entry.getKey()).append(", Ruta: ").append(entry.getValue()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, archivosIndexados.toString());
                }
            }
        });
        add(boton7);

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
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