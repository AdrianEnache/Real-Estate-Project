package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class OrasEntitate {

    @Id
    private Integer idOras;
    private String oras;

    @OneToMany(mappedBy = "orasEntitate")
    private List<ImobileEntitate> imobileEntitateList;

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }


    public Integer getIdOras() {
        return idOras;
    }

    public void setIdOras(Integer idOras) {
        this.idOras = idOras;
    }

    public List<ImobileEntitate> getImobileEntitateList() {
        return imobileEntitateList;
    }

    public void setImobileEntitateList(List<ImobileEntitate> imobileEntitateList) {
        this.imobileEntitateList = imobileEntitateList;
    }
}
