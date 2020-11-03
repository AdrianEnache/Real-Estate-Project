package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class ValutaEntitate {

    @Id
    private Integer idValutateEntitate;
    private String tipValuta;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipImobilEntitate")
    private ImobileEntitate imobileEntitate;

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

    public ImobileEntitate getImobileEntitate() {
        return imobileEntitate;
    }

    public void setImobileEntitate(ImobileEntitate imobileEntitate) {
        this.imobileEntitate = imobileEntitate;
    }
}
