package com.issuetracker.engine;

import com.issuetracker.engine.enums.IssueCategory;
import com.issuetracker.engine.enums.UserLocationType;
import com.issuetracker.engine.enums.IssueSeverity;
import com.issuetracker.engine.enums.IssueTerms;
import com.issuetracker.engine.enums.IssueUrgency;
import com.issuetracker.engine.exception.IssueTrackerErrors;

import java.util.Scanner;

public class NewActivity {

    public static void main(String[] args) {

        Issue issue = new Issue();
        User user = new User();
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
        user.setPhone(in.nextLine());

        System.out.println(IssueTerms.TERM_005.getTermName());
        UserLocationType locationType = null;
        while (locationType == null) {
            try {
                int locationTypeInput = Integer.valueOf(in.nextLine());
                locationType = UserLocationType.values()[locationTypeInput - 1];
                user.setLocationTypeId(locationType.getLocationTypeId());
                user.setLocationTypeName(locationType.getLocationTypeName());
                System.out.println(locationType.getLocationTypeName() + IssueTerms.TERM_017.getTermName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        System.out.println(IssueTerms.TERM_006.getTermName());
        user.setNmDepartment(in.nextLine());

        System.out.println(IssueTerms.TERM_007.getTermName());
        user.setNmDepartment(in.nextLine().toLowerCase());

        System.out.println(IssueTerms.TERM_008.getTermName());
        while (error.isErrorAdditionalEmails()) {
            try {
                int optionSelectedEmails = Integer.valueOf(in.nextLine());
                switch (optionSelectedEmails) {
                    case 1:
                        System.out.println(IssueTerms.TERM_011.getTermName());
                        issue.setSolicitanteChamado(in.nextLine().toLowerCase());
                        System.out.println(IssueTerms.TERM_012.getTermName() + issue.getAdditionalEmails());
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
                issue.setCategoryName(category.getCategoryName());
                System.out.println(category.getCategoryName() + IssueTerms.TERM_017.getTermName());
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
                issue.setSeverityName(issueSeverity.getSeverityName());
                System.out.println(issueSeverity.getSeverityName() + IssueTerms.TERM_017.getTermName());
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
                issue.setUrgencyName(issueUrgency.getUrgencyName());
                System.out.println(issueUrgency.getUrgencyName() + IssueTerms.TERM_017.getTermName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        System.out.println(IssueTerms.TERM_014.getTermName());
        issue.setIssueDescription(in.nextLine());

        System.out.println("------------------------------");
        System.out.println("INFORMAÇÕES DO CHAMADO");
        System.out.println("------------------------------");
        System.out.println("Titulo: " + issue.getTitle());
        System.out.println("Nome Iniciador: " + issue.getIniciadorChamado());
        System.out.println("Nome Solicitante: " + issue.getSolicitanteChamado());
        System.out.println("E-mail do Solicitante: " + user.getDsEmail());
        System.out.println("E-mails adicionais a serem notificados: " + issue.getAdditionalEmails());
        System.out.println("Telefone do Solicitante: " + user.getPhone());
        System.out.println("Area do Solicitante: " + user.getNmDepartment());
        System.out.println("Descrição breve do issue: " + issue.getIssueDescription());
        System.out.println("Tipo de Localização do Solicitante: " + user.getLocationTypeName());
        System.out.println("Categotria do Chamado: " + issue.getCategoryName());
        System.out.println("Gravidade: " + issue.getSeverityName());
        System.out.println("Urgência: " + issue.getUrgencyName());

        in.close();
    }
}