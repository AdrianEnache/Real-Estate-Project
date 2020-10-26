package com.sda.practical.entities.imobile;

import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table

public class ImobileEntitate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "ID Imobil")
    private Integer idTipImobilEntitate;
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

    @OneToOne(mappedBy = "imobileEntitate")
    private AnuntStatusEntitate anuntStatusEntity;

    @OneToOne(mappedBy = "imobileEntitate")
    private CompartimentareEntitate compartimentareEntity;

    @OneToMany(mappedBy = "imobileEntitate")
    private List<ValutaEntitate> currencyEntities;

    @ManyToOne
    @JoinColumn (name = "idListaOraseEntity")
    private OrasEntitate orasEntity;

    public Integer getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(Integer anConstructie) {
        this.anConstructie = anConstructie;
    }

    public AnuntStatusEntitate getAnuntStatusEntity() {
        return anuntStatusEntity;
    }

    public void setAnuntStatusEntity(AnuntStatusEntitate anuntStatusEntity) {
        this.anuntStatusEntity = anuntStatusEntity;
    }

    public Date getDataPostariiAnuntului() {
        return dataPostariiAnuntului;
    }

    public void setDataPostariiAnuntului(Date dataPostariiAnuntului) {
        this.dataPostariiAnuntului = dataPostariiAnuntului;
    }

    public Integer getIdTipImobilEntitate() {
        return idTipImobilEntitate;
    }

    public void setIdTipImobilEntitate(Integer idTipImobilEntitate) {
        this.idTipImobilEntitate = idTipImobilEntitate;
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

    public CompartimentareEntitate getCompartimentareEntity() {
        return compartimentareEntity;
    }

    public void setCompartimentareEntity(CompartimentareEntitate compartimentareEntity) {
        this.compartimentareEntity = compartimentareEntity;
    }

    public List<ValutaEntitate> getCurrencyEntities() {
        return currencyEntities;
    }

    public void setCurrencyEntities(List<ValutaEntitate> currencyEntities) {
        this.currencyEntities = currencyEntities;
    }

    public OrasEntitate getOrasEntity() {
        return orasEntity;
    }

    public void setOrasEntity(OrasEntitate orasEntity) {
        this.orasEntity = orasEntity;
    }
}
