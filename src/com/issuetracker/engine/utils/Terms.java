package com.issuetracker.engine.utils;

public enum Terms {

    TERM_001(0, "Seja bem vindo ao sistema de chamados, insira seu nome para iniciar:"),
    TERM_002(1, "Você é o solicitante do chamado? (Digite 1 para 'SIM' ou 2 para 'NÃO'"),
    TERM_003(2, "Digite o nome do solicitante: "),
    TERM_004(3, "Informar Telefone ou Ramal para contato:"),
    TERM_005(4, "Informe qual é o Tipo de Localização: Tipo de Localização (1. Loja, 2. Fabrica ou 3. Escritório)"),
    TERM_006(5, "Informar o nome do Departamento do Solicitante: "),
    TERM_007(6, "Digite o e-mail do Solicitante do chamado: "),
    TERM_008(7, "Deseja informar mais E-mails? Digite '1' para 'SIM' e '2' para 'NÃO'"),
    TERM_009(8, "Informe qual é o Titulo para este chamado: "),
    TERM_010(9, "Selecione a categoria do chamado: "),
    TERM_011(10,"Informar e-mails adicionais a serem notificados, separados por ';'. (Ex: e-mail1@teste.com; email2@teste.com)"),
    TERM_012(11, "E-mails informados: "),
    TERM_013(12,"Ok! Não foram informados e-mails adicionais"),
    TERM_014(13,"Qual a sua dúvida ou problema? (Se for um problema, detalhe o máximo possível incluindo como anexo a tela do erro)"),
    TERM_015(14, "Informe qual é Gravidade do chamado: "),
    TERM_016(15, "Informe qual é a Urgência do chamado: "),
    TERM_017(16, ", selecionado!");

    private final int termID;
    private final String termName;

    Terms(int termID, String termName) {
        this.termID = termID;
        this.termName = termName;
    }

    public int getTermID() {
        return termID;
    }

    public String getTermName() {
        return termName;
    }

}
