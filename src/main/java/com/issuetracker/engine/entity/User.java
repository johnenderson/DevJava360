package com.issuetracker.engine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

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

    @Column(name = "cdlocationtype")
    private Integer locationTypeId;

    @Column(name = "nmlocationtype")
    private String locationTypeName;

    public int getCdUser() {
        return cdUser;
    }

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public int getLocationTypeId() {
        return locationTypeId;
    }

    public void setLocationTypeId(int locationTypeId) {
        this.locationTypeId = locationTypeId;
    }

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

    public String getNmDepartment() {
        return nmDepartment;
    }

    public void setNmDepartment(String nmDepartment) {
        this.nmDepartment = nmDepartment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
