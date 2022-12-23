package com.jes.aulas;

import java.util.Scanner;

public class NewTicket {
    public static void main(String[] args) {
        Ticket chamado = new Ticket();

    	Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ao sistema de chamados, insira seu nome para iniciar:");
        String name = in.nextLine();
        System.out.println("Certo " + name.toUpperCase() + " vamos começar!");

        System.out.println(chamado.getTipoChamado());
        int type = in.nextInt();

        switch(type) {
            case 1:
                System.out.println("Segurança da informação, selecionado.");
                break;
            case 2:
                System.out.println("Infraestrutura, selecionado.");
                break;
            case 3:
                System.out.println("Sistemas, selecionado.");
                break;
        }

        in.close();
    }
    
}
