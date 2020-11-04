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
import java.util.List;
import java.util.Map;


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
                String filtruPret = "pret>='" + filtre.get(1) + "' and pret<='" +filtre.get(11) + "'";
                stringBuilder.append(filtruPret);
                isFirst = true;
            }
            if (filtre.containsKey(2)) {
                if (isFirst){
                    stringBuilder.append(and);
                }
                String filtruTipImobil = "idTipImobil='" + filtre.get(2) + "'";
                stringBuilder.append(filtruTipImobil);
                isFirst = true;
            }
            if (filtre.containsKey(3)) {
                if (isFirst){
                    stringBuilder.append(and);
                }
                String filtruSuprafata = "suprafata>='" + filtre.get(3) + "' and suprafata<='" +filtre.get(13) + "'";
                stringBuilder.append(filtruSuprafata);
                isFirst = true;
            }
            if (filtre.containsKey(4)) {
                if (isFirst){
                    stringBuilder.append(and);
                }
                String filtruEtaj = "etaj>='" + filtre.get(4) + "' and etaj<='" +filtre.get(14) + "'";
                stringBuilder.append(filtruEtaj);
                isFirst = true;
            }
            if (filtre.containsKey(5)) {
                if (isFirst){
                    stringBuilder.append(and);
                }
                String filtruCamere = "numarCamere>='" + filtre.get(5) + "' and numarCamere<='" +filtre.get(15) + "'";
                stringBuilder.append(filtruCamere);
                isFirst = true;
            }
            if (filtre.containsKey(6)) {
                if (isFirst){
                    stringBuilder.append(and);
                }
                String filtruAnConstructie = "anConstructie>='" + filtre.get(6) + "' and anConstructie<='" +filtre.get(16) + "'";
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

    //TODO de realizat metodele de cautare, adaugare,


}
