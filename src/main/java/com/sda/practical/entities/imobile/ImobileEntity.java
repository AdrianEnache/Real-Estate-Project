package com.sda.practical.entities.imobile;

import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToOne(mappedBy = "imobileEntity")
    private AnuntStatusEntity anuntStatusEntity;

    @OneToOne(mappedBy = "imobileEntity")
    private CompartimentareEntity compartimentareEntity;

    @OneToMany(mappedBy = "imobileEntity")
    private List<CurrencyEntity> currencyEntities;

    @ManyToOne
    @JoinColumn (name = "idListaOraseEntity")
    private OrasEntity orasEntity;

    public Integer getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(Integer anConstructie) {
        this.anConstructie = anConstructie;
    }

    public AnuntStatusEntity getAnuntStatusEntity() {
        return anuntStatusEntity;
    }

    public void setAnuntStatusEntity(AnuntStatusEntity anuntStatusEntity) {
        this.anuntStatusEntity = anuntStatusEntity;
    }

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

    public CompartimentareEntity getCompartimentareEntity() {
        return compartimentareEntity;
    }

    public void setCompartimentareEntity(CompartimentareEntity compartimentareEntity) {
        this.compartimentareEntity = compartimentareEntity;
    }

    public List<CurrencyEntity> getCurrencyEntities() {
        return currencyEntities;
    }

    public void setCurrencyEntities(List<CurrencyEntity> currencyEntities) {
        this.currencyEntities = currencyEntities;
    }

    public OrasEntity getOrasEntity() {
        return orasEntity;
    }

    public void setOrasEntity(OrasEntity orasEntity) {
        this.orasEntity = orasEntity;
    }
}
