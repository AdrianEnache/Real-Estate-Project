package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class AnuntStatusEntitate {

    @Id
    private Integer idAnuntStatusEntitate;
    private Boolean sters;
    private Boolean vandut;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntitate")
    private ImobileEntitate imobileEntitate;

    public Integer getIdAnuntStatusEntitate() {
        return idAnuntStatusEntitate;
    }

    public void setIdAnuntStatusEntitate(Integer idAnuntStatusEntitate) {
        this.idAnuntStatusEntitate = idAnuntStatusEntitate;
    }

    public Boolean getSters() {
        return sters;
    }

    public void setSters(Boolean sters) {
        this.sters = sters;
    }

    public Boolean getVandut() {
        return vandut;
    }

    public void setVandut(Boolean vandut) {
        this.vandut = vandut;
    }

    public ImobileEntitate getImobileEntity() {
        return imobileEntitate;
    }

    public void setImobileEntity(ImobileEntitate imobileEntity) {
        this.imobileEntitate = imobileEntity;
    }


}
