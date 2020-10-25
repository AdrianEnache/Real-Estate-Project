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
<<<<<<< HEAD:src/main/java/com/sda/practical/entities/imobile/ListaOraseEntity.java
    private String oras;

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }
=======
    @Column(columnDefinition = "Orase")
    private String oras;
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61:src/main/java/com/sda/practical/entities/imobile/OrasEnitity.java

    public Integer getIdListaOraseEntity() {
        return idListaOraseEntity;
    }

    public void setIdListaOraseEntity(Integer idListaOraseEntity) {
        this.idListaOraseEntity = idListaOraseEntity;
    }

<<<<<<< HEAD:src/main/java/com/sda/practical/entities/imobile/ListaOraseEntity.java
//    private Map<String, List<String>> myCities;
//
//    public Map<String, List<String>> getMyCities() {
//        return myCities;
//    }
=======
    public String getMyCities() {
        return oras;
    }
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61:src/main/java/com/sda/practical/entities/imobile/OrasEnitity.java

    public void setMyCities(Map<String, List<String>> myCities) {
        this.oras = oras;
    }
}
