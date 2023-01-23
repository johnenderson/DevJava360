package com.jes.aulas;

import java.util.HashMap;
import java.util.Map;

public class UrgencyType {
    public static Map<Integer, String> getUrgencyType() {

        Map<Integer,String> lista = new HashMap<>();
        lista.put(1, "Necessario ação imediata (Usar apenas na gravidade 1)");
        lista.put(2, "Atender o mais cedo possivel");
        lista.put(3, "Prazo padrão de atendimento");

        return lista;

    }

    public static void main(String[] args) {
        Map<Integer, String> urgencyType = getUrgencyType();
    }
}
