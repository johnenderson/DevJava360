package com.issuetracker.engine.exception;

public class IssueTrackerErrors {

//    private ERROR_001("ERROR: O número escolhido é inválido! Digite um número entre 1 e 2."),
//    ERROR_002("ERROR: O número escolhido é inválido! Digite um número entre 1 e 3.");

    private String errorMessage;
    private boolean errorRequester = true;
    private boolean errorAdditionalEmails = true;
    private boolean errorLocationType = true;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isErrorRequester() {
        return errorRequester;
    }

    public void setErrorRequester(boolean errorRequester) {
        this.errorRequester = errorRequester;
    }

    public boolean isErrorAdditionalEmails() {
        return errorAdditionalEmails;
    }

    public void setErrorAdditionalEmails(boolean errorAdditionalEmails) {
        this.errorAdditionalEmails = errorAdditionalEmails;
    }

    public boolean isErrorLocationType() {
        return errorLocationType;
    }

    public void setErrorLocationType(boolean errorLocationType) {
        this.errorLocationType = errorLocationType;
    }
}
