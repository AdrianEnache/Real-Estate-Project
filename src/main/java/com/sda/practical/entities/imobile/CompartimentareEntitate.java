package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class CompartimentareEntitate {

    @Id
    private Integer idCompartimentareEntitate;
    private String tipCompartimentare;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntitate")
    private ImobileEntitate imobileEntitate;

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

    public ImobileEntitate getImobileEntity() {
        return imobileEntitate;
    }

    public void setImobileEntity(ImobileEntitate imobileEntity) {
        this.imobileEntitate = imobileEntity;
    }
}
