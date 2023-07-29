package GrafoNo;

import java.util.ArrayList;
import java.util.List;

public class GrafoNoDirigido {
    private List<Vertice> vertices;

    public GrafoNoDirigido() {
        this.vertices = new ArrayList<>();
    }

    public void nuevoVertice(String etiqueta) {
        // Agrega un nuevo vértice al grafo si no existe previamente
        if (!existeVertice(etiqueta)) {
            vertices.add(new Vertice(etiqueta));
        }
    }

    public void agregarArista(String etiquetaVertice1, String etiquetaVertice2) {
        // Crea una arista entre dos vértices existentes en el grafo
        Vertice vertice1 = encontrarVertice(etiquetaVertice1);
        Vertice vertice2 = encontrarVertice(etiquetaVertice2);

        if (vertice1 != null && vertice2 != null) {
            vertice1.adyacentes.add(vertice2);
            vertice2.adyacentes.add(vertice1);
        }
    }

    public void borrarArista(String etiquetaVertice1, String etiquetaVertice2) {
        // Borra una arista entre dos vértices existentes en el grafo
        Vertice vertice1 = encontrarVertice(etiquetaVertice1);
        Vertice vertice2 = encontrarVertice(etiquetaVertice2);

        if (vertice1 != null && vertice2 != null) {
            vertice1.adyacentes.remove(vertice2);
            vertice2.adyacentes.remove(vertice1);
        }
    }

    public boolean adyacente(String etiquetaVertice1, String etiquetaVertice2) {
        // Comprueba si dos vértices son adyacentes
        Vertice vertice1 = encontrarVertice(etiquetaVertice1);
        Vertice vertice2 = encontrarVertice(etiquetaVertice2);

        return vertice1 != null && vertice2 != null && vertice1.adyacentes.contains(vertice2);
    }

    public void borrarVertice(String etiqueta) {
        // Borra un vértice y sus aristas adyacentes del grafo
        Vertice vertice = encontrarVertice(etiqueta);
        if (vertice != null) {
            vertices.remove(vertice);
            for (Vertice v : vertices) {
                v.adyacentes.remove(vertice);
            }
        }
    }

    public void imprimirGrafo() {
        for (Vertice vertice : vertices) {
            System.out.print(vertice.etiqueta + " -> ");
            if (!vertice.adyacentes.isEmpty()) {
                for (Vertice adyacente : vertice.adyacentes) {
                    System.out.print(adyacente.etiqueta + ", ");
                }
                System.out.print("\b\b\n");
            } else {
                System.out.println("Ningún vértice adyacente");
            }
        }
    }

    private boolean existeVertice(String etiqueta) {
        // Comprueba si un vértice existe en el grafo
        for (Vertice v : vertices) {
            if (v.etiqueta.equals(etiqueta)) {
                return true;
            }
        }
        return false;
    }

    private Vertice encontrarVertice(String etiqueta) {
        // Busca un vértice por su etiqueta en el grafo
        for (Vertice v : vertices) {
            if (v.etiqueta.equals(etiqueta)) {
                return v;
            }
        }
        return null;
    }
}
