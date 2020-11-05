package com.sda.practical.entities.imobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table

public class AnuntStatusEntitate {

    @Id
    private Integer idAnuntStatusEntitate;
    private String statusAnunt;

    @OneToMany(mappedBy = "anuntStatusEntity")
    private List<ImobileEntitate> listaImobile;

    public Integer getIdAnuntStatusEntitate() {
        return idAnuntStatusEntitate;
    }

    public void setIdAnuntStatusEntitate(Integer idAnuntStatusEntitate) {
        this.idAnuntStatusEntitate = idAnuntStatusEntitate;
    }


    public String getStatusAnunt() {
        return statusAnunt;
    }

    public void setStatusAnunt(String statusAnunt) {
        this.statusAnunt = statusAnunt;
    }

    public List<ImobileEntitate> getListaImobile() {
        return listaImobile;
    }

    public void setListaImobile(List<ImobileEntitate> listaImobile) {
        this.listaImobile = listaImobile;
    }


}
