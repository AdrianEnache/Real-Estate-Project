package com.sda.practical.entities.imobile;

import javax.persistence.OneToOne;
import java.util.Date;

public class ImobilEntity {

    private Integer idTipImobilEntity;

    public Integer getIdTipImobilEntity() {
        return idTipImobilEntity;
    }

    public void setIdTipImobilEntity(Integer idTipImobilEntity) {
        this.idTipImobilEntity = idTipImobilEntity;
    }

    private Date dataPostariiAnuntului;
    private Double suprafata;
    private Double pret;
    private Integer Etaj;
    private Integer anConstructii;
    private Integer numarCamere;
    private String coordonate;
    private String descriere;

    @OneToOne
    private ListaOraseEntity oras;

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

    public Integer getEtaj() {
        return Etaj;
    }

    public void setEtaj(Integer etaj) {
        Etaj = etaj;
    }

    public Integer getAnConstructii() {
        return anConstructii;
    }

    public void setAnConstructii(Integer anConstructii) {
        this.anConstructii = anConstructii;
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
}
