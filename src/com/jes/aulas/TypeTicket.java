package com.jes.aulas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeTicket {

    public static Map<Integer, String> getTypeTicket() {

        Map<Integer, String> lista = new HashMap<>();
        lista.put(1, "Segurança da informação");
        lista.put(2, "Infraestrutura");
        lista.put(3, "Sistemas");

        return lista;
    }

    public static void main(String[] args) {
        Map<Integer, String> typeTicket = getTypeTicket();
    }

}
