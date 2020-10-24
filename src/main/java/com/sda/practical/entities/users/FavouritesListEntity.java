package com.sda.practical.entities.users;

public class FavouritesListEntity {
    private Integer favouriteId;
    private Integer userId;
    private Integer imobilId;

    public Integer getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(Integer favouriteId) {
        this.favouriteId = favouriteId;
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
