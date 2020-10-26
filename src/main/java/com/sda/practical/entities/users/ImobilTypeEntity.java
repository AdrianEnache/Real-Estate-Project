package com.sda.practical.entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ImobilTypeEntity {

    @Id
    private Integer idImobilTypeEntity;
    private String land;
    private String house;
    private String apartment;

    public Integer getIdImobilTypeEntity() {
        return idImobilTypeEntity;
    }

    public void setIdImobilTypeEntity(Integer idImobilTypeEntity) {
        this.idImobilTypeEntity = idImobilTypeEntity;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
