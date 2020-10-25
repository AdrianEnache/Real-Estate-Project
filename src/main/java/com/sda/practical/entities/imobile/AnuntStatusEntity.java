package com.sda.practical.entities.imobile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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


}
