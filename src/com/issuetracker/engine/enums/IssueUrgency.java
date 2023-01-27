package com.issuetracker.engine.enums;

public enum IssueUrgency {

    ISSUE_URGENCY_1(1, "Necessario ação imediata (Usar apenas na gravidade 1)"),
    ISSUE_URGENCY_2(2, "Atender o mais cedo possivel"),
    ISSUE_URGENCY_3(3, "Prazo padrão de atendimento");

    private int urgencyId;
    private String urgencyName;

    IssueUrgency(int urgencyId, String urgencyName) {
        this.urgencyId = urgencyId;
        this.urgencyName = urgencyName;
    }

    public int getUrgencyId() {
        return urgencyId;
    }

    public String getUrgencyName() {
        return urgencyName;
    }
}
