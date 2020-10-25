package com.sda.practical.entities.imobile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class CompartimentareEntity {

    @Id
    @Column(columnDefinition = "ID Compartimentare")
    private Integer idCompartimentareEntity;
    @Column(columnDefinition = "Compartimentare")
    private String compartimentare;

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
}
