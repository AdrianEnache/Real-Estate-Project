package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class AnuntStatusEntitate {

    @Id
    private Integer idAnuntStatusEntitate;
    private String statusAnunt;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntitate")
    private ImobileEntitate imobileEntitate;

    public Integer getIdAnuntStatusEntitate() {
        return idAnuntStatusEntitate;
    }

    public void setIdAnuntStatusEntitate(Integer idAnuntStatusEntitate) {
        this.idAnuntStatusEntitate = idAnuntStatusEntitate;
    }

    public ImobileEntitate getImobileEntitate() {
        return imobileEntitate;
    }

    public void setImobileEntitate(ImobileEntitate imobileEntitate) {
        this.imobileEntitate = imobileEntitate;
    }

    public String getStatusAnunt() {
        return statusAnunt;
    }

    public void setStatusAnunt(String statusAnunt) {
        this.statusAnunt = statusAnunt;
    }

    public ImobileEntitate getImobileEntity() {
        return imobileEntitate;
    }

    public void setImobileEntity(ImobileEntitate imobileEntity) {
        this.imobileEntitate = imobileEntity;
    }


}
