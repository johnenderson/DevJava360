package com.issuetracker.engine.enums;

public enum IssueYesNo {

    YES(1, "Sim!"),
    NO(2, "Não!");

    private int issueYesNoId;

    private String issueYesNo;

    IssueYesNo(int IssueYesNoId, String issueYesNo) {
        this.issueYesNoId = IssueYesNoId;
        issueYesNo = issueYesNo;
    }

//    public IssueYesNo findEnum(int value){
//
//    }

    public int getIssueYesNoId() {
        return issueYesNoId;
    }

    public String getIssueYesNo() {
        return issueYesNo;
    }
}
