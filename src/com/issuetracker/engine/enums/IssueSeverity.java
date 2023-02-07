package com.issuetracker.engine.enums;

public enum IssueSeverity {

    ISSUE_SEVERITY_LEVEL_0(0, "Erro que impede a continuidade do projeto de implantação"),
    ISSUE_SEVERITY_LEVEL_1(1, "Sistema Indisponivel"), ISSUE_SEVERITY_LEVEL_2(2, "Erro critico para operação do sistema"),
    ISSUE_SEVERITY_LEVEL_3(3, "Erro médio ou de menor impacto"), ISSUE_SEVERITY_LEVEL_4(4, "Dúvidas e ou melhorias");

    private final int severityId;
    private final String severityName;

    IssueSeverity(int severityId, String severityName) {
        this.severityId = severityId;
        this.severityName = severityName;
    }

    public int getSeverityId() {
        return severityId;
    }

    public String getSeverityName() {
        return severityName;
    }
}
