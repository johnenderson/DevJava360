package com.issuetracker.engine.domain.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "USERS")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cduser")
    private Integer cdUser;

    @Column(name = "nmuser")
    private String nmUser;

    @Column(name = "nmdepartment")
    private String nmDepartment;

    @Column(name = "dsuseremail")
    private String dsEmail;

    @Column(name = "phone")
    private String phone;

//    @Column(name = "cdlocationtype")
//    private Integer locationTypeId;
//
//    @Column(name = "nmlocationtype")
//    private String locationTypeName;
//
//    @OneToMany(mappedBy = "starterId")
//    private List<Issue> issueStarterList;
//
//    @OneToMany(mappedBy = "requesterId")
//    private List<Issue> issueRequesterList;

}
