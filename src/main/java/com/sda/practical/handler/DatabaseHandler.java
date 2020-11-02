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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DatabaseHandler {


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
            imobil.setValutaEntitate(Arrays.asList(currency));
            OrasEntitate oras = session.find(OrasEntitate.class, imobilModel.getIdOras());
            imobil.setOrasEntitate(oras);
            UtilizatorEntitate utilizatorEntitate = session.find(UtilizatorEntitate.class, imobilModel.getIdVanzator());
            imobil.setUtilizatorEntitate(utilizatorEntitate);
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
            System.out.println("Conected!");
            session.close();
        } catch (Exception ex) {
            System.out.println("Not Connected !");
            System.out.println(ex.getMessage());
        }
        return idTipUser;
    }

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
            System.out.println("Conected!");
            session.close();
        } catch (Exception ex) {
            System.out.println("Not Connected !");
            System.out.println(ex.getMessage());
        }
        return idUser;
    }

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

    //TODO de realizat metodele de cautare, adaugare,


}
