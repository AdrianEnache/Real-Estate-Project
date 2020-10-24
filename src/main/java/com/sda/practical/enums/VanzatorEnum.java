package com.sda.practical.enums;


public enum VanzatorEnum {

    UNKNOWN(0),
    ADAUGA_IMOBIL(1),
    VINDE_IMOBIL(2),
    STERGE_IMOBIL(3);

    private Integer option;

    VanzatorEnum(Integer option) {
        this.option = option;
    }

    public static VanzatorEnum getEnum(Integer option) {
        for (VanzatorEnum vanzatorEnum : VanzatorEnum.values()) {
            if (vanzatorEnum.option == option) {
                return vanzatorEnum;
            }
        }
        return UNKNOWN;
    }
}
