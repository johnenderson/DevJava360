package com.jes.aulas;

import java.util.ArrayList;
import java.util.List;

public class GravityType {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("0. Erro que impede a continuidade do projeto de implantação");
        lista.add("1. Sistema Indisponivel");
        lista.add("2. Erro critico para operação do sistema");
        lista.add("3. Erro médio ou de menor impacto");
        lista.add("4. Dúvidas e ou melhorias");

        for (String listagravidade : lista) {
            System.out.println(listagravidade);

        }

    }

}
