package com.sda.practical.handler;


import com.sda.practical.enums.MenuTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewHandler {

    private Map<MenuTypeEnum, List<String>> myMenues;


    public ViewHandler() {

        this.myMenues = new HashMap<>();

        myMenues.put(MenuTypeEnum.MAIN_MENU, new ArrayList<>());
        myMenues.get(MenuTypeEnum.MAIN_MENU).add("1. Log In.");
        myMenues.get(MenuTypeEnum.MAIN_MENU).add("2. Create account.");
        myMenues.get(MenuTypeEnum.MAIN_MENU).add("3. Log Out.");

        myMenues.put(MenuTypeEnum.USER_TYPE, new ArrayList<>());
        myMenues.get(MenuTypeEnum.USER_TYPE).add("1. Cumparator");
        myMenues.get(MenuTypeEnum.USER_TYPE).add("2. Vanzator");

        myMenues.put(MenuTypeEnum.SEARCH_MENU, new ArrayList<>());
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("1. Cauta dupa pret : ");
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("2. Cauta dupa tip locuinta : ");
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("3. Cauta dupa suprafata : ");
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("4. Cauta dupa etaj : ");
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("5. Cauta dupa numar camere : ");
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("6. Cauta dupa zona : ");
        myMenues.get(MenuTypeEnum.SEARCH_MENU).add("7. Cauta dupa an constructie : ");

        myMenues.put(MenuTypeEnum.ORDER_MENU, new ArrayList<>());
        myMenues.get(MenuTypeEnum.ORDER_MENU).add("1. Ascendent dupa pret.");
        myMenues.get(MenuTypeEnum.ORDER_MENU).add("2. Descendent dupa pret.");
        myMenues.get(MenuTypeEnum.ORDER_MENU).add("3. Imobile de vanzare.");
        myMenues.get(MenuTypeEnum.ORDER_MENU).add("4. Imobile de inchiriat.");
        myMenues.get(MenuTypeEnum.ORDER_MENU).add("5. Ascendent dupa suprafata.");
        myMenues.get(MenuTypeEnum.ORDER_MENU).add("6. Descendent dupa suprafata.");


        myMenues.put(MenuTypeEnum.CLIENT_USER, new ArrayList<>());
        myMenues.get(MenuTypeEnum.CLIENT_USER).add("1.Cauta imobil");
        myMenues.get(MenuTypeEnum.CLIENT_USER).add("2.Inchiriaza imobil");
        myMenues.get(MenuTypeEnum.CLIENT_USER).add("3.Cumpara imobil");
        myMenues.get(MenuTypeEnum.CLIENT_USER).add("4.Prezinta Lista Favorite");
        myMenues.get(MenuTypeEnum.CLIENT_USER).add("5.Adauga la Favorit");
        myMenues.get(MenuTypeEnum.CLIENT_USER).add("6.Sterge de la Favorit");

    }

    public void printMenu(MenuTypeEnum typeEnum) {
        for (String meniu : myMenues.get(typeEnum)) {
            System.out.println(meniu);
        }
    }


}
