package com.sda.practical.entities.imobile;

import com.sda.practical.entities.users.UtilizatorEntitate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table

public class ImobileEntitate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipImobilEntitate;
    @Temporal(TemporalType.DATE)
    private Date dataPostariiAnuntului;
    private Double suprafata; //filtru 1
    private Double pret;//filtru 2
    @Column(nullable = false)
    private String etaj;//filtru 3
    private Integer anConstructie;//filtru 4
    private Integer numarCamere;//filtru 5
    private String coordonate;
    private String descriere;

    @ManyToMany(mappedBy = "favorite")
    private Set<UtilizatorEntitate> utilizatori = new HashSet<UtilizatorEntitate>();

    @ManyToOne
    @JoinColumn(name = "idTipImobil")
    private ImobilTypeEntity tipImobil;

    @ManyToOne
    @JoinColumn(name = "idVanzator")
    private UtilizatorEntitate utilizatorEntitate;

    @ManyToOne
    @JoinColumn(name = "anuntStatus")
    private AnuntStatusEntitate anuntStatusEntity;

    @ManyToOne
    @JoinColumn(name = "idTipCompartimentare")
    private CompartimentareEntitate compartimentareEntity;

    @ManyToOne
    @JoinColumn(name = "idTipValuta")
    private ValutaEntitate valutaEntitate;

    @ManyToOne
    @JoinColumn(name = "idOras")
    private OrasEntitate orasEntitate;



    public UtilizatorEntitate getUtilizatorEntitate() {
        return utilizatorEntitate;
    }

    public void setUtilizatorEntitate(UtilizatorEntitate utilizatorEntitate) {
        this.utilizatorEntitate = utilizatorEntitate;
    }

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

    public ValutaEntitate getValutaEntitate() {
        return valutaEntitate;
    }

    public void setValutaEntitate(ValutaEntitate valutaEntitate) {
        this.valutaEntitate = valutaEntitate;
    }

    public OrasEntitate getOrasEntitate() {
        return orasEntitate;
    }

    public void setOrasEntitate(OrasEntitate orasEntitate) {
        this.orasEntitate = orasEntitate;
    }

    public String getEtaj() {
        return etaj;
    }

    public void setEtaj(String etaj) {
        this.etaj = etaj;
    }

    public ImobilTypeEntity getTipImobil() {
        return tipImobil;
    }

    public void setTipImobil(ImobilTypeEntity tipImobil) {
        this.tipImobil = tipImobil;
    }

    public Set<UtilizatorEntitate> getUtilizatori() {
        return utilizatori;
    }

    public void setUtilizatori(Set<UtilizatorEntitate> utilizatori) {
        this.utilizatori = utilizatori;
    }
}
