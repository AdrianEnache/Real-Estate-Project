package com.sda.practical.entities.users;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class FavouritesListEntity {
    private Integer favouritesListEntityId;
    private Integer userId;
    private Integer imobilId;

    @OneToOne ()
    public Integer getFavouritesListEntityId() {
        return favouritesListEntityId;
    }

    public void setFavouritesListEntityId(Integer favouritesListEntityId) {
        this.favouritesListEntityId = favouritesListEntityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getImobilId() {
        return imobilId;
    }

    public void setImobilId(Integer imobilId) {
        this.imobilId = imobilId;
    }
}
