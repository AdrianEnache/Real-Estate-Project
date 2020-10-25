package com.sda.practical.entities.imobile;

import javax.persistence.*;

@Entity
@Table

public class CurrencyEntity {

    @Id
    @Column(columnDefinition = "ID Currency")
    private Integer idCurrencyEntity;
    @Column(columnDefinition = "Currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "idTipImobilEntity")
    private ImobileEntity imobileEntity;

    public Integer getIdCurrencyEntity() {
        return idCurrencyEntity;
    }

    public void setIdCurrencyEntity(Integer idCurrencyEntity) {
        this.idCurrencyEntity = idCurrencyEntity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ImobileEntity getImobileEntity() {
        return imobileEntity;
    }

    public void setImobileEntity(ImobileEntity imobileEntity) {
        this.imobileEntity = imobileEntity;
    }
}
