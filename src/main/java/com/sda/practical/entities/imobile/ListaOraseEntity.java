package com.sda.practical.entities.imobile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Entity
@Table

public class ListaOraseEntity {

    @Id
    @Column(columnDefinition = "ID ListaOrase")
    private Integer idListaOraseEntity;
    @Column(columnDefinition = "Orase")
    private Map<String, List<String>> myCities;

    public Integer getIdListaOraseEntity() {
        return idListaOraseEntity;
    }

    public void setIdListaOraseEntity(Integer idListaOraseEntity) {
        this.idListaOraseEntity = idListaOraseEntity;
    }

    public Map<String, List<String>> getMyCities() {
        return myCities;
    }

    public void setMyCities(Map<String, List<String>> myCities) {
        this.myCities = myCities;
    }
}
