package com.sda.practical.entities.imobile;

public class AnuntStatusEntity {

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
