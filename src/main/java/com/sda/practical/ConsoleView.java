package com.sda.practical;

import com.mysql.cj.xdevapi.SessionFactory;
import com.sda.practical.entities.imobile.ImobileEntitate;
import com.sda.practical.enums.MenuTypeEnum;
import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.handler.KeyboardHandler;
import com.sda.practical.handler.ViewHandler;
import com.sda.practical.models.ImobilModel;
import com.sda.practical.models.UserModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleView {
    ViewHandler viewHandler = new ViewHandler();
    KeyboardHandler keyboardHandler = new KeyboardHandler();
    DatabaseHandler databaseHandler = new DatabaseHandler();
    SessionFactory sessionFactory = new SessionFactory();
    Map<Integer, String> filtre = new HashMap<>();


    public void startApp() {


        Integer option = 0;
        while (option != 3) {
            viewHandler.printMenu(MenuTypeEnum.MAIN_MENU);
            option = keyboardHandler.readInteger("Introduceti optiunea : ");

            switch (option) {
                case 1:
                    UserModel userLogat = new UserModel();
                    userLogat.setName(keyboardHandler.readString("Prenume: "));
                    userLogat.setSurname(keyboardHandler.readString("Nume: "));
                    userLogat.setPassword(keyboardHandler.readString("Parola: "));
                    userLogat.setUserTypeId(databaseHandler.verifyUser(userLogat));
                    userLogat.setUserId(databaseHandler.getUserId(userLogat));
                    if (userLogat.getUserTypeId() == 1) {
                        while (option != 7) {
                            viewHandler.printMenu(MenuTypeEnum.CLIENT_USER);
                            option = keyboardHandler.readInteger("Introduceti optiunea : ");
                            switch (option) {
                                case 1:  // cauta imobil
                                    //TODO De comentat metodele!
                                    this.cautaCuFiltre();
                                    break;
                                case 2: // inchiriaza imobil
                                    ImobilModel imobilModelInchiriat = new ImobilModel();
                                    imobilModelInchiriat.setIdTipImobilEntity(keyboardHandler.readInteger("Ce imobil doriti sa inchiriati?"));
                                    this.databaseHandler.inchiriazaImobil(imobilModelInchiriat);
                                    break;
                                case 3: // cumpara imobil
                                    ImobilModel imobilModelCumparat = new ImobilModel();
                                    imobilModelCumparat.setIdTipImobilEntity(keyboardHandler.readInteger("Ce imobil doriti sa cumparati?"));
                                    this.databaseHandler.cumparaImobil(imobilModelCumparat);
                                    break;
                                case 4: // prezinta lista favorite

                                    break;
                                case 5: // adauga la favorit
                                    ImobilModel imobil = new ImobilModel();
                                    imobil.setIdTipImobilEntity(keyboardHandler.readInteger("Ce imobil doriti sa adaugati la favorit?"));
                                    databaseHandler.adaugaFavorit(userLogat,imobil);
                                    break;
                                case 6: // sterge de la favorit

                                    break;
                                case 7://sterge de la favorite
                                    System.out.println("Logged out!");
                                    break;
                                default:
                                    System.out.println("Nu cunoastem optiunea !");

                            }
                        }
                    } else if (userLogat.getUserTypeId() == 2) {
                        while (option != 5) {
                            viewHandler.printMenu(MenuTypeEnum.VANZATOR_USER);
                            option = keyboardHandler.readInteger("Introduceti optiunea : ");
                            switch (option) {
                                // TODO cum se poate encapsula metoda de add imobil - done
                                case 1: // adauga imobil
                                    this.addImobil(userLogat.getUserId());
                                    break;
                                case 2: // cauta imobil
                                    this.cautaCuFiltre();
                                    break;
                                case 3: // sterge imobil
                                    ImobilModel imobilModel = new ImobilModel();
                                    imobilModel.setIdTipImobilEntity(keyboardHandler.readInteger("Introduceti id-ul imobilului pe care doriti sa il stergeti:"));
                                    databaseHandler.stergeImobil(imobilModel);
                                    break;
                                case 4: // lista imobile vanzare
                                    //TODO - trebuie aranjata prezentarea listei (vezi in metode de toString din ImobileEntitate - done
                                    List<ImobileEntitate> listaImobile = databaseHandler.getImobileEntitate(userLogat);
                                    this.printListaImobile(listaImobile);
                                    break;
                                case 5:
                                    System.out.println("Logged out!");
                                    break;
                                //TODO cand selectam log out dintr-un user - ne scoate din loop si opreste programul -done
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
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Nu cunoastem optiunea");
            }

        }


    }

    // metoda addImobil - ne creaza un imobil de tip imobilModel
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
        imobilModel.setIdTipImobil(keyboardHandler.readInteger("Ce tip de imobil este:\n" +
                "1. Teren\n" +
                "2. Casa\n" +
                "3. Apartament\n"));
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

    //metoda printListaImobile - ne afiseaza lista din baza de date cu toate imobilele introduse
    public void printListaImobile(List<ImobileEntitate> listaImobile) {

        for (ImobileEntitate imobil : listaImobile) {
            System.out.println(imobil.getIdTipImobilEntitate() + ". " +
                    "Data Postarii = " + imobil.getDataPostariiAnuntului() +
                    ", Anunt Status = " + imobil.getAnuntStatusEntity().getStatusAnunt() +
                    ", Suprafata = " + imobil.getSuprafata() + " MP" +
                    ", Pret = " + imobil.getPret() +
                    ", Valuta = " + imobil.getValutaEntitate().getTipValuta() +
                    ", Tip Imobil = " + imobil.getTipImobil().getTipImobil() +
                    ", Etaj = " + imobil.getEtaj() +
                    ", Compartimentare = " + imobil.getCompartimentareEntity().getTipCompartimentare() +
                    ", Numar Camere = " + imobil.getNumarCamere() +
                    ", An Constructie = " + imobil.getAnConstructie() +
                    ", Coordonate = " + imobil.getCoordonate() +
                    ", Descriere = " + imobil.getDescriere() +
                    ", Oras = " + imobil.getOrasEntitate().getNumeOras());
        }
    }

    // metoda cautaCuFiltre - se foloseste de metoda cautaImobil din DBHandler
    // am folosit un switch + case pentru meniul de filtre
    public void cautaCuFiltre() {
        Integer option = 0;
        while (option != 8) {
            viewHandler.printMenu(MenuTypeEnum.SEARCH_MENU);
            option = keyboardHandler.readInteger("Introduceti optiunea : ");
            switch (option) {
                case 1:
                    Double pret = keyboardHandler.readDouble("Intre Pret (=>): ");
                    filtre.put(1, pret.toString());
                    Double pret2 = keyboardHandler.readDouble("Si pret (<=): ");
                    filtre.put(11, pret2.toString());
                    break;
                case 2:
                    Integer idTipLocuinta = keyboardHandler.readInteger("Ce tip de locuinta:\n" +
                            "1. Teren\n" +
                            "2. Casa\n" +
                            "3. Apartament");
                    filtre.put(2, idTipLocuinta.toString());
                    break;
                case 3:
                    Double suprafata = keyboardHandler.readDouble("Intre Suprafata (=>): ");
                    filtre.put(3, suprafata.toString());
                    Double suprafata2 = keyboardHandler.readDouble("Si suprafata (<=): ");
                    filtre.put(13, suprafata2.toString());
                    break;
                case 4:
                    Integer etaj = keyboardHandler.readInteger("Intre Etaj (=>): ");
                    filtre.put(4, etaj.toString());
                    Integer etaj2 = keyboardHandler.readInteger("Si Etaj(<=): ");
                    filtre.put(14, etaj2.toString());
                    break;
                case 5:
                    Integer nrCamere = keyboardHandler.readInteger("intre Numar Camere (=>): ");
                    filtre.put(5, nrCamere.toString());
                    Integer nrCamere2 = keyboardHandler.readInteger("Si numar Camere(<=): ");
                    filtre.put(15, nrCamere2.toString());
                    break;
                case 6:
                    String anConstructie = keyboardHandler.readString("Intre An Constructie (=>): ");
                    filtre.put(6, anConstructie);
                    String anConstructie2 = keyboardHandler.readString("Si An Constructie (<=): ");
                    filtre.put(16, anConstructie2);
                    break;
                case 7:
                    printListaImobile(databaseHandler.cautaImobil(filtre));
                    filtre.clear();
                    break;
                case 8:
                    // filtre.clear - ne goleste mapa de fiecare data pentru a putea reintroduce alte optiuni
                    filtre.clear();
                    break;
                default:
                    System.out.println("Optiune incorecta");
            }
        }
    }
}



