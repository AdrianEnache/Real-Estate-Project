package com.sda.practical.entities.imobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class CurrencyEntity {

    @Id
    private Integer idCurrencyEntity;
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
