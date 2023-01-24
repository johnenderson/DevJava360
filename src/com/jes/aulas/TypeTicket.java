package com.jes.aulas;

import java.util.HashMap;
import java.util.Map;

public class TypeTicket {
    private int tipoChamado;

    public static Map<Integer, String> getTypeTicket() {
        Map<Integer, String> lista = new HashMap<>();
        lista.put(1, "Segurança da informação");
        lista.put(2, "Infraestrutura");
        lista.put(3, "Sistemas");
        return lista;
    }

    public void setTipoChamado(int tipoChamado) {
        this.tipoChamado = tipoChamado;
    }
    public int getTipoChamado(){
        return tipoChamado;
    }

    public static void main(String[] args) {
        TypeTicket typeTicket = new TypeTicket();
        Map<Integer, String> typeTicketMap = getTypeTicket();
    }

}
