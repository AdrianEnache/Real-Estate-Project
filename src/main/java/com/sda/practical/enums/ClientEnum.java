package com.sda.practical.enums;

public enum ClientEnum {


    NECUNOSCUT(0),
    INCHIRIAZA_IMOBIL(1),
    CUMPARA_IMOBIL(2);

    private Integer option;

    ClientEnum(Integer option) {
        this.option = option;
    }

    public static ClientEnum getEnum(Integer option) {
        for (ClientEnum clientEnum : ClientEnum.values()) {
            if (clientEnum.option == option) {
                return clientEnum;
            }
        }
        return NECUNOSCUT;
    }


}
