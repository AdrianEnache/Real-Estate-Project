package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class ValutaEntitate {

    @Id
    private Integer idValutateEntitate;
    private String tipValuta;

    @OneToMany(mappedBy = "valutaEntitate")
   private List<ImobileEntitate> listaImobile;

    public Integer getIdValutateEntitate() {
        return idValutateEntitate;
    }

    public void setIdValutateEntitate(Integer idValutateEntitate) {
        this.idValutateEntitate = idValutateEntitate;
    }

    public String getTipValuta() {
        return tipValuta;
    }

    public void setTipValuta(String tipValuta) {
        this.tipValuta = tipValuta;
    }

    public List<ImobileEntitate> getListaImobile() {
        return listaImobile;
    }

    public void setListaImobile(List<ImobileEntitate> listaImobile) {
        this.listaImobile = listaImobile;
    }
}
