package com.sda.practical.entities.users;

import javax.persistence.*;

@Entity
@Table

public class UserTypesEntity {
    @Id
    @Column(name = "IDUserTypesEntity")
    private Integer userTypesEntityId;
    private String vanzator;
    private String cumparator;
    private String chirias;


    //TODO - relations ONE TO ONE and ONE TO MANY

    @OneToOne
    @JoinColumn(name = "userId")
    private UtilizatorEntitate user;


    public Integer getUserTypesEntityId() {
        return userTypesEntityId;
    }

    public void setUserTypesEntityId(Integer userTypesEntityId) {
        this.userTypesEntityId = userTypesEntityId;
    }

    public String getVanzator() {
        return vanzator;
    }

    public void setVanzator(String vanzator) {
        this.vanzator = vanzator;
    }

    public String getCumparator() {
        return cumparator;
    }

    public void setCumparator(String cumparator) {
        this.cumparator = cumparator;
    }

    public String getChirias() {
        return chirias;
    }

    public void setChirias(String chirias) {
        this.chirias = chirias;
    }

    public UtilizatorEntitate getUser() {
        return user;
    }

    public void setUser(UtilizatorEntitate user) {
        this.user = user;
    }


}
