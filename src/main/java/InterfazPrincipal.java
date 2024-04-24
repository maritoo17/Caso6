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

        JPanel buttonPanel = new JPanel(new GridLayout(0, 3, 5, 5));
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(createButton("Ejecutar Pareja", e -> {
            Pareja pareja = new Pareja();
            pareja.setVisible(true);
        }));
        buttonPanel.add(createButton("Ejecutar ParesEnteros", e -> {
            ParesEnteros paresEnteros = new ParesEnteros();
            paresEnteros.setVisible(true);
        }));
        buttonPanel.add(createButton("Ejecutar DatosReales", e -> {
            DatosReales datosReales = new DatosReales();
            datosReales.setVisible(true);
        }));
        buttonPanel.add(createButton("Ejecutar InterfazUsuario", e -> {
            InterfazUsuario interfazUsuario = new InterfazUsuario();
            interfazUsuario.setVisible(true);
        }));
        buttonPanel.add(createButton("Ejecutar OrdenacionYBusqueda", e -> {
            OrdenacionYBusqueda ordenacionYBusqueda = new OrdenacionYBusqueda();
            ordenacionYBusqueda.mostrarEnVentana();
        }));
        buttonPanel.add(createButton("Ejecutar Venta", e -> {
            Venta venta = new Venta();
            venta.setVisible(true);
        }));
        buttonPanel.add(createButton("Ejecutar GestionDeRelaciones", e -> {
            GestionDeRelaciones gestionDeRelaciones = new GestionDeRelaciones();
            gestionDeRelaciones.agregarRelacionNumerosYLetras(1, "Uno");
            gestionDeRelaciones.agregarRelacionNumerosYTextos(2, "Dos");
            gestionDeRelaciones.mostrarEnVentana();
        }));
        buttonPanel.add(createButton("Ejecutar IndexacionRecursiva", e -> {
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
        }));

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

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazPrincipal().setVisible(true));
    }
}
