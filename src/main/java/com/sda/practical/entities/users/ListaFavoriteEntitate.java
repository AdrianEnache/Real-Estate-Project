package com.sda.practical.entities.users;

import javax.persistence.*;

@Entity
@Table

public class ListaFavoriteEntitate {
    @Id
    private Integer listaFavoriteEntitateId;
    @Column(insertable = false,updatable = false)
    private Integer idUtilizator;
    private Integer imobilId;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        return "ListaFavoriteEntitate{" +
                "listaFavoriteEntitateId=" + listaFavoriteEntitateId +
                ", idUtilizator=" + idUtilizator +
                ", imobilId=" + imobilId +
                ", utilizator=" + utilizator +
                '}';
    }
}
