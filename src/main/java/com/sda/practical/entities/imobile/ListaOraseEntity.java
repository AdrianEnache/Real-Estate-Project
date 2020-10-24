package com.sda.practical.entities.imobile;

import java.util.List;
import java.util.Map;

public class ListaOraseEntity {

    private Integer idListaOraseEntity;

    public Integer getIdListaOraseEntity() {
        return idListaOraseEntity;
    }

    public void setIdListaOraseEntity(Integer idListaOraseEntity) {
        this.idListaOraseEntity = idListaOraseEntity;
    }

    private Map<String, List<String>> myCities;

    public Map<String, List<String>> getMyCities() {
        return myCities;
    }

    public void setMyCities(Map<String, List<String>> myCities) {
        this.myCities = myCities;
    }
}
