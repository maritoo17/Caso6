import DatosDinamicos.*;
import AnalisisYOrganizacion.*;
import MapaYAsociacion.*;
import IndexacionYVisualizacion.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ejecutar Pareja");
            System.out.println("2. Ejecutar ParesEnteros");
            System.out.println("3. Ejecutar DatosReales");
            System.out.println("4. Ejecutar InterfazUsuario");
            System.out.println("5. Ejecutar OrdenacionYBusqueda");
            System.out.println("6. Ejecutar GestionDeRelaciones");
            System.out.println("7. Ejecutar IndexacionRecursiva");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Pareja<Integer, String> pareja = new Pareja<>(1, "Uno");
                    System.out.println(pareja.toString());
                    break;
                case 2:
                    ParesEnteros paresEnteros = new ParesEnteros();
                    paresEnteros.agregarPareja(1, 2);
                    System.out.println(paresEnteros.obtenerLista());
                    break;
                case 3:
                    DatosReales datosReales = new DatosReales();
                    datosReales.agregarDato(1.23);
                    System.out.println(datosReales.obtenerLista());
                    break;
                case 4:
                    InterfazUsuario interfazUsuario = new InterfazUsuario();
                    interfazUsuario.setVisible(true);
                    break;
                case 5:
                    OrdenacionYBusqueda ordenacionYBusqueda = new OrdenacionYBusqueda();
                    ordenacionYBusqueda.agregarVenta(new Venta("Carlos", 200.0, "Electrónicos"));
                    ordenacionYBusqueda.ordenarVentasPorMonto();
                    System.out.println(ordenacionYBusqueda.obtenerVentas());
                    break;
                case 6:
                    GestionDeRelaciones gestionDeRelaciones = new GestionDeRelaciones();
                    gestionDeRelaciones.agregarRelacionNumerosYLetras(1, "Uno");
                    System.out.println(gestionDeRelaciones.obtenerLetraDeNumero(1));
                    break;
                case 7:
                    IndexacionRecursiva indexacionRecursiva = new IndexacionRecursiva();
                    indexacionRecursiva.indexarDirectorio("/path/to/directory");
                    indexacionRecursiva.listarArchivosOrdenados();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}