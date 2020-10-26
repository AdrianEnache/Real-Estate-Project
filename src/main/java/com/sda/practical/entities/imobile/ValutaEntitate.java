package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class ValutaEntitate {

    @Id
    private Integer idValutateEntitate;
    private String valuta;

    @ManyToOne
    @JoinColumn(name = "idTipImobilEntitate")
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
