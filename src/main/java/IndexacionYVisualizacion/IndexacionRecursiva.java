package IndexacionYVisualizacion;

import java.io.File;
import java.util.*;

public class IndexacionRecursiva {
    private final Map<String, String> index = new TreeMap<>();

    public void indexar(File directorio) {
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            Arrays.sort(archivos, Comparator.comparing(File::getName));
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexar(archivo);
                } else {
                    index.put(archivo.getName(), archivo.getAbsolutePath());
                }
            }
        }
    }

    public String buscar(String nombreArchivo) {
        return index.get(nombreArchivo);
    }

    public Map<String, String> getIndex() {
        return index;
    }
}