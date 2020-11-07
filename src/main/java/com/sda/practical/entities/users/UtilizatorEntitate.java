package com.sda.practical.entities.users;

import com.sda.practical.entities.imobile.ImobileEntitate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table

public class UtilizatorEntitate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Integer idUtilizator;
    private String numeDeFamilie;
    private String prenume;
    private String numarTelefon;
    private String adresaEmail;
    private String parola;
    @Column(insertable = false, updatable = false)
    private Integer idTipUser;

    @OneToMany(mappedBy = "utilizatorEntitate")
    private List<ImobileEntitate> imobileEntitateList;

    @ManyToOne
    @JoinColumn(name = "idTipUser")
    private UserTypesEntity userType;

    //TODO sa facem cu LAZY

    @ManyToMany
    @JoinTable(
            name = "favorite",
            joinColumns = {@JoinColumn(name = "utilizatorId")},
            inverseJoinColumns = {@JoinColumn(name = "imobileId")}
    )
    private List<ImobileEntitate> favorite = new ArrayList<>();


    public List<ImobileEntitate> getImobileEntitateList() {
        return imobileEntitateList;
    }

    public void setImobileEntitateList(List<ImobileEntitate> imobileEntitateList) {
        this.imobileEntitateList = imobileEntitateList;
    }

    public UserTypesEntity getUserType() {
        return userType;
    }

    public void setUserType(UserTypesEntity userType) {
        this.userType = userType;
    }

    public Integer getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNumeDeFamilie() {
        return numeDeFamilie;
    }

    public void setNumeDeFamilie(String numeDeFamilie) {
        this.numeDeFamilie = numeDeFamilie;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getAdresaEmail() {
        return adresaEmail;
    }

    public void setAdresaEmail(String adresaEmail) {
        this.adresaEmail = adresaEmail;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }


    public Integer getIdTipUser() {
        return idTipUser;
    }

    public void setIdTipUser(Integer idTipUser) {
        this.idTipUser = idTipUser;
    }

    public List<ImobileEntitate> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<ImobileEntitate> favorite) {
        this.favorite = favorite;
    }
}