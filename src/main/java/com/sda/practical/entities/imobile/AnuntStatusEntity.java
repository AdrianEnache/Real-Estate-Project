package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class AnuntStatusEntity {

    @Id
    @Column(columnDefinition = "ID StatusAnunt")
    private Integer idAnuntStatusEntity;
    @Column(columnDefinition = "Deleted")
    private Boolean deleted;
    @Column(columnDefinition = "Sold")
    private Boolean sold;

    @OneToOne
    @JoinColumn(name = "idTipImobilEntity")
    private ImobileEntity imobileEntity;

    public Integer getIdAnuntStatusEntity() {
        return idAnuntStatusEntity;
    }

    public void setIdAnuntStatusEntity(Integer idAnuntStatusEntity) {
        this.idAnuntStatusEntity = idAnuntStatusEntity;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }
    public ImobileEntity getImobileEntity() {
        return imobileEntity;
    }

    public void setImobileEntity(ImobileEntity imobileEntity) {
        this.imobileEntity = imobileEntity;
    }


}
