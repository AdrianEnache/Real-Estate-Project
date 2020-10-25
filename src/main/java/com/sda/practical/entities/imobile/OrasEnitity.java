package com.sda.practical.entities.imobile;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;
@Entity
@Table
public class OrasEnitity {
    @Id
    @Column(columnDefinition = "ID ListaOrase")
    private Integer idListaOraseEntity;
    @Column(columnDefinition = "Orase")
    private String oras;
    public Integer getIdListaOraseEntity() {
        return idListaOraseEntity;
    }
    public void setIdListaOraseEntity(Integer idListaOraseEntity) {
        this.idListaOraseEntity = idListaOraseEntity;
    }
    public String getMyCities() {
        return oras;
    }
    public void setMyCities(Map<String, List<String>> myCities) {
        this.oras = oras;
    }
}