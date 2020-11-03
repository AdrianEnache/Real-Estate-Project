package com.sda.practical.entities.imobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table

public class ImobilTypeEntity {

    @Id
    private Integer idImobilTypeEntity;
    private String tipImobil;
    private Integer idTipImobil;


    @OneToMany(mappedBy = "tipImobil")
    private List<ImobileEntitate> imobileEntitates;

    //TODO - de normalizat


    public Integer getIdImobilTypeEntity() {
        return idImobilTypeEntity;
    }

    public void setIdImobilTypeEntity(Integer idImobilTypeEntity) {
        this.idImobilTypeEntity = idImobilTypeEntity;
    }

    public String getTipImobil() {
        return tipImobil;
    }

    public void setTipImobil(String tipImobil) {
        this.tipImobil = tipImobil;
    }

    public Integer getIdTipImobil() {
        return idTipImobil;
    }

    public void setIdTipImobil(Integer idTipImobil) {
        this.idTipImobil = idTipImobil;
    }

    public List<ImobileEntitate> getImobileEntitates() {
        return imobileEntitates;
    }

    public void setImobileEntitates(List<ImobileEntitate> imobileEntitates) {
        this.imobileEntitates = imobileEntitates;
    }
}
