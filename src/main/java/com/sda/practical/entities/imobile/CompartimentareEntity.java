package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class CompartimentareEntity {

    @Id
    @Column(columnDefinition = "ID Compartimentare")
    private Integer idCompartimentareEntity;
    @Column(columnDefinition = "Compartimentare")
    private String compartimentare;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntity")
    private ImobileEntity imobileEntity;

    public Integer getIdCompartimentareEntity() {
        return idCompartimentareEntity;
    }

    public void setIdCompartimentareEntity(Integer idCompartimentareEntity) {
        this.idCompartimentareEntity = idCompartimentareEntity;
    }

    public String getCompartimentare() {
        return compartimentare;
    }

    public void setCompartimentare(String compartimentare) {
        this.compartimentare = compartimentare;
    }

    public ImobileEntity getImobileEntity() {
        return imobileEntity;
    }

    public void setImobileEntity(ImobileEntity imobileEntity) {
        this.imobileEntity = imobileEntity;
    }
}
