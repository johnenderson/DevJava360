package com.issuetracker.engine.enums;

public enum IssueType {

    ISSUE_TYPE_001(0, "Segurança da informação"),
    ISSUE_TYPE_002(1, "Infraestrutura"),
    ISSUE_TYPE_003(2, "Sistemas");

    private int issueTypeID;
    private String IssueTypeName;

    IssueType(int issueTypeID, String issueTypeName) {
        this.issueTypeID = issueTypeID;
        IssueTypeName = issueTypeName;
    }

    public int getIssueTypeID() {
        return issueTypeID;
    }

    public String getIssueTypeName() {
        return IssueTypeName;
    }

}
