package GrafoNo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    String etiqueta;
    List<Vertice> adyacentes;

    public Vertice(String etiqueta) {
        this.etiqueta = etiqueta;
        this.adyacentes = new ArrayList<>();
    }
}