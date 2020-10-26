package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class AnuntStatusEntitate {

    @Id
    @Column(columnDefinition = "ID StatusAnunt")
    private Integer idAnuntStatusEntitate;
    @Column(columnDefinition = "Deleted")
    private Boolean sters;
    @Column(columnDefinition = "Sold")
    private Boolean vandut;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntity")
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
