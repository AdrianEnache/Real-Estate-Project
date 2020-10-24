package com.sda.practical.enums;

public enum CumparatorEnum {


    UNKNOWN(0),
    CUMPARA_IMOBIL(1);

    private Integer option;

    CumparatorEnum(Integer option) {
        this.option = option;
    }

    public static CumparatorEnum getEnum(Integer option) {
        for (CumparatorEnum cumparatorEnum : CumparatorEnum.values()) {
            if (cumparatorEnum.option == option) {
                return cumparatorEnum;
            }
        }
        return UNKNOWN;
    }


}
