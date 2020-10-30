package com.sda.practical.entities.users;

import javax.persistence.*;

@Entity
@Table

public class UserTypesEntity {
    @Id
    @Column(name = "IDUserTypesEntity")
    private Integer userTypesEntityId;
    private Integer vanzator ;
    private Integer cumparator ;



    //TODO - relations ONE TO ONE and ONE TO MANY

    @OneToOne(mappedBy = "userType")
//    @JoinColumn(name = "userId")
    private UtilizatorEntitate user;


    public Integer getUserTypesEntityId() {
        return userTypesEntityId;
    }

    public void setUserTypesEntityId(Integer userTypesEntityId) {
        this.userTypesEntityId = userTypesEntityId;
    }

//    public String getVanzator() {
//        return vanzator;
//    }
//
//    public void setVanzator(String vanzator) {
//        this.vanzator = vanzator;
//    }
//
//    public String getCumparator() {
//        return cumparator;
//    }
//
//    public void setCumparator(String cumparator) {
//        this.cumparator = cumparator;
//    }
//
//    public String getChirias() {
//        return chirias;
//    }
//
//    public void setChirias(String chirias) {
//        this.chirias = chirias;
//    }


    public Integer getVanzator() {
        return vanzator;
    }

    public void setVanzator(Integer vanzator) {
        this.vanzator = vanzator;
    }

    public Integer getCumparator() {
        return cumparator;
    }

    public void setCumparator(Integer cumparator) {
        this.cumparator = cumparator;
    }

    public UtilizatorEntitate getUser() {
        return user;
    }

    public void setUser(UtilizatorEntitate user) {
        this.user = user;
    }


}
