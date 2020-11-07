package com.sda.practical.entities.users;

import com.sda.practical.entities.imobile.ImobileEntitate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class ListaFavoriteEntitate {
    @Id
    private Integer listaFavoriteEntitateId;



    @OneToMany(mappedBy = "listaFavoriteEntitate")
    private List<ImobileEntitate> imobileEntitateList;


    @ManyToOne
    @JoinColumn(name = "idUtilizator")
    private UtilizatorEntitate utilizator;


    public Integer getListaFavoriteEntitateId() {
        return listaFavoriteEntitateId;
    }

    public void setListaFavoriteEntitateId(Integer listaFavoriteEntitateId) {
        this.listaFavoriteEntitateId = listaFavoriteEntitateId;
    }


    public UtilizatorEntitate getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(UtilizatorEntitate utilizator) {
        this.utilizator = utilizator;
    }

    public List<ImobileEntitate> getImobileEntitateList() {
        return imobileEntitateList;
    }

    public void setImobileEntitateList(List<ImobileEntitate> imobileEntitateList) {
        this.imobileEntitateList = imobileEntitateList;
    }
}
