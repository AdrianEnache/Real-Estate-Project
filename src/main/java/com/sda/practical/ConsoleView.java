package com.sda.practical;

import com.mysql.cj.xdevapi.SessionFactory;
import com.sda.practical.entities.users.UserTypesEntity;
import com.sda.practical.enums.MenuTypeEnum;
import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.handler.KeyboardHandler;
import com.sda.practical.handler.ViewHandler;
import com.sda.practical.models.UserModel;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;

import java.awt.*;

public class ConsoleView {

    public void startApp() {
        ViewHandler viewHandler = new ViewHandler();
        KeyboardHandler keyboardHandler = new KeyboardHandler();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        SessionFactory sessionFactory = new SessionFactory();


        Integer option =0;
        while (option != 3) {
            viewHandler.printMenu(MenuTypeEnum.MAIN_MENU);
            option = keyboardHandler.readInteger("Introduceti optiunea : ");


            switch (option) {
                case 1:




                    break;
                case 2:
                    UserModel user = new UserModel();
                    user.setName(keyboardHandler.readString("Add Name: "));
                    user.setSurname(keyboardHandler.readString("Add SurName: "));
                    user.setPassword(keyboardHandler.readString("Add Password: "));
                    user.setPhoneNumber(keyboardHandler.readString("Add PhoneNumber: "));
                    user.setEmail(keyboardHandler.readString("Add Email: "));
                    viewHandler.printMenu(MenuTypeEnum.USER_TYPE);
                    int userTypeId = keyboardHandler.readInteger("Choose a user type: ");
                    boolean iscorect = true;
                    while (iscorect){
                        if (userTypeId == 2){
                            user.setUserTypeId(userTypeId);
                            iscorect = false;
                        }else if (userTypeId == 1){
                            user.setUserTypeId(userTypeId);
                            iscorect = false;
                        }else{
                            userTypeId = keyboardHandler.readInteger("Choose a user type: ");
                            iscorect = true;
                        }
                    }

                    databaseHandler.createUser(user);

                    break;

                case 3:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Nu cunoastem optiunea");
            }

        }


    }



}
