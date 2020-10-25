package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class OrasEntitate {

    @Id
    @Column(columnDefinition = "ID ListaOrase")
    private Integer idOras;
    @Column(columnDefinition = "Orase")
    private String oras;

    @OneToMany(mappedBy = "orasEntity")
    private List<ImobileEntitate> imobileEntities;

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

    public List<ImobileEntitate> getImobileEntities() {
        return imobileEntities;
    }

    public void setImobileEntities(List<ImobileEntitate> imobileEntities) {
        this.imobileEntities = imobileEntities;
    }
}
