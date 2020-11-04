package com.sda.practical.models;


import java.util.Date;

public class ImobilModel {

    private Integer idTipImobilEntity;
    private Date dataPostariiAnuntului;
    private Double suprafata;
    private Double pret;
    private String etaj;
    private Integer anConstructie;
    private Integer numarCamere;
    private String coordonate;
    private String descriere;
    private Integer idAnuntStatusEntity;
    private Integer idCompartimentareEntity;
    private Integer idCurrencyEntity;
    private Integer idOras;
    private Integer idVanzator;
    private Integer idTipImobil;

    public Integer getIdVanzator() {
        return idVanzator;
    }

    public void setIdVanzator(Integer idVanzator) {
        this.idVanzator = idVanzator;
    }

    public Integer getIdTipImobilEntity() {
        return idTipImobilEntity;
    }

    public void setIdTipImobilEntity(Integer idTipImobilEntity) {
        this.idTipImobilEntity = idTipImobilEntity;
    }

    public Integer getIdAnuntStatusEntity() {
        return idAnuntStatusEntity;
    }

    public void setIdAnuntStatusEntity(Integer idAnuntStatusEntity) {
        this.idAnuntStatusEntity = idAnuntStatusEntity;
    }

    public Integer getIdCompartimentareEntity() {
        return idCompartimentareEntity;
    }

    public void setIdCompartimentareEntity(Integer idCompartimentareEntity) {
        this.idCompartimentareEntity = idCompartimentareEntity;
    }

    public Integer getIdCurrencyEntity() {
        return idCurrencyEntity;
    }

    public void setIdCurrencyEntity(Integer idCurrencyEntity) {
        this.idCurrencyEntity = idCurrencyEntity;
    }

    public Integer getIdOras() {
        return idOras;
    }

    public void setIdOras(Integer idOras) {
        this.idOras = idOras;
    }

    public Date getDataPostariiAnuntului() {
        return dataPostariiAnuntului;
    }

    public void setDataPostariiAnuntului(Date dataPostariiAnuntului) {
        this.dataPostariiAnuntului = dataPostariiAnuntului;
    }

    public Double getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(Double suprafata) {
        this.suprafata = suprafata;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public String getEtaj() {
        return etaj;
    }

    public void setEtaj(String etaj) {
        this.etaj = etaj;
    }

    public Integer getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(Integer anConstructie) {
        this.anConstructie = anConstructie;
    }

    public Integer getNumarCamere() {
        return numarCamere;
    }

    public void setNumarCamere(Integer numarCamere) {
        this.numarCamere = numarCamere;
    }

    public String getCoordonate() {
        return coordonate;
    }

    public void setCoordonate(String coordonate) {
        this.coordonate = coordonate;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Integer getIdTipImobil() {
        return idTipImobil;
    }

    public void setIdTipImobil(Integer idTipImobil) {
        this.idTipImobil = idTipImobil;
    }
}
