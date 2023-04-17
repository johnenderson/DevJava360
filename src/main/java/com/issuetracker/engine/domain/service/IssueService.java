package com.issuetracker.engine.domain.service;

import com.issuetracker.engine.domain.repository.IssueDao;
import com.issuetracker.engine.domain.model.entity.Issue;
import com.issuetracker.engine.domain.repository.UserDao;
import com.issuetracker.engine.enums.IssueCategory;
import com.issuetracker.engine.enums.IssueSeverity;
import com.issuetracker.engine.enums.IssueUrgency;
import com.issuetracker.engine.domain.model.entity.UserEntity;
import com.issuetracker.engine.utils.JPAUtil;
import com.issuetracker.engine.utils.Terms;
import com.issuetracker.engine.enums.UserLocationType;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class IssueService {
//
//    private static boolean errorRequester = true;
//    private static boolean errorAdditionalEmails = true;
//
//    public static void main(String[] args) {
//        EntityManager entityManager = JPAUtil.getEntityManagerIssueTracker();
//        UserEntity user =  createUser(entityManager);
//        UserEntity userRequester = null;
//
//        Issue issue = new Issue();
//        issue.setStarterId(user);
//        Scanner in = new Scanner(System.in);
//
//        System.out.println(Terms.TERM_002.getTermName());
//        while (errorRequester) {
//            try {
//                int optionSelectedRequester = Integer.valueOf(in.nextLine());
//                switch (optionSelectedRequester) {
//                    case 1:
//                        issue.setRequesterId(user);
//
//                        System.out.println("Ok, " + user.getNmUser() + "!");
//                        errorRequester = false;
//                        break;
//                    case 2:
//                        System.out.println(Terms.TERM_003.getTermName());
//                        System.out.println("Iniciando cadastro do solicitante...");
//                        userRequester = createUser(entityManager);
//                        issue.setRequesterId(userRequester);
//                        System.out.println("OK, " + userRequester.getNmUser()+"!");
//                        errorRequester = false;
//                        break;
//                    default:
//                        System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
//            }
//        }
//
//        System.out.println(Terms.TERM_008.getTermName());
//        while (errorAdditionalEmails) {
//            try {
//                int optionSelectedEmails = Integer.valueOf(in.nextLine());
//                switch (optionSelectedEmails) {
//                    case 1:
//                        System.out.println(Terms.TERM_011.getTermName());
//                        issue.setAdditionalEmails(in.nextLine().toLowerCase());
//                        System.out.println(Terms.TERM_012.getTermName() + issue.getAdditionalEmails());
//                        errorAdditionalEmails = false;
//                        break;
//                    case 2:
//                        System.out.println(Terms.TERM_013.getTermName());
//                        errorAdditionalEmails=false;
//                        break;
//                    default:
//                        System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2.");
//            }
//        }
//
//
//        System.out.println(Terms.TERM_009.getTermName());
//        issue.setTitle(in.nextLine());
//
//        System.out.println(Terms.TERM_010.getTermName());
//        IssueCategory category = null;
//        while (category == null) {
//            try {
//                int categoryInput = Integer.valueOf(in.nextLine());
//                category = IssueCategory.values()[categoryInput - 1];
//                issue.setCategoryId(category.getCategoryId());
//                issue.setCategoryName(category.getCategoryName());
//                System.out.println(category.getCategoryName() + Terms.TERM_017.getTermName());
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre " + e.getMessage());
//            }
//        }
//
////      Informar gravidade
//        System.out.println(Terms.TERM_015.getTermName());
//        IssueSeverity issueSeverity = null;
//        while (issueSeverity == null) {
//            try {
//                int issueSeverityInput = Integer.valueOf(in.nextLine());
//                issueSeverity = IssueSeverity.values()[issueSeverityInput - 1];
//                issue.setSeverityId(issueSeverity.getSeverityId());
//                issue.setSeverityName(issueSeverity.getSeverityName());
//                System.out.println(issueSeverity.getSeverityName() + Terms.TERM_017.getTermName());
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
//            }
//        }
//
//        //Informar urgencia
//        System.out.println(Terms.TERM_016.getTermName());
//        IssueUrgency issueUrgency = null;
//        while (issueUrgency == null) {
//            try {
//                int issueUrgencyInput = Integer.valueOf(in.nextLine());
//                issueUrgency = IssueUrgency.values()[issueUrgencyInput - 1];
//                issue.setUrgencyId(issueUrgency.getUrgencyId());
//                issue.setUrgencyName(issueUrgency.getUrgencyName());
//                System.out.println(issueUrgency.getUrgencyName() + Terms.TERM_017.getTermName());
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
//            }
//        }
//
//        System.out.println(Terms.TERM_014.getTermName());
//        issue.setIssueDescription(in.nextLine());
//
//        IssueDao issueDao = new IssueDao(entityManager);
//        entityManager.getTransaction().begin();
//        issueDao.createIssue(issue);
//        entityManager.getTransaction().commit();
//        entityManager.clear();
//
//
//        System.out.println("------------------------------");
//        System.out.println("INFORMAÇÕES DO CHAMADO");
//        System.out.println("------------------------------");
//        System.out.println("Titulo: " + issue.getTitle());
//        System.out.println("Nome Iniciador: " + user.getNmUser());
//        //System.out.println("Nome Solicitante: " + userRequester == null ? user.getNmUser() : userRequester.getNmUser() );
//        System.out.println("E-mail do Solicitante: " + user.getDsEmail());
//        System.out.println("E-mails adicionais a serem notificados: " + issue.getAdditionalEmails());
//        System.out.println("Telefone do Solicitante: " + user.getPhone());
//        System.out.println("Departamento do Solicitante: " + user.getNmDepartment());
//        System.out.println("Descrição breve da Issue: " + issue.getIssueDescription());
//        System.out.println("Tipo de Localização do Solicitante: " + user.getLocationTypeName());
//        System.out.println("Categoria do Chamado: " + issue.getCategoryName());
//        System.out.println("Gravidade: " + issue.getSeverityName());
//        System.out.println("Urgência: " + issue.getUrgencyName());
//
//        in.close();
//    }
//
//    public static UserEntity createUser(EntityManager entityManager){
//
//        UserEntity user = new UserEntity();
//        UserDao userDao = new UserDao(entityManager);
//        Scanner in = new Scanner(System.in);
//
//        System.out.println(Terms.TERM_001.getTermName());
//        user.setNmUser(in.nextLine().toUpperCase());
//        System.out.println("Certo " + user.getNmUser() + " vamos começar!");
//
//        System.out.println(Terms.TERM_004.getTermName());
//        user.setPhone(in.nextLine());
//
//        System.out.println(Terms.TERM_005.getTermName());
//        UserLocationType locationType = null;
//        while (locationType == null) {
//            try {
//                int locationTypeInput = Integer.valueOf(in.nextLine());
//                locationType = UserLocationType.values()[locationTypeInput - 1];
//                user.setLocationTypeId(locationType.getLocationTypeId());
//                user.setLocationTypeName(locationType.getLocationTypeName());
//                System.out.println(locationType.getLocationTypeName() + Terms.TERM_017.getTermName());
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");
//            }
//        }
//
//        System.out.println(Terms.TERM_006.getTermName());
//        user.setNmDepartment(in.nextLine());
//
//        System.out.println(Terms.TERM_007.getTermName());
//        user.setDsEmail(in.nextLine().toLowerCase());
//
//        entityManager.getTransaction().begin();
//        userDao.createUser(user);
//        entityManager.getTransaction().commit();
//        entityManager.clear();
//        return user;
//
//    }
}