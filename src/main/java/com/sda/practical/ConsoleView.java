package com.sda.practical;

import com.mysql.cj.xdevapi.SessionFactory;
import com.sda.practical.enums.TipMeniuEnum;
import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.handler.KeyboardHandler;
import com.sda.practical.handler.ViewHandler;

public class ConsoleView {

    public void startApp() {
        ViewHandler viewHandler = new ViewHandler();
        KeyboardHandler keyboardHandler = new KeyboardHandler();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        SessionFactory sessionFactory = new SessionFactory();


        Integer option = 0;
        while (option != 0) {
            viewHandler.printMenu(TipMeniuEnum.MENIU_PRINCIPAL);
            option = keyboardHandler.readInteger("Introduceti optiunea : ");

        }
        switch (option) {
            case 1:
            case 2:
            case 3:
            case 4:
        }

        public static void


    }
}
