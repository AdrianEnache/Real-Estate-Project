package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table

public class OrasEntity {

    @Id
    @Column(columnDefinition = "ID ListaOrase")
    private Integer idListaOraseEntity;
    @Column(columnDefinition = "Orase")
    private String oras;

    @OneToMany(mappedBy = "orasEntity")
    private List<ImobileEntity> imobileEntities;

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }


    public Integer getIdListaOraseEntity() {
        return idListaOraseEntity;
    }

    public void setIdListaOraseEntity(Integer idListaOraseEntity) {
        this.idListaOraseEntity = idListaOraseEntity;
    }

    public List<ImobileEntity> getImobileEntities() {
        return imobileEntities;
    }

    public void setImobileEntities(List<ImobileEntity> imobileEntities) {
        this.imobileEntities = imobileEntities;
    }
}
