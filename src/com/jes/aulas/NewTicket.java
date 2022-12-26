package com.jes.aulas;

import java.util.Scanner;

public class NewTicket {
    public static void main(String[] args) {
        Ticket chamado = new Ticket();

    	Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ao sistema de chamados, insira seu nome para iniciar:");
        chamado.setIniciadorChamado(in.nextLine().toUpperCase());
        System.out.println("Certo " + chamado.getIniciadorChamado() + " vamos começar!");
        System.out.println("Você é o solicitante do chamado? (Digite 1 para 'SIM' ou 2 para 'NÃO'");
        int opcao = in.nextInt();

        switch (opcao) {
            case 1:
                chamado.setSolicitanteChamado(chamado.getIniciadorChamado());
                System.out.println("Ok, " + chamado.getIniciadorChamado() + "!");
                break;
            case 2:
                System.out.println("Digite o nome do solicitante: ");
                String solicitante = in.nextLine();
                chamado.setSolicitanteChamado(solicitante);
                System.out.println(chamado.getSolicitanteChamado());
                break;
            default:
                System.out.println("O número escolhido é inválido! Digite um número entre 1 e 2.");
        }

        System.out.println("Informe qual é o Titulo para este chamado:");
        String titulo = in.nextLine();
        chamado.setTituloChamado(titulo);

        System.out.println(chamado.getTipoChamado());
        int tipochamado = in.nextInt();

        switch(tipochamado) {
            case 1:
                System.out.println("Segurança da informação, selecionado!");
                break;
            case 2:
                System.out.println("Infraestrutura, selecionado!");
                break;
            case 3:
                System.out.println("Sistemas, selecionado!");
                break;
            default:
                System.out.println("O número escolhido é inválido! Digite um número entre 1 e 3.");
        }


        //E-mails adicionais a serem notificados, separados por ";". (Ex: e-mail1@teste.com; email2@teste.com)
        //Qual a sua dúvida ou problema? (Se for um problema, detalhe o máximo possível incluindo como anexo a tela do erro)

        System.out.println("------------------------------");
        System.out.println("INFORMAÇÕES DO CHAMADO");
        System.out.println("------------------------------");
        System.out.println("Nome Iniciador: " + chamado.getIniciadorChamado());
//        System.out.println("Nome Solicitante: " + chamado.getSolicitanteChamado());
        System.out.println("Titulo: " + chamado.getTituloChamado());
//        System.out.println("Tipo de Chamado: " + chamado.getTipoChamado());
//        System.out.println("Gravidade: " + chamado.getGravidadeChamado());
//        System.out.println("Urgência: " + chamado.getUrgenciaChamado());
//        System.out.println("Descrição breve do chamado: " + chamado.getDescricaoChamado());
//        System.out.println("Telefone do Solicitante: " + chamado.getTelefoneContato());
//        System.out.println("Area do Solicitante: " + chamado.getAreaIniciador());
//        System.out.println("Tipo de Localização do Solicitante: " + chamado.getTipoLocalizacao());
//        System.out.println("Localização do Solicitante: " + chamado.getLocalizacao());
//        System.out.println("E-mail do Solicitante: " + chamado.getEmail());
//        System.out.println("E-mails adicionais a serem notificados: " + chamado.getEmailsAdicionais());

        in.close();
    }
    
}
