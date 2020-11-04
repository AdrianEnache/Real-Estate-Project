package com.sda.practical.entities.imobile;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table

public class OrasEntitate {

    @Id
    private Integer idOras;
    private String numeOras;

    @OneToMany(mappedBy = "orasEntitate")
    private List<ImobileEntitate> imobileEntitateList;

    public String getNumeOras() {
        return numeOras;
    }

    public void setNumeOras(String numeOras) {
        this.numeOras = numeOras;
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
