package com.sda.practical.entities.users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class UserTypesEntity {
    @Id
    private Integer userTypesEntityId;
    private String tipClient;
    private Integer tipUserId;


    //TODO - relations ONE TO ONE and ONE TO MANY -done

    @OneToMany(mappedBy = "userType")
    private List<UtilizatorEntitate> listUser;

    public Integer getUserTypesEntityId() {
        return userTypesEntityId;
    }

    public void setUserTypesEntityId(Integer userTypesEntityId) {
        this.userTypesEntityId = userTypesEntityId;
    }

    public String getTipClient() {
        return tipClient;
    }

    public void setTipClient(String tipClient) {
        this.tipClient = tipClient;
    }

    public Integer getTipUserId() {
        return tipUserId;
    }

    public void setTipUserId(Integer tipUserId) {
        this.tipUserId = tipUserId;
    }

    public List<UtilizatorEntitate> getListUser() {
        return listUser;
    }

    public void setListUser(List<UtilizatorEntitate> listUser) {
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "UserTypesEntity{" +
                "userTypesEntityId=" + userTypesEntityId +
                ", tipClient='" + tipClient + '\'' +
                ", tipUserId=" + tipUserId +
                ", listUser=" + listUser +
                '}';
    }
}
