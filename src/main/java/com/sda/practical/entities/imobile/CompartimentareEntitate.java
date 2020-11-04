package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class CompartimentareEntitate {

    @Id
    private Integer idCompartimentareEntitate;
    private String tipCompartimentare;

    @OneToMany(mappedBy = "compartimentareEntity")
    private List<ImobileEntitate> listaImobile;

    public Integer getIdCompartimentareEntitate() {
        return idCompartimentareEntitate;
    }

    public void setIdCompartimentareEntitate(Integer idCompartimentareEntitate) {
        this.idCompartimentareEntitate = idCompartimentareEntitate;
    }

    public String getTipCompartimentare() {
        return tipCompartimentare;
    }

    public void setTipCompartimentare(String tipCompartimentare) {
        this.tipCompartimentare = tipCompartimentare;
    }

    public List<ImobileEntitate> getListaImobile() {
        return listaImobile;
    }

    public void setListaImobile(List<ImobileEntitate> listaImobile) {
        this.listaImobile = listaImobile;
    }
}
