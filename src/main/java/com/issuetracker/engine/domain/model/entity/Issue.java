package com.issuetracker.engine.domain.model;

import com.issuetracker.engine.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUEPROCESS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Issue {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idprocess", columnDefinition = "VARCHAR(32)")
    private String idprocess;

    @Column(name = "nmtitle")
    private String title;

    @ManyToOne
    @JoinColumn(name = "cduserstart", insertable = true, updatable = true)
    private User starterId;

    @ManyToOne
    @JoinColumn(name = "cduserrequester", insertable = true, updatable = true)
    private User requesterId;

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

}

