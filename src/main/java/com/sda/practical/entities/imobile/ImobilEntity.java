package com.sda.practical.entities.imobile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table

public class ImobilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipImobilEntity;
    @Column(columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date dataPostariiAnuntului;
    private Double suprafata;
    private Double pret;
    private Integer etaj;
    private Integer anConstructie;
    private Integer numarCamere;
    @Column(length = 45)
    private String coordonate;
    @Column(length = 250)
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
