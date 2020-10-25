package com.sda.practical.entities.users;

import org.hibernate.usertype.UserType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class UserTypesEntity {
    @Id
    private Integer userTypesEntityId;

    private String seller;
    private String buyer;
    private String renter;

    //TODO - relations ONE TO ONE and ONE TO MANY

<<<<<<< HEAD
=======
    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
>>>>>>> bd89567cac1298680cc84480b781721736ea7828

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
