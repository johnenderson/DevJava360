package com.jes.aulas;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ao sistema de chamados, insira seu nome para iniciar:");
        String name = in.nextLine();
        System.out.println("Certo " + name.toUpperCase() + " vamos começar!");

        System.out.println("Selecione o tipo de chamado:" + "\n" + "1 - Segurança da informação" + "\n" + "2 - Infraestrutura, ou " + "\n" +  "3 - Sistemas");
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