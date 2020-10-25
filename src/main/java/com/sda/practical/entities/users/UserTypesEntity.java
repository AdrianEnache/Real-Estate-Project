package com.sda.practical.entities.users;

import javax.persistence.Id;


public class UserTypesEntity {
    @Id
    private Integer userTypesEntityId;
    private String seller;
    private String buyer;
    private String renter;

//TODO - relations ONE TO ONE and ONE TO MANY


    public Integer getUserTypesEntityId() {
        return userTypesEntityId;
    }

    public void setUserTypesEntityId(Integer userTypesEntityId) {
        this.userTypesEntityId = userTypesEntityId;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }
}
