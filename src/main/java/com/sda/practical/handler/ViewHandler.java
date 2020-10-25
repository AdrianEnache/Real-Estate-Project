package com.sda.practical.handler;

import com.sda.practical.enums.TipMeniuEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewHandler {

    private Map<TipMeniuEnum, List<String>> myMenues;

    public ViewHandler() {

        this.myMenues = new HashMap<>();

<<<<<<< HEAD
        myMenues.put(TipMeniuEnum.MENIU_PRINCIPAL, new ArrayList<>());
        myMenues.get(TipMeniuEnum.MENIU_PRINCIPAL).add("1. Log In.");
        myMenues.get(TipMeniuEnum.MENIU_PRINCIPAL).add("2. Log Out.");
=======
        myMenues.put(MenuTypeEnum.MAIN_MENU, new ArrayList<>());
        myMenues.get(MenuTypeEnum.MAIN_MENU).add("1. Log In.");
        myMenues.get(MenuTypeEnum.MAIN_MENU).add("2. Create account.");
        myMenues.get(MenuTypeEnum.MAIN_MENU).add("3. Log Out.");
>>>>>>> be9ba83da591d9d7c8642459b3ffb24b186b10ff

        myMenues.put(TipMeniuEnum.MENIU_CAUTARE, new ArrayList<>());
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("1. Cauta dupa pret : ");
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("2. Cauta dupa tip locuinta : ");
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("3. Cauta dupa suprafata : ");
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("4. Cauta dupa etaj : ");
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("5. Cauta dupa numar camere : ");
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("6. Cauta dupa zona : ");
        myMenues.get(TipMeniuEnum.MENIU_CAUTARE).add("7. Cauta dupa an constructie : ");

        myMenues.put(TipMeniuEnum.MENIU_ORDINE, new ArrayList<>());
        myMenues.get(TipMeniuEnum.MENIU_ORDINE).add("1. Ascendent dupa pret.");
        myMenues.get(TipMeniuEnum.MENIU_ORDINE).add("2. Descendent dupa pret.");
        myMenues.get(TipMeniuEnum.MENIU_ORDINE).add("3. Imobile de vanzare.");
        myMenues.get(TipMeniuEnum.MENIU_ORDINE).add("4. Imobile de inchiriat.");
        myMenues.get(TipMeniuEnum.MENIU_ORDINE).add("5. Ascendent dupa suprafata.");
        myMenues.get(TipMeniuEnum.MENIU_ORDINE).add("6. Descendent dupa suprafata.");


    }

    public void printMenu(TipMeniuEnum typeEnum) {
        for (String meniu : myMenues.get(typeEnum)) {
            System.out.println(meniu);
        }
    }

}
