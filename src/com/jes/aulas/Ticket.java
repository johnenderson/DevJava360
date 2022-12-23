package com.jes.aulas;

public class Ticket {

    private String tipoChamado = "Selecione o tipo de chamado: " + "\n" + "1 - Segurança da informação" + "\n" + "2 - Infraestrutura"  + "\n" +  "3 - Sistemas";
    private String tituloChamado = new String();
    private String numeroChamado = new String();
    private String iniciadorChamado = new String();
    private String solicitanteChamado = new String();
    private String telefoneContato = new String();
    private String areaIniciador = new String();
    private String tipoLocalizacao = "1. Loja," +"\n" +  "2. Fabrica" + "\n" + "3. Escritorio";
    private String localizacao = new String();
    private String email = new String();
    private String emailsAdicionais = new String(); //E-mails adicionais a serem notificados, separados por ";". (Ex: e-mail1@teste.com; email2@teste.com)
    private String gravidadeChamado = "0. Erro que impede a continuidade do projeto de implantação," + "\n" + "1. Sistema Indisponivel," + "\n" + " 2. Erro critico para operação do sistema," + "\n" + "3. Erro médio ou de menor impacto," + "\n" + " 4. Dúvidas e ou melhorias";
    private String urgenciaChamado = "1. Necessario ação imediata (Usar apenas na gravidade 1), 2. Atender o mais cedo possivel, 3. Prazo padrão de atendimento";
    private String descricaoChamado = new String(); //Qual a sua dúvida ou problema? (Se for um problema, detalhe o máximo possível incluindo como anexo a tela do erro)

    public String getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(String tipoChamado) {
        this.tipoChamado = tipoChamado;
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

    public void setNumeroChamado(String numeroChamado) {
        this.numeroChamado = numeroChamado;
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

    public String getTipoLocalizacao() {
        return tipoLocalizacao;
    }

    public void setTipoLocalizacao(String tipoLocalizacao) {
        this.tipoLocalizacao = tipoLocalizacao;
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

    public String getGravidadeChamado() {
        return gravidadeChamado;
    }

    public void setGravidadeChamado(String gravidadeChamado) {
        this.gravidadeChamado = gravidadeChamado;
    }

    public String getUrgenciaChamado() {
        return urgenciaChamado;
    }

    public void setUrgenciaChamado(String urgenciaChamado) {
        this.urgenciaChamado = urgenciaChamado;
    }

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado() {
        this.descricaoChamado = descricaoChamado;
    }

}
