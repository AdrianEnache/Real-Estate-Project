package com.sda.practical.handler;

import com.sda.practical.entities.imobile.*;
import com.sda.practical.entities.users.UserTypesEntity;
import com.sda.practical.entities.users.UtilizatorEntitate;
import com.sda.practical.models.FilterModel;
import com.sda.practical.models.ImobilModel;
import com.sda.practical.models.UserModel;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DatabaseHandler {

    // metoda createUser ne ajuta sa cream un user nou
    public void createUser(UserModel userModel) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UtilizatorEntitate utilizator = new UtilizatorEntitate();
            utilizator.setPrenume(userModel.getName());
            utilizator.setNumeDeFamilie(userModel.getSurname());
            utilizator.setParola(userModel.getPassword());
            utilizator.setAdresaEmail(userModel.getEmail());
            utilizator.setNumarTelefon(userModel.getPhoneNumber());
            UserTypesEntity userTypesEntity = session.find(UserTypesEntity.class, userModel.getUserTypeId());
            utilizator.setIdTipUser(userModel.getUserTypeId());
            utilizator.setUserType(userTypesEntity);
            transaction = session.beginTransaction();
            session.save(utilizator);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }

    // metoda addImobil ne ajuta sa cream un imobil nou
    public void addImobil(ImobilModel imobilModel) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            ImobileEntitate imobil = new ImobileEntitate();
            imobil.setDataPostariiAnuntului(imobilModel.getDataPostariiAnuntului());
            imobil.setPret(imobilModel.getPret());
            imobil.setSuprafata(imobilModel.getSuprafata());
            imobil.setEtaj(imobilModel.getEtaj());
            imobil.setAnConstructii(imobilModel.getAnConstructie());
            imobil.setNumarCamere(imobilModel.getNumarCamere());
            imobil.setCoordonate(imobilModel.getCoordonate());
            imobil.setDescriere(imobilModel.getDescriere());
            //TODO trebuie corectata metoda , stabilit ce tip de anunt , compartimentare, valuta si oras este . Metoda de GetID nu are ce returna - DONE
            AnuntStatusEntitate anuntStatus = session.find(AnuntStatusEntitate.class, imobilModel.getIdAnuntStatusEntity());
            imobil.setAnuntStatusEntity(anuntStatus);
            CompartimentareEntitate compartimentare = session.find(CompartimentareEntitate.class, imobilModel.getIdCompartimentareEntity());
            imobil.setCompartimentareEntity(compartimentare);
            ValutaEntitate currency = session.find(ValutaEntitate.class, imobilModel.getIdCurrencyEntity());
            imobil.setValutaEntitate(currency);
            OrasEntitate oras = session.find(OrasEntitate.class, imobilModel.getIdOras());
            imobil.setOrasEntitate(oras);
            UtilizatorEntitate utilizatorEntitate = session.find(UtilizatorEntitate.class, imobilModel.getIdVanzator());
            imobil.setUtilizatorEntitate(utilizatorEntitate);
            ImobilTypeEntity imobilTypeEntity = session.find(ImobilTypeEntity.class, imobilModel.getIdTipImobil());
            imobil.setTipImobil(imobilTypeEntity);
            transaction = session.beginTransaction();
            session.save(imobil);
            transaction.commit();
            session.close();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }

    // metoda verifyUser - o folosim pentru a verifica ce tip de user s-a logat in baza de date
    public Integer verifyUser(UserModel userModel) {
        Integer idTipUser = -1;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // in query trebuie folosit numele clasei(tabele) din java code (case sensitive);
            String sql = "select idTipUser from UtilizatorEntitate where prenume ='" + userModel.getName() + "' " +
                    "and numeDeFamilie='" + userModel.getSurname() + "' " +
                    "and parola='" + userModel.getPassword() + "'";

            List<Integer> users = session.createQuery(sql, Integer.class).list();
            idTipUser = users.get(0);
            System.out.println(users);
            System.out.println("Utilizatorul este :");
            if (users.contains(1)) {
                System.out.println("Cumparator!");
            } else if (users.contains(2)) {
                System.out.println("Vanzator!");
            } else {
                System.out.println("User nu exista !");
            }
            session.close();
        } catch (Exception ex) {
            System.out.println("Not Connected !");
            System.out.println(ex.getMessage());
        }
        return idTipUser;
    }


    // metoda getUserId - o folosim pentru log in in baza de date
    public Integer getUserId(UserModel userModel) {
        Integer idUser = -1;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // in query trebuie folosit numele clasei(tabele) din java code (case sensitive);
            String sql = "select idUtilizator from UtilizatorEntitate where prenume ='" + userModel.getName() + "' " +
                    "and numeDeFamilie='" + userModel.getSurname() + "' " +
                    "and parola='" + userModel.getPassword() + "'";

            List<Integer> users = session.createQuery(sql, Integer.class).list();
            idUser = users.get(0);
            System.out.println("Logged in!");
            session.close();
        } catch (Exception ex) {
            System.out.println("Not Connected !");
            System.out.println(ex.getMessage());
        }
        return idUser;
    }

    // metoda getImobileEntitate ne afiseaza o lista care contine toate imobilele din baza de date
    public List<ImobileEntitate> getImobileEntitate(UserModel userModel) {
        List<ImobileEntitate> imobileEntitateList = new ArrayList<>();
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            String sql = "from ImobileEntitate where idVanzator='" + userModel.getUserId() + "'";
            imobileEntitateList = session.createQuery(sql, ImobileEntitate.class).list();
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return imobileEntitateList;
    }

    // metoda stergeImobil - ne ajuta sa stergem un imobil din baza de date cu ajutorul ID-ului acelui imobil
    public void stergeImobil(ImobilModel imobilModel) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            ImobileEntitate imobileEntitate = session.find(ImobileEntitate.class, imobilModel.getIdTipImobilEntity());
            transaction = session.beginTransaction();
            session.delete(imobileEntitate);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }

    // metoda cautaImobil - ne ofera posibilitatea sa cautam ( in baza unor filtre ) in lista de imobile,
    // ne va afisa imobilele conform filtrelor selectate
    public List<ImobileEntitate> cautaImobil(Map<Integer, String> filtre) {
        List<ImobileEntitate> imobileEntitateList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from ImobileEntitate where ";
            String and = " and ";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(hql);
            boolean isFirst = false;

            if (filtre.containsKey(1)) {
                String filtruPret = "pret>='" + filtre.get(1) + "' and pret<='" + filtre.get(11) + "'";
                stringBuilder.append(filtruPret);
                isFirst = true;
            }
            if (filtre.containsKey(2)) {
                if (isFirst) {
                    stringBuilder.append(and);
                }
                String filtruTipImobil = "idTipImobil='" + filtre.get(2) + "'";
                stringBuilder.append(filtruTipImobil);
                isFirst = true;
            }
            if (filtre.containsKey(3)) {
                if (isFirst) {
                    stringBuilder.append(and);
                }
                String filtruSuprafata = "suprafata>='" + filtre.get(3) + "' and suprafata<='" + filtre.get(13) + "'";
                stringBuilder.append(filtruSuprafata);
                isFirst = true;
            }
            if (filtre.containsKey(4)) {
                if (isFirst) {
                    stringBuilder.append(and);
                }
                String filtruEtaj = "etaj>='" + filtre.get(4) + "' and etaj<='" + filtre.get(14) + "'";
                stringBuilder.append(filtruEtaj);
                isFirst = true;
            }
            if (filtre.containsKey(5)) {
                if (isFirst) {
                    stringBuilder.append(and);
                }
                String filtruCamere = "numarCamere>='" + filtre.get(5) + "' and numarCamere<='" + filtre.get(15) + "'";
                stringBuilder.append(filtruCamere);
                isFirst = true;
            }
            if (filtre.containsKey(6)) {
                if (isFirst) {
                    stringBuilder.append(and);
                }
                String filtruAnConstructie = "anConstructie>='" + filtre.get(6) + "' and anConstructie<='" + filtre.get(16) + "'";
                stringBuilder.append(filtruAnConstructie);
            }
            imobileEntitateList = session.createQuery(stringBuilder.toString(), ImobileEntitate.class).list();
            session.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return imobileEntitateList;
    }


    public List<ImobileEntitate> getImobils(FilterModel filterModel) {
        String sql = createFilterSql(filterModel);

        return null;
    }

    public String createFilterSql(FilterModel filterModel) {
        String sql = "Select * imobile where ";

        if (filterModel.getOras() != null) {
            sql += "suprafata = " + filterModel.getSuprafata();
        }
        return sql;
    }

    //  TODO cumparaImobil - nu am finalizat metoda - done
    // metoda cumparaImobil - ne folosim de un query pentru a modifica statusul unui imobil din baza de date in anunt vandut ( optiunea - 2 )
    public void cumparaImobil(ImobilModel imobilModel) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query imobileEntitateQuery = session
                    .createQuery("update ImobileEntitate set anuntStatusEntity=2 where idTipImobilEntitate=" + imobilModel.getIdTipImobilEntity());
            int result = imobileEntitateQuery.executeUpdate();
            System.out.println("Imobilul a fost cumparat.");
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }


    //  TODO inchiriazaImobil - nu am finalizat metoda - done
    // metoda inchiriazaImobil - ne folosim de un query pentru a modifica statusul unui imobil din baza de date in anunt inchiriat ( optiunea - 3 )
    public void inchiriazaImobil(ImobilModel imobilModel) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query imobileEntitateQuery = session
                    .createQuery("update ImobileEntitate set anuntStatusEntity=3 where idTipImobilEntitate=" + imobilModel.getIdTipImobilEntity());
            int result = imobileEntitateQuery.executeUpdate();
            System.out.println("Imobilul a fost inchiriat !");
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }

    // TODO 1. creare metoda pentru a crea lista de favorite - care se introduce in meniu;
    // TODO 2. metoda adaugaLaFavorit - o adaugam in noua lista din metoda noua ;

    public void adaugaLaFavorit(ImobilModel imobilModel, UserModel userModel) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<ImobileEntitate> imobileEntitateList = new ArrayList<>();
            ImobileEntitate imobileEntitate = session.find(ImobileEntitate.class, imobilModel.getIdTipImobilEntity());
            UtilizatorEntitate utilizatorEntitate = session.find(UtilizatorEntitate.class, userModel.getUserId());
            ListaFavoriteEntitate listaFavoriteEntitate = new ListaFavoriteEntitate();
            listaFavoriteEntitate.setUtilizator(utilizatorEntitate);
            imobileEntitateList.add(imobileEntitate);
            listaFavoriteEntitate.setImobileEntitateList(imobileEntitateList);
            session.save(listaFavoriteEntitate);
            transaction.commit();
            System.out.println("Imobilul a fost adaugat in lista favorite !");
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }


    }
}
