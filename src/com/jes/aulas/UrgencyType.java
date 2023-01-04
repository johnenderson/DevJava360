package com.jes.aulas;

import java.util.ArrayList;
import java.util.List;

public class UrgencyType {
    public static void UrgencyType(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("1. Necessario ação imediata (Usar apenas na gravidade 1)");
        lista.add("2. Atender o mais cedo possivel");
        lista.add("3. Prazo padrão de atendimento");

        for (String listaurgencia : lista) {
            System.out.println(listaurgencia);
        }

    }
}
