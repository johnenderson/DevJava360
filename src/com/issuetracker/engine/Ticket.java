package com.issuetracker.engine;

public class Ticket extends TypeTicket{

    private String tituloChamado;
    private String numeroChamado;
    private String iniciadorChamado;
    private String solicitanteChamado;
    private String telefoneContato;
    private String areaIniciador;
    private String localizacao;
    private String email;
    private String emailsAdicionais; //E-mails adicionais a serem notificados, separados por ";". (Ex: e-mail1@teste.com; email2@teste.com)
    private String descricaoChamado; //Qual a sua dúvida ou problema? (Se for um problema, detalhe o máximo possível incluindo como anexo a tela do erro)

    public void setNumeroChamado(String numeroChamado) {
        this.numeroChamado = numeroChamado;
    }
    
    public String getTituloChamado() {
        return tituloChamado;
    }

    public void setTituloChamado(String tituloChamado) {
        this.tituloChamado = tituloChamado;
    }

    public String getNumeroChamado() {
        return numeroChamado;
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

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getAreaIniciador() {
        return areaIniciador;
    }

    public void setAreaIniciador(String areaIniciador) {
        this.areaIniciador = areaIniciador;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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
