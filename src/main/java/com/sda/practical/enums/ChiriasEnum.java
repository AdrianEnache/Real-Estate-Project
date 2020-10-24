package com.sda.practical.enums;

public enum ChiriasEnum {

    UNKNOWN(0),
    INCHIRIAZA_IMOBIL(1);

    private Integer option;

    ChiriasEnum(Integer option) {
        this.option = option;
    }

    public static ChiriasEnum getEnum(Integer option) {
        for (ChiriasEnum chiriasEnum : ChiriasEnum.values()) {
            if (chiriasEnum.option == option) {
                return chiriasEnum;
            }
        }
        return UNKNOWN;
    }
}
