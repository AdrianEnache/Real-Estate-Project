package com.sda.practical.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class ImobilTypeEntity {
    @Id
    private String idImobilTypeEntity;
    @Column(name = "Teren")
    private String land;
    @Column(name = "Casa")
    private String house;
    @Column(name = "Apartament")
    private String apartment;

    public String getIdImobilTypeEntity() {
        return idImobilTypeEntity;
    }

    public void setIdImobilTypeEntity(String idImobilTypeEntity) {
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
