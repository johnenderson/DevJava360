package com.issuetracker.engine;

public class Issue {

    private String title;
    private String idIssue;
    private String iniciadorChamado;
    private String solicitanteChamado;
    private String phone;
    private String areaSolicitante;
    private String email;
    private String emailsAdicionais;
    private String descricaoChamado;
    private int categoryId;
    private int locationType;
    private int severityId;
    private int urgencyId;

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

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAreaSolicitante() {
        return areaSolicitante;
    }

    public void setAreaSolicitante(String areaSolicitante) {
        this.areaSolicitante = areaSolicitante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailsAdicionais() {
        return emailsAdicionais;
    }

    public void setEmailsAdicionais(String emailsAdicionais) {
        this.emailsAdicionais = emailsAdicionais;
    }

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado(String s) {
        this.descricaoChamado = descricaoChamado;
    }

}
