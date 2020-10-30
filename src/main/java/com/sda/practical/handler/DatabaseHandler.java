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

import java.sql.SQLException;
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
            utilizator.setUserType(userTypesEntity);
            transaction = session.beginTransaction();
            session.save(utilizator);
            session.save(userTypesEntity);
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
            AnuntStatusEntitate anuntStatus = session.find(AnuntStatusEntitate.class, imobilModel.getIdAnuntStatusEntity());
            imobil.setAnuntStatusEntity(anuntStatus);
            CompartimentareEntitate compartimentare = session.find(CompartimentareEntitate.class, imobilModel.getIdCompartimentareEntity());
            imobil.setCompartimentareEntity(compartimentare);
            ValutaEntitate currency = session.find(ValutaEntitate.class, imobilModel.getIdCurrencyEntity());
            imobil.setValutaEntitate(Arrays.asList(currency));
            OrasEntitate oras = session.find(OrasEntitate.class, imobilModel.getIdOras());
            imobil.setOrasEntitate(oras);
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


    public boolean verifyUser(String numeDeFamilie, String prenume, String parola) {
        Transaction transaction = null;
        boolean isValid = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String sql = "select * from utilizatorentitate where numeDeFamilie='"+ numeDeFamilie+"' and prenume = '"+prenume+"' and parola ='"+parola+"'";
            List<UtilizatorEntitate> utilizatorEntitate = session.createQuery(sql,UtilizatorEntitate.class).list();
            isValid = utilizatorEntitate.isEmpty();
           session.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return isValid;
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


}
