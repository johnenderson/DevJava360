package com.issuetracker.engine;

import com.issuetracker.engine.enums.IssueCategory;
import com.issuetracker.engine.enums.IssueLocationType;
import com.issuetracker.engine.enums.IssueSeverity;
import com.issuetracker.engine.enums.IssueTerms;
import com.issuetracker.engine.enums.IssueUrgency;
import com.issuetracker.engine.exception.IssueTrackerErrors;

import java.util.Scanner;

public class NewActivity {

    public static void main(String[] args) {

        Issue issue = new Issue();
        IssueTrackerErrors error = new IssueTrackerErrors();

    	Scanner in = new Scanner(System.in);
        System.out.println(IssueTerms.TERM_001.getTermName());
        issue.setIniciadorChamado(in.nextLine().toUpperCase());
        System.out.println("Certo " + issue.getIniciadorChamado() + " vamos começar!");

        System.out.println(IssueTerms.TERM_002.getTermName());
        while (error.isErrorRequester()) {
            try {
                int optionSelectedRequester = Integer.valueOf(in.nextLine());
                switch (optionSelectedRequester) {
                    case 1:
                        issue.setSolicitanteChamado(issue.getIniciadorChamado());
                        System.out.println("Ok, " + issue.getIniciadorChamado() + "!");
                        error.setErrorRequester(false);
                        break;
                    case 2:
                        System.out.println(IssueTerms.TERM_003.getTermName());
                        issue.setSolicitanteChamado(in.nextLine().toUpperCase());
                        System.out.println("OK, " + issue.getSolicitanteChamado()+"!");
                        error.setErrorRequester(false);
                        break;
                    default:
                        System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
            }
        }

        System.out.println(IssueTerms.TERM_004.getTermName());
        issue.setPhone(in.nextLine());


        System.out.println(IssueTerms.TERM_005.getTermName());
        IssueLocationType locationType = null;
        while (locationType == null) {
            try {
                int locationTypeInput = Integer.valueOf(in.nextLine());
                locationType = IssueLocationType.values()[locationTypeInput - 1];
                issue.setLocationType(locationType.getLocationTypeId());
                System.out.println(locationType.getlocationTypeName() + ", selecionado!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        System.out.println(IssueTerms.TERM_006.getTermName());
        issue.setAreaSolicitante(in.nextLine());

        System.out.println(IssueTerms.TERM_007.getTermName());
        issue.setEmail(in.nextLine().toLowerCase());

        System.out.println(IssueTerms.TERM_008.getTermName());
        while (error.isErrorAdditionalEmails()) {
            try {
                int optionSelectedEmails = Integer.valueOf(in.nextLine());
                switch (optionSelectedEmails) {
                    case 1:
                        System.out.println(IssueTerms.TERM_011.getTermName());
                        issue.setSolicitanteChamado(in.nextLine().toLowerCase());
                        System.out.println(IssueTerms.TERM_012.getTermName() + issue.getEmailsAdicionais());
                        error.setErrorAdditionalEmails(false);
                        break;
                    case 2:
                        System.out.println(IssueTerms.TERM_013.getTermName());
                        error.setErrorAdditionalEmails(false);
                        break;
                    default:
                        System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
            }
        }

        System.out.println(IssueTerms.TERM_009.getTermName());
        issue.setTitle(in.nextLine());

        System.out.println(IssueTerms.TERM_010.getTermName());
        IssueCategory category = null;
        while (category == null) {
            try {
                int categoryInput = Integer.valueOf(in.nextLine());
                category = IssueCategory.values()[categoryInput - 1];
                issue.setCategoryId(category.getCategoryId());
                System.out.println(category.getCategoryName() + ", selecionado!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 9.");
            }
        }

//      Informar gravidade
        System.out.println(IssueTerms.TERM_015.getTermName());
        IssueSeverity issueSeverity = null;
        while (issueSeverity == null) {
            try {
                int issueSeverityInput = Integer.valueOf(in.nextLine());
                issueSeverity = IssueSeverity.values()[issueSeverityInput - 1];
                issue.setSeverityId(issueSeverity.getSeverityId());
                System.out.println(issueSeverity.getSeverityName() + ", selecionado!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        //Informar urgencia
        System.out.println(IssueTerms.TERM_016.getTermName());
        IssueUrgency issueUrgency = null;
        while (issueUrgency == null) {
            try {
                int issueUrgencyInput = Integer.valueOf(in.nextLine());
                issueUrgency = IssueUrgency.values()[issueUrgencyInput - 1];
                issue.setUrgencyId(issueUrgency.getUrgencyId());
                System.out.println(issueUrgency.getUrgencyName() + ", selecionado!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        System.out.println(IssueTerms.TERM_014.getTermName());
        issue.setDescricaoChamado(in.nextLine());

        System.out.println("------------------------------");
        System.out.println("INFORMAÇÕES DO CHAMADO");
        System.out.println("------------------------------");
        System.out.println("Titulo: " + issue.getTitle());
        System.out.println("Nome Iniciador: " + issue.getIniciadorChamado());
        System.out.println("Nome Solicitante: " + issue.getSolicitanteChamado());
        System.out.println("E-mail do Solicitante: " + issue.getEmail());
        System.out.println("E-mails adicionais a serem notificados: " + issue.getEmailsAdicionais());
        System.out.println("Telefone do Solicitante: " + issue.getPhone());
        System.out.println("Area do Solicitante: " + issue.getAreaSolicitante());
        System.out.println("Descrição breve do issue: " + issue.getDescricaoChamado());
        //System.out.println("Tipo de Localização do Solicitante: " + issue.getTipoLocalizacao());
        //System.out.println("Tipo de Chamado: " + issue.getTipoChamado());
        //System.out.println("Gravidade: " + issue.getGravidadeChamado());
        //System.out.println("Urgência: " + issue.getUrgenciaChamado());

        in.close();
    }
}