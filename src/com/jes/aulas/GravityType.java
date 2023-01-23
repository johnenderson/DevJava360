package com.jes.aulas;

import java.util.HashMap;
import java.util.Map;

public class GravityType {
    public static Map<Integer, String> getGravityTypes() {

        Map<Integer, String> lista = new HashMap<>();
        lista.put(0, "Erro que impede a continuidade do projeto de implantação");
        lista.put(1, "Sistema Indisponivel");
        lista.put(2, "Erro critico para operação do sistema");
        lista.put(3, "Erro médio ou de menor impacto");
        lista.put(4, "Dúvidas e ou melhorias");

        return lista;

    }

    public static void main(String[] args) {
        Map<Integer, String> gravityTypes = getGravityTypes();

    }
}
