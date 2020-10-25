package com.sda.practical.entities.imobile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class CurrencyEntity {

    @Id
    @Column(columnDefinition = "ID Currency")
    private Integer idCurrencyEntity;
    @Column(columnDefinition = "Currency")
    private String currency;

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
}
