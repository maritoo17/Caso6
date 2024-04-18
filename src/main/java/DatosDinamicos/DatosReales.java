package DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class DatosReales {
    private List<Double> lista;

    public DatosReales() {
        this.lista = new ArrayList<>();
    }

    public void agregarDato(double dato) {
        lista.add(dato);
    }

    public List<Double> obtenerLista() {
        return lista;
    }
}
