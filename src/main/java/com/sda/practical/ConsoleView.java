package com.sda.practical;

import com.mysql.cj.xdevapi.SessionFactory;
import com.sda.practical.enums.MenuTypeEnum;
import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.handler.KeyboardHandler;
import com.sda.practical.handler.ViewHandler;
import com.sda.practical.models.ImobilModel;
import com.sda.practical.models.UserModel;

public class ConsoleView {
    ViewHandler viewHandler = new ViewHandler();
    KeyboardHandler keyboardHandler = new KeyboardHandler();
    DatabaseHandler databaseHandler = new DatabaseHandler();
    SessionFactory sessionFactory = new SessionFactory();


    public void startApp() {


        Integer option = 0;
        while (option != 5) {
            viewHandler.printMenu(MenuTypeEnum.MAIN_MENU);
            option = keyboardHandler.readInteger("Introduceti optiunea : ");

            switch (option) {
                case 1:
                    UserModel userLogat = new UserModel();
                    userLogat.setName(keyboardHandler.readString("Prenume: "));
                    userLogat.setSurname(keyboardHandler.readString("Nume: "));
                    userLogat.setPassword(keyboardHandler.readString("Parola: "));
                    Integer idTipUser = databaseHandler.verifyUser(userLogat);
                    Integer idUser = databaseHandler.getUserId(userLogat);
                    if (idTipUser == 1) {
                        while (option != 7) {
                            viewHandler.printMenu(MenuTypeEnum.CLIENT_USER);
                            option = keyboardHandler.readInteger("Introduceti optiunea : ");
                            switch (option) {
                                case 1:  // cauta imobil
                                    break;
                                case 2: // inchiriaza imobil
                                    break;
                                case 3: // cumpara imobil
                                    break;
                                case 4: // prezinta lista favorite
                                    break;
                                case 5: // adauga la favorit
                                    break;
                                case 6: // sterger de la favorit
                                    break;
                                case 7:
                                    System.out.println("Pa Pa");
                                    break;
                                default:
                                    System.out.println("Nu cunoastem optiunea !");

                            }
                        }
                    } else if (idTipUser == 2) {
                        while (option != 5) {
                            viewHandler.printMenu(MenuTypeEnum.VANZATOR_USER);
                            option = keyboardHandler.readInteger("Introduceti optiunea : ");
                            switch (option) {
                                // TODO cum se poate encapsula metoda de add imobil - done
                                case 1: // adauga imobil
                                    this.addImobil(idUser);
                                    break;
                                case 2: // cauta imobil
                                    break;
                                case 3: // sterge imobil
                                    break;
                                case 4: // lista imobile vanzare

                                    System.out.println(databaseHandler.getImobileEntitate(userLogat).toString());
                                    break;
                                case 5:
                                    System.out.println("Pa Pa");
                                    break;
                                default:
                                    System.out.println("Nu cunoastem optiunea !");
                            }
                        }
                    } else {
                        System.out.println("The user doesnt exist!");
                    }

                    //TODO de creat metoda de log in, printr-un query - done
                    //TODO sa prindem intr-un loop metoda de log in, - done

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
                    while (iscorect) {
                        if (userTypeId == 2) {
                            user.setUserTypeId(userTypeId);
                            iscorect = false;
                        } else if (userTypeId == 1) {
                            user.setUserTypeId(userTypeId);
                            iscorect = false;
                        } else {
                            userTypeId = keyboardHandler.readInteger("Choose a user type: ");
                            iscorect = true;
                        }
                    }

                    databaseHandler.createUser(user);
                    System.out.println("User created !");

                    break;

                //TODO - de realizat metoda de adaugat imobile, am inceput, trebuie finalizata -done
                case 3:

                    break;

                case 5:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Nu cunoastem optiunea");
            }

        }


    }


    public void addImobil(Integer id) {
        ImobilModel imobilModel = new ImobilModel();
        imobilModel.setDataPostariiAnuntului(keyboardHandler.readDate());
        imobilModel.setAnConstructie(keyboardHandler.readInteger("Add year: "));
        imobilModel.setEtaj(keyboardHandler.readString("Add etaj: "));
        imobilModel.setNumarCamere(keyboardHandler.readInteger("Add Numar camere: "));
        imobilModel.setIdCurrencyEntity(keyboardHandler.readInteger("Ce tip de Valuta doriti:\n" +
                "1. RON\n" +
                "2. EURO\n" +
                "3. DOLAR"));
        imobilModel.setPret(keyboardHandler.readDouble("Add price: "));
        imobilModel.setCoordonate(keyboardHandler.readString("Add coordonate: "));
        imobilModel.setSuprafata(keyboardHandler.readDouble("Add suprafata : "));
        imobilModel.setDescriere(keyboardHandler.readString("Add descriere : "));
        imobilModel.setIdCompartimentareEntity(keyboardHandler.readInteger("Ce tip de compartimentare are apartamentul:\n" +
                "1. Decomandat\n" +
                "2. Semidecomandat\n" +
                "3. Circular\n" +
                "4. Vagon"));
        imobilModel.setIdAnuntStatusEntity(1);
        imobilModel.setIdOras(keyboardHandler.readInteger("In ce oras :\n" +
                "1. Brasov\n" +
                "2. Bucuresti\n" +
                "3. Cluj-Napoca\n" +
                "4. Rm Valcea"));

        imobilModel.setIdVanzator(id);
        databaseHandler.addImobil(imobilModel);
        System.out.println("Imobil created !");
    }


}
