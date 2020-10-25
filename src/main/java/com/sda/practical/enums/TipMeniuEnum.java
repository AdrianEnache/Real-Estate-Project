package com.sda.practical.enums;

public enum TipMeniuEnum {

    //TODO log in si log out - done

    NECUNOSCUT(0),
    MENIU_PRINCIPAL(1),
    MENIU_CAUTARE(2),
    MENIU_ORDINE(3);

    private Integer option;

    TipMeniuEnum(Integer option) {
        this.option = option;
    }

    public static TipMeniuEnum getEnum(Integer option) {
        for (TipMeniuEnum menuTypeEnum : TipMeniuEnum.values()) {
            if (menuTypeEnum.option == option) {
                return menuTypeEnum;
            }
        }
        return NECUNOSCUT;
    }

}
