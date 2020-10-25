package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table

public class ImobileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "ID Imobil")
    private Integer idTipImobilEntity;
    @Column(columnDefinition = "Posted Date")
    @Temporal(TemporalType.DATE)
    private Date dataPostariiAnuntului;
    @Column(columnDefinition = "Suprafata imobil")
    private Double suprafata;
    @Column(columnDefinition = "Pret imobil")
    private Double pret;
    @Column(columnDefinition = "Etaj imobil")
    private Integer etaj;
    @Column(columnDefinition = "An constructie")
    private Integer anConstructie;
    @Column(columnDefinition = "Numar camere")
    private Integer numarCamere;
    @Column(length = 45, columnDefinition = "Coordonate")
    private String coordonate;
    @Column(length = 250, columnDefinition = "Descriere")
    private String descriere;

    public Date getDataPostariiAnuntului() {
        return dataPostariiAnuntului;
    }

    public void setDataPostariiAnuntului(Date dataPostariiAnuntului) {
        this.dataPostariiAnuntului = dataPostariiAnuntului;
    }

    public Integer getIdTipImobilEntity() {
        return idTipImobilEntity;
    }

    public void setIdTipImobilEntity(Integer idTipImobilEntity) {
        this.idTipImobilEntity = idTipImobilEntity;
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
        return etaj;
    }

    public void setEtaj(Integer etaj) {
        etaj = etaj;
    }

    public Integer getAnConstructii() {
        return anConstructie;
    }

    public void setAnConstructii(Integer anConstructii) {
        this.anConstructie = anConstructii;
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
