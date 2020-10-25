package com.sda.practical.entities.users;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.List;

=======

import javax.persistence.*;
import javax.persistence.Table;
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61

@Table

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD

=======
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
    private Integer userId;
    @Column(length = 45)
    private String surname;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String phoneNumber;
    @Column (length = 45)
    private String email;
    @Column(length = 45)
    private String password;


    @OneToOne (mappedBy = "user")
    private UserTypesEntity userTypesEntity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
