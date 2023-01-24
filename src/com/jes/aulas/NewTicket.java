package com.jes.aulas;

import java.util.Map;
import java.util.Scanner;

public class NewTicket {

    public static void main(String[] args) {

        Ticket chamado = new Ticket();

        int tipoChamado;
        int opcao;
        int opcaoEmails;
        int tipoLocalizacao;
        boolean errorSolicitante = true;
        boolean errorTipoChamado = true;
        boolean errorEmailsAdicionais = true;
        boolean errorTipoLocalizacao = true;

    	Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ao sistema de chamados, insira seu nome para iniciar:");
        chamado.setIniciadorChamado(in.nextLine().toUpperCase());
        System.out.println("Certo " + chamado.getIniciadorChamado() + " vamos começar!");
        System.out.println("Você é o solicitante do chamado? (Digite 1 para 'SIM' ou 2 para 'NÃO'");

        while (errorSolicitante) {
            try {
                opcao = Integer.parseInt(in.nextLine());
                switch (opcao) {
                    case 1:
                        chamado.setSolicitanteChamado(chamado.getIniciadorChamado());
                        System.out.println("Ok, " + chamado.getIniciadorChamado() + "!");
                        errorSolicitante = false;
                        break;
                    case 2:
                        System.out.println("Digite o nome do solicitante: ");
                        chamado.setSolicitanteChamado(in.nextLine().toUpperCase());
                        System.out.println("OK, " + chamado.getSolicitanteChamado()+"!");
                        errorSolicitante = false;
                        break;
                    default:
                        System.out.println("O número escolhido é inválido! Digite um número entre 1 e 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
            }
        }

        System.out.println("Informar Telefone ou Ramal para contato:");
        chamado.setTelefoneContato(in.nextLine());
        //Incluir registro no campo: ;

        System.out.println("Informe qual é o Tipo de Localização: Tipo de Localização (1. Loja, 2. Fabrica ou 3. Escritório)");
        while (errorTipoLocalizacao) {
            try {
                tipoLocalizacao = Integer.parseInt(in.nextLine());
                switch (tipoLocalizacao) {
                    case 1:
                        System.out.println("Loja, selecionado!");
                        errorTipoLocalizacao = false;
                        break;
                    case 2:
                        System.out.println("Fabrica, selecionado!");
                        errorTipoLocalizacao = false;
                        break;
                    case 3:
                        System.out.println("Escritório, selecionado!");
                        errorTipoLocalizacao = false;
                        break;
                    default:
                        System.out.println("O número escolhido é inválido! Digite um número entre 1 e 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }
        System.out.println("Informar nome da Area do Solicitante:");
        chamado.setAreaIniciador(in.nextLine());
        System.out.println("Digite o e-mail do Solicitante do chamado:");
        chamado.setEmail(in.nextLine().toLowerCase());
        System.out.println("Deseja informar mais E-mails? Digite '1' para 'SIM' e '2' para 'NÃO'");
        while (errorEmailsAdicionais) {
            try {
                opcaoEmails = Integer.parseInt(in.nextLine());
                switch (opcaoEmails) {
                    case 1:
                        System.out.println("Informar e-mails adicionais a serem notificados, separados por ';'. (Ex: e-mail1@teste.com; email2@teste.com)");
                        chamado.setSolicitanteChamado(in.nextLine().toLowerCase());
                        System.out.println("E-mails informados: " + chamado.getEmailsAdicionais());
                        errorEmailsAdicionais = false;
                        break;
                    case 2:
                        System.out.println("Ok! Não foram informados e-mails adicionais");
                        errorEmailsAdicionais = false;
                        break;
                    default:
                        System.out.println("O número escolhido é inválido! Digite um número entre 1 e 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
            }
        }

        System.out.println("Informe qual é o Titulo para este chamado:");
        chamado.setTituloChamado(in.nextLine());

        Map<Integer, String> typeTicket = TypeTicket.getTypeTicket();
        while (errorTipoChamado) {
            try {
                tipoChamado = Integer.parseInt(in.nextLine());
                if (typeTicket.containsKey(tipoChamado)) {
                    System.out.println(typeTicket.get(tipoChamado) + ", selecionado!");
                    errorTipoChamado = false;
                } else {
                    System.out.println("O número escolhido é inválido! Digite um número entre 1 e 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        //Informar gravidade
        //Informar urgencia


        System.out.println("Qual a sua dúvida ou problema? (Se for um problema, detalhe o máximo possível incluindo como anexo a tela do erro)");
        chamado.setDescricaoChamado(in.nextLine());


        System.out.println("------------------------------");
        System.out.println("INFORMAÇÕES DO CHAMADO");
        System.out.println("------------------------------");
        System.out.println("Titulo: " + chamado.getTituloChamado());
        System.out.println("Nome Iniciador: " + chamado.getIniciadorChamado());
        System.out.println("Nome Solicitante: " + chamado.getSolicitanteChamado());
        System.out.println("E-mail do Solicitante: " + chamado.getEmail());
        System.out.println("E-mails adicionais a serem notificados: " + chamado.getEmailsAdicionais());
        System.out.println("Telefone do Solicitante: " + chamado.getTelefoneContato());
        System.out.println("Area do Solicitante: " + chamado.getAreaIniciador());
        System.out.println("Descrição breve do chamado: " + chamado.getDescricaoChamado());
        //System.out.println("Tipo de Localização do Solicitante: " + chamado.getTipoLocalizacao());
        //System.out.println("Tipo de Chamado: " + chamado.getTipoChamado());
        //System.out.println("Gravidade: " + chamado.getGravidadeChamado());
        //System.out.println("Urgência: " + chamado.getUrgenciaChamado());


        in.close();
    }
}