package com.sda.practical.entities.users;

import javax.persistence.*;

@Entity
@Table

public class ListaFavoriteEntitate {
    @Id
    private Integer listaFavoriteEntitateId;
    private Integer idUtilizator;
    private Integer imobilId;

    @ManyToOne
    @JoinColumn(name = "idUtilizator")
    private UtilizatorEntitate utilizator;


    public Integer getListaFavoriteEntitateId() {
        return listaFavoriteEntitateId;
    }

    public void setListaFavoriteEntitateId(Integer listaFavoriteEntitateId) {
        this.listaFavoriteEntitateId = listaFavoriteEntitateId;
    }

    public Integer getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public Integer getImobilId() {
        return imobilId;
    }

    public void setImobilId(Integer imobilId) {
        this.imobilId = imobilId;
    }

    public UtilizatorEntitate getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(UtilizatorEntitate utilizator) {
        this.utilizator = utilizator;
    }
}
