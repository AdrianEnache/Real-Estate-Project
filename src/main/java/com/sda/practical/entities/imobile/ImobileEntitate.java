package com.sda.practical.entities.imobile;

import com.sda.practical.entities.users.UtilizatorEntitate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table

public class ImobileEntitate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipImobilEntitate;
    @Temporal(TemporalType.DATE)
    private Date dataPostariiAnuntului;
    private Double suprafata;
    private Double pret;
    @Column(nullable = false)
    private String etaj;
    private Integer anConstructie;
    private Integer numarCamere;
    private String coordonate;
    private String descriere;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipImobil")
    private ImobilTypeEntity tipImobil;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idVanzator")
    private UtilizatorEntitate utilizatorEntitate;

    @OneToOne(mappedBy = "imobileEntitate")
    private AnuntStatusEntitate anuntStatusEntity;

    @OneToOne(mappedBy = "imobileEntitate")
    private CompartimentareEntitate compartimentareEntity;

    @OneToMany(mappedBy = "imobileEntitate")
    private List<ValutaEntitate> valutaEntitate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public List<ValutaEntitate> getValutaEntitate() {
        return valutaEntitate;
    }

    public void setValutaEntitate(List<ValutaEntitate> valutaEntitate) {
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

    @Override
    public String toString() {
        return "Imobil : [" +
                "ID Imobil = " + idTipImobilEntitate +
                ", Data postarii anunt = " + dataPostariiAnuntului +
                ", Suprafata = " + suprafata +
                ", Pret = " + pret +
                ", Etaj = " + etaj +
                ", An constructie = " + anConstructie +
                ", Numar camere = " + numarCamere +
                ", Coordonate = '" + coordonate + '\'' +
                ", Descriere = '" + descriere + '\'' +
                ']';

    }
}
