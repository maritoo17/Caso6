package IndexacionYVisualizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IndexacionRecursiva extends JFrame {
    private Map<String, String> indice;
    private JTextArea textArea;

    public IndexacionRecursiva() {
        this.indice = new HashMap<>();
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        textArea = new JTextArea(10, 30);
        JButton indexButton = new JButton("Iniciar Indexación");

        add(indexButton);
        add(new JScrollPane(textArea));

        indexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexarDirectorio("/path/to/directory");
                listarArchivosOrdenados();
            }
        });
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

    public void listarArchivosOrdenados() {
        Map<String, String> indiceOrdenado = new TreeMap<>(indice);
        for (Map.Entry<String, String> entrada : indiceOrdenado.entrySet()) {
            textArea.append("Nombre del archivo: " + entrada.getKey() + ", Ruta completa: " + entrada.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IndexacionRecursiva().setVisible(true);
            }
        });
    }
}