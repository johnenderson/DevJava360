package com.jes.aulas;

import java.util.ArrayList;
import java.util.List;

public class LocationType {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("1. Loja");
        lista.add("2. Fabrica");
        lista.add("3. Escritorio");

        for (String listaLocalizacao : lista) {
            System.out.println(listaLocalizacao);
        }

    }
}
