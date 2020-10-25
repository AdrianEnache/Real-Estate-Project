package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class ValutaEntitate {

    @Id
    @Column(columnDefinition = "ID Currency")
    private Integer idValutateEntitate;
    @Column(columnDefinition = "Currency")
    private String valuta;

    @ManyToOne
    @JoinColumn(name = "idTipImobilEntity")
    private ImobileEntitate imobileEntitate;

    public Integer getIdValutateEntitate() {
        return idValutateEntitate;
    }

    public void setIdValutateEntitate(Integer idValutateEntitate) {
        this.idValutateEntitate = idValutateEntitate;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public ImobileEntitate getImobileEntitate() {
        return imobileEntitate;
    }

    public void setImobileEntitate(ImobileEntitate imobileEntitate) {
        this.imobileEntitate = imobileEntitate;
    }
}
