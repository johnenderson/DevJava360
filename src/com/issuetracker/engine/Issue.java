package com.issuetracker.engine;

public class Issue {

    private String title;
    private String idIssue;
    private String iniciadorChamado;
    private String solicitanteChamado;
    private String additionalEmails;
    private String issueDescription;
    private int categoryId;
    private String categoryName;
    private int severityId;
    private String severityName;
    private int urgencyId;
    private String urgencyName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
    }

    public String getUrgencyName() {
        return urgencyName;
    }

    public void setUrgencyName(String urgencyName) {
        this.urgencyName = urgencyName;
    }

    public int getUrgencyId() {
        return urgencyId;
    }

    public void setUrgencyId(int urgencyId) {
        this.urgencyId = urgencyId;
    }

    public int getSeverityId() {
        return severityId;
    }

    public void setSeverityId(int severityId) {
        this.severityId = severityId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setIdIssue(String idIssue) {
        this.idIssue = idIssue;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdIssue() {
        return idIssue;
    }

    public String getIniciadorChamado() {
        return iniciadorChamado;
    }

    public void setIniciadorChamado(String iniciadorChamado) {
        this.iniciadorChamado = iniciadorChamado;
    }

    public String getSolicitanteChamado() {
        return solicitanteChamado;
    }

    public void setSolicitanteChamado(String solicitanteChamado) {
        this.solicitanteChamado = solicitanteChamado;
    }

    public String getAdditionalEmails() {
        return additionalEmails;
    }

    public void setAdditionalEmails(String additionalEmails) {
        this.additionalEmails = additionalEmails;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String s) {
        this.issueDescription = issueDescription;
    }

}
