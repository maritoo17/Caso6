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

    public InterfazPrincipal() {
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //

        JButton boton1 = new JButton("Ejecutar Pareja");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pareja pareja = new Pareja();
                pareja.setVisible(true);
            }
        });
        buttonPanel.add(boton1);

        JButton boton2 = new JButton("Ejecutar ParesEnteros");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParesEnteros paresEnteros = new ParesEnteros();
                paresEnteros.setVisible(true);
            }
        });
        buttonPanel.add(boton2);

        JButton boton3 = new JButton("Ejecutar DatosReales");
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosReales datosReales = new DatosReales();
                datosReales.setVisible(true);
            }
        });
        buttonPanel.add(boton3);

        JButton boton4 = new JButton("Ejecutar InterfazUsuario");
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazUsuario interfazUsuario = new InterfazUsuario();
                interfazUsuario.setVisible(true);
            }
        });
        buttonPanel.add(boton4);

        JButton boton5 = new JButton("Ejecutar OrdenacionYBusqueda");
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenacionYBusqueda ordenacionYBusqueda = new OrdenacionYBusqueda();
                ordenacionYBusqueda.mostrarEnVentana();
            }
        });
        buttonPanel.add(boton5);

        JButton botonVenta = new JButton("Ejecutar Venta");
        botonVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Venta venta = new Venta();
                venta.setVisible(true);
            }
        });
        buttonPanel.add(botonVenta);

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
        buttonPanel.add(botonGestionRelaciones);

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
        buttonPanel.add(boton7);

        add(buttonPanel, BorderLayout.NORTH);

        ImageIcon icono1 = new ImageIcon(getClass().getResource("/uax.png"));
        if (icono1.getIconWidth() == -1) {
            System.out.println("No se pudo cargar la imagen. Verifique la ruta y asegúrese que está en /resources.");
        } else {
            JLabel labelImagen = new JLabel(icono1);
            add(labelImagen, BorderLayout.CENTER);
        }

        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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
