package com.issuetracker.engine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ISSUEPROCESS")
public class Issue {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid" )
    @Column(name = "idprocess", columnDefinition = "VARCHAR(32)")
    private String idIssue;

    @Column(name = "nmtitle")
    private String title;

    @ManyToOne
    @Column(name = "cduserstart")
    @JoinColumn(name = "cduser")
    private Integer starterId;

    @ManyToOne
    @Column(name = "cduserrequester")
    @JoinColumn(name = "cduser")
    private Integer requesterId;

    @Column(name = "nmadditionalemails")
    private String additionalEmails;

    @Column(name = "nmissuedescription")
    private String issueDescription;

    @Column(name = "cdcategory")
    private Integer categoryId;

    @Column(name = "nmcategory")
    private String categoryName;

    @Column(name = "cdseverity")
    private Integer severityId;

    @Column(name = "nmseverity")
    private String severityName;

    @Column(name = "cdurgency")
    private Integer urgencyId;

    @Column(name = "nmurgency")
    private String urgencyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cduser")
    private User user;

    public Integer getStarterId() {
        return starterId;
    }

    public Integer getRequesterId() {
        return requesterId;
    }

    public String getIdIssue() {
        return idIssue;
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

    public void setStarterId(Integer starterId) {
        this.starterId = starterId;
    }

    public void setRequesterId(Integer requesterId) {
        this.requesterId = requesterId;
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

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSeverityId() {
        return severityId;
    }

    public void setSeverityId(Integer severityId) {
        this.severityId = severityId;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
    }

    public Integer getUrgencyId() {
        return urgencyId;
    }

    public void setUrgencyId(Integer urgencyId) {
        this.urgencyId = urgencyId;
    }

    public String getUrgencyName() {
        return urgencyName;
    }

    public void setUrgencyName(String urgencyName) {
        this.urgencyName = urgencyName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "idIssue='" + idIssue + '\'' +
                ", title='" + title + '\'' +
                ", starterId=" + starterId +
                ", requesterId=" + requesterId +
                ", additionalEmails='" + additionalEmails + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", severityId=" + severityId +
                ", severityName='" + severityName + '\'' +
                ", urgencyId=" + urgencyId +
                ", urgencyName='" + urgencyName + '\'' +
                ", user=" + user +
                '}';
    }
}
