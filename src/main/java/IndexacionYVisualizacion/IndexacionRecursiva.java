package IndexacionYVisualizacion;

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
}