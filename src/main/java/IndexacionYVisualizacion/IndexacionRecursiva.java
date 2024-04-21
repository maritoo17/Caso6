package IndexacionYVisualizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IndexacionRecursiva {
    private Map<String, String> indice;

    public IndexacionRecursiva() {
        this.indice = new HashMap<>();
    }

    public void indexarDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexarDirectorio(archivo.getPath());
                } else {
                    indice.put(archivo.getName(), archivo.getPath());
                }
            }
        }
    }

    public String obtenerRuta(String nombreArchivo) {
        return indice.get(nombreArchivo);
    }

    public void listarArchivosOrdenados() {
        indice.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("Nombre del archivo: " + entry.getKey() + ", Ruta completa: " + entry.getValue()));
    }

    public void mostrarEnVentana() {
        JFrame frame = new JFrame("IndexacionRecursiva");
        frame.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        indice.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> textArea.append("Nombre del archivo: " + entry.getKey() + ", Ruta completa: " + entry.getValue() + "\n"));
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

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