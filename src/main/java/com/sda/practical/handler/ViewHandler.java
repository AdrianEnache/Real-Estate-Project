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
        myMenues.put(MenuTypeEnum.MAIN_MENU,new ArrayList<>());
        myMenues.put(MenuTypeEnum.SEARCH_MENU,new ArrayList<>());



    }

    public void printMenu(MenuTypeEnum typeEnum) {
        for (String meniu : myMenues.get(typeEnum)) {
            System.out.println(meniu);
        }
    }

}
