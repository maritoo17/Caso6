package DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class ParesEnteros {
    private List<Pareja<Integer, Integer>> lista;

    public ParesEnteros() {
        this.lista = new ArrayList<>();
    }

    public void agregarPareja(int primero, int segundo) {
        lista.add(new Pareja<>(primero, segundo));
    }

    public List<Pareja<Integer, Integer>> obtenerLista() {
        return lista;
    }
}
