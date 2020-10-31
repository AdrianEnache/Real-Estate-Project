package com.sda.practical.enums;

public enum MenuTypeEnum {

    //TODO log in si log out - done

    UNKNOWN(0),
    MAIN_MENU(1),
    SEARCH_MENU(2),
    ORDER_MENU(3),
    USER_TYPE(4),
    CLIENT_USER(5),
    VANZATOR_USER(6);


    private Integer option;

    MenuTypeEnum(Integer option) {
        this.option = option;
    }

    public static MenuTypeEnum getEnum(Integer option) {
        for (MenuTypeEnum menuTypeEnum : MenuTypeEnum.values()) {
            if (menuTypeEnum.option == option) {
                return menuTypeEnum;
            }
        }
        return UNKNOWN;
    }

}
