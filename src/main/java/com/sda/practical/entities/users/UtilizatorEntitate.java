package com.sda.practical.entities.users;

import javax.persistence.*;
import java.util.List;

@Table
public class UtilizatorEntitate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilizator;
    @Column(length = 45)
    private String numeDeFamilie;
    @Column(length = 45)
    private String prenume;
    @Column(length = 45)
    private String numarTelefon;
    @Column(length = 45)
    private String adresaEmail;
    @Column(length = 45)
    private String parola;

    @OneToOne(mappedBy = "user")
    private UserTypesEntity userType;

    @OneToMany(mappedBy = "utilizator")
    private List<ListaFavoriteEntitate> favouritesListEntityId;

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

    public List<ListaFavoriteEntitate> getFavouritesListEntityId() {
        return favouritesListEntityId;
    }

    public void setFavouritesListEntityId(List<ListaFavoriteEntitate> favouritesListEntityId) {
        this.favouritesListEntityId = favouritesListEntityId;
    }
}