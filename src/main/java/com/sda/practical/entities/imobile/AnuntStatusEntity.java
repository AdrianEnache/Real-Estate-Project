package com.sda.practical.entities.imobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class AnuntStatusEntity {

    @Id
    private Integer idAnuntStatusEntity;
    private Boolean deleted;
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
