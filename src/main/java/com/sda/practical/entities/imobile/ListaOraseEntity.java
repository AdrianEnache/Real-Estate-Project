package com.sda.practical.entities.imobile;

import java.util.List;
import java.util.Map;

public class ListaOraseEntity {

    private Integer idListaOraseEntity;
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

//    private Map<String, List<String>> myCities;
//
//    public Map<String, List<String>> getMyCities() {
//        return myCities;
//    }

    public void setMyCities(Map<String, List<String>> myCities) {
        this.myCities = myCities;
    }
}
