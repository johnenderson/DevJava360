package com.issuetracker.engine;

import com.issuetracker.engine.entity.Issue;
import com.issuetracker.engine.enums.IssueCategory;
import com.issuetracker.engine.enums.IssueSeverity;
import com.issuetracker.engine.enums.IssueUrgency;
import com.issuetracker.engine.utils.Terms;
import com.issuetracker.engine.enums.UserLocationType;

import java.util.Scanner;

public class NewActivity {

    private static boolean errorRequester = true;
    private static boolean errorAdditionalEmails = true;

    public static void main(String[] args) {
        Issue issue = new Issue();

    	Scanner in = new Scanner(System.in);
        System.out.println(Terms.TERM_001.getTermName());
        issue.user.setNmUser(in.nextLine().toUpperCase());
        System.out.println("Certo " + issue.user.getNmUser() + " vamos começar!");

        System.out.println(Terms.TERM_002.getTermName());
        while (errorRequester) {
            try {
                int optionSelectedRequester = Integer.valueOf(in.nextLine());
                switch (optionSelectedRequester) {
                    case 1:
                        issue.setSolicitanteChamado(issue.user.getNmUser());
                        System.out.println("Ok, " + issue.user.getNmUser() + "!");
                        errorRequester = false;
                        break;
                    case 2:
                        System.out.println(Terms.TERM_003.getTermName());
                        issue.setSolicitanteChamado(in.nextLine().toUpperCase());
                        System.out.println("OK, " + issue.getSolicitanteChamado()+"!");
                        errorRequester = false;
                        break;
                    default:
                        System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
            }
        }

        System.out.println(Terms.TERM_004.getTermName());
        issue.user.setPhone(in.nextLine());

        System.out.println(Terms.TERM_005.getTermName());
        UserLocationType locationType = null;
        while (locationType == null) {
            try {
                int locationTypeInput = Integer.valueOf(in.nextLine());
                locationType = UserLocationType.values()[locationTypeInput - 1];
                issue.user.setLocationTypeId(locationType.getLocationTypeId());
                issue.user.setLocationTypeName(locationType.getLocationTypeName());
                System.out.println(locationType.getLocationTypeName() + Terms.TERM_017.getTermName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        System.out.println(Terms.TERM_006.getTermName());
        issue.user.setNmDepartment(in.nextLine());

        System.out.println(Terms.TERM_007.getTermName());
        issue.user.setDsEmail(in.nextLine().toLowerCase());

        System.out.println(Terms.TERM_008.getTermName());
        while (errorAdditionalEmails) {
            try {
                int optionSelectedEmails = Integer.valueOf(in.nextLine());
                switch (optionSelectedEmails) {
                    case 1:
                        System.out.println(Terms.TERM_011.getTermName());
                        issue.setAdditionalEmails(in.nextLine().toLowerCase());
                        System.out.println(Terms.TERM_012.getTermName() + issue.getAdditionalEmails());
                        errorAdditionalEmails = false;
                        break;
                    case 2:
                        System.out.println(Terms.TERM_013.getTermName());
                        errorAdditionalEmails=false;
                        break;
                    default:
                        System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
            }
        }

        System.out.println(Terms.TERM_009.getTermName());
        issue.setTitle(in.nextLine());

        System.out.println(Terms.TERM_010.getTermName());
        IssueCategory category = null;
        while (category == null) {
            try {
                int categoryInput = Integer.valueOf(in.nextLine());
                category = IssueCategory.values()[categoryInput - 1];
                issue.setCategoryId(category.getCategoryId());
                issue.setCategoryName(category.getCategoryName());
                System.out.println(category.getCategoryName() + Terms.TERM_017.getTermName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre " + e.getMessage());
            }
        }

//      Informar gravidade
        System.out.println(Terms.TERM_015.getTermName());
        IssueSeverity issueSeverity = null;
        while (issueSeverity == null) {
            try {
                int issueSeverityInput = Integer.valueOf(in.nextLine());
                issueSeverity = IssueSeverity.values()[issueSeverityInput - 1];
                issue.setSeverityId(issueSeverity.getSeverityId());
                issue.setSeverityName(issueSeverity.getSeverityName());
                System.out.println(issueSeverity.getSeverityName() + Terms.TERM_017.getTermName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        //Informar urgencia
        System.out.println(Terms.TERM_016.getTermName());
        IssueUrgency issueUrgency = null;
        while (issueUrgency == null) {
            try {
                int issueUrgencyInput = Integer.valueOf(in.nextLine());
                issueUrgency = IssueUrgency.values()[issueUrgencyInput - 1];
                issue.setUrgencyId(issueUrgency.getUrgencyId());
                issue.setUrgencyName(issueUrgency.getUrgencyName());
                System.out.println(issueUrgency.getUrgencyName() + Terms.TERM_017.getTermName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
            }
        }

        System.out.println(Terms.TERM_014.getTermName());
        issue.setIssueDescription(in.nextLine());

        System.out.println("------------------------------");
        System.out.println("INFORMAÇÕES DO CHAMADO");
        System.out.println("------------------------------");
        System.out.println("Titulo: " + issue.getTitle());
        System.out.println("Nome Iniciador: " + issue.user.getNmUser());
        System.out.println("Nome Solicitante: " + issue.getSolicitanteChamado());
        System.out.println("E-mail do Solicitante: " + issue.user.getDsEmail());
        System.out.println("E-mails adicionais a serem notificados: " + issue.getAdditionalEmails());
        System.out.println("Telefone do Solicitante: " + issue.user.getPhone());
        System.out.println("Departamento do Solicitante: " + issue.user.getNmDepartment());
        System.out.println("Descrição breve da Issue: " + issue.getIssueDescription());
        System.out.println("Tipo de Localização do Solicitante: " + issue.user.getLocationTypeName());
        System.out.println("Categoria do Chamado: " + issue.getCategoryName());
        System.out.println("Gravidade: " + issue.getSeverityName());
        System.out.println("Urgência: " + issue.getUrgencyName());

        in.close();
    }
}