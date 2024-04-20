package MapaYAsociacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionDeRelaciones {
    private Map<Integer, String> numerosYLetras;
    private Map<Integer, String> numerosYTextos;

    public GestionDeRelaciones() {
        numerosYLetras = new HashMap<>();
        numerosYTextos = new HashMap<>();
    }

    public void agregarRelacionNumerosYLetras(int numero, String letra) {
        numerosYLetras.put(numero, letra);
    }

    public void agregarRelacionNumerosYTextos(int numero, String texto) {
        numerosYTextos.put(numero, texto);
    }

    public String obtenerLetraDeNumero(int numero) {
        return numerosYLetras.get(numero);
    }

    public String obtenerTextoDeNumero(int numero) {
        return numerosYTextos.get(numero);
    }

    public List<Integer> obtenerNumerosPorLetra(String letra) {
        List<Integer> numeros = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : numerosYLetras.entrySet()) {
            if (entry.getValue().equals(letra)) {
                numeros.add(entry.getKey());
            }
        }
        return numeros;
    }

    public List<Integer> obtenerNumerosPorTexto(String texto) {
        List<Integer> numeros = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : numerosYTextos.entrySet()) {
            if (entry.getValue().equals(texto)) {
                numeros.add(entry.getKey());
            }
        }
        return numeros;
    }
}