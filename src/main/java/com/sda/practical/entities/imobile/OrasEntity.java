package com.sda.practical.entities.imobile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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


}
