package com.jes.aulas;

import java.util.HashMap;
import java.util.Map;

public class LocationType {

    public static Map<Integer, String> getLocationType() {

        Map<Integer, String> lista = new HashMap<>();
        lista.put(1, "Loja");
        lista.put(2, "Fabrica");
        lista.put(3, "Escritorio");

        return lista;
    }

    public static void main(String[] args) {
        Map<Integer, String> locationType = getLocationType();
    }
}
