package com.sda.practical.entities.users;

import javax.persistence.ManyToOne;
import java.util.List;


public class ListaFavoriteEntitate {
    private Integer listaFavoriteEntitateId;
    private Integer idUtilizator;
    private Integer imobilId;

    @ManyToOne(mappedBy = "userEntity")
    private List<UtilizatorEntitate> userEntityList;


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
}
