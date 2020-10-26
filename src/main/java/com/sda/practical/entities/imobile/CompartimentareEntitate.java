package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class CompartimentareEntitate {

    @Id
    private Integer idCompartimentareEntitate;
    private String compartimentare;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntitate")
    private ImobileEntitate imobileEntitate;

    public Integer getIdCompartimentareEntitate() {
        return idCompartimentareEntitate;
    }

    public void setIdCompartimentareEntitate(Integer idCompartimentareEntitate) {
        this.idCompartimentareEntitate = idCompartimentareEntitate;
    }

    public String getCompartimentare() {
        return compartimentare;
    }

    public void setCompartimentare(String compartimentare) {
        this.compartimentare = compartimentare;
    }

    public ImobileEntitate getImobileEntity() {
        return imobileEntitate;
    }

    public void setImobileEntity(ImobileEntitate imobileEntity) {
        this.imobileEntitate = imobileEntity;
    }
}
