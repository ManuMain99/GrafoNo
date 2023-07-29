package GrafoNo;

import java.util.Scanner;

public class MenuGrafo {
    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar vértice");
            System.out.println("2. Agregar arista");
            System.out.println("3. Borrar arista");
            System.out.println("4. Comprobar si dos vértices son adyacentes");
            System.out.println("5. Borrar vértice");
            System.out.println("6. Imprimir grafo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que se ingrese un número entero
            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Intente nuevamente.");
                System.out.print("Seleccione una opción: ");
                scanner.nextLine();
            }

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la etiqueta del vértice: ");
                    String etiquetaVertice = scanner.nextLine();
                    grafo.nuevoVertice(etiquetaVertice);
                    break;
                case 2:
                    System.out.print("Ingrese la etiqueta del primer vértice: ");
                    String etiquetaVertice1 = scanner.nextLine();
                    System.out.print("Ingrese la etiqueta del segundo vértice: ");
                    String etiquetaVertice2 = scanner.nextLine();
                    grafo.agregarArista(etiquetaVertice1, etiquetaVertice2);
                    break;
                case 3:
                    System.out.print("Ingrese la etiqueta del primer vértice: ");
                    String etiquetaVertice3 = scanner.nextLine();
                    System.out.print("Ingrese la etiqueta del segundo vértice: ");
                    String etiquetaVertice4 = scanner.nextLine();
                    grafo.borrarArista(etiquetaVertice3, etiquetaVertice4);
                    break;
                case 4:
                    System.out.print("Ingrese la etiqueta del primer vértice: ");
                    String etiquetaVertice5 = scanner.nextLine();
                    System.out.print("Ingrese la etiqueta del segundo vértice: ");
                    String etiquetaVertice6 = scanner.nextLine();
                    boolean sonAdyacentes = grafo.adyacente(etiquetaVertice5, etiquetaVertice6);
                    if (sonAdyacentes) {
                        System.out.println("Los vértices son adyacentes.");
                    } else {
                        System.out.println("Los vértices NO son adyacentes.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la etiqueta del vértice a borrar: ");
                    String etiquetaVertice7 = scanner.nextLine();
                    grafo.borrarVertice(etiquetaVertice7);
                    break;
                case 6:
                    System.out.println("\nGrafo:");
                    grafo.imprimirGrafo();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
