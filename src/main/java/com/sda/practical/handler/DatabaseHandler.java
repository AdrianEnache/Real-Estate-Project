package com.sda.practical.handler;

import com.sda.practical.entities.imobile.*;
import com.sda.practical.entities.users.UtilizatorEntitate;
import com.sda.practical.entities.users.UserTypesEntity;
import com.sda.practical.models.FilterModel;
import com.sda.practical.models.ImobilModel;
import com.sda.practical.models.UserModel;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseHandler {


    public void createUser(UserModel userModel) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UtilizatorEntitate userEntity = new UtilizatorEntitate();
            userEntity.setPrenume(userModel.getName());
            userEntity.setNumeDeFamilie(userModel.getSurname());
            userEntity.setParola(userModel.getPassword());
            userEntity.setAdresaEmail(userModel.getEmail());
            userEntity.setNumarTelefon(userModel.getPhoneNumber());
            UserTypesEntity userTypesEntity = session.find(UserTypesEntity.class,userModel.getUserTypeId());
            userEntity.setUserType(userTypesEntity);
            transaction = session.beginTransaction();
            session.save(userEntity);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }


    public void addImobil(ImobilModel imobilModel){
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            ImobileEntitate imobileEntity = new ImobileEntitate();
            imobileEntity.setDataPostariiAnuntului(imobilModel.getDataPostariiAnuntului());
            imobileEntity.setPret(imobilModel.getPret());
            imobileEntity.setSuprafata(imobilModel.getSuprafata());
            imobileEntity.setEtaj(imobilModel.getEtaj());
            imobileEntity.setAnConstructii(imobilModel.getAnConstructie());
            imobileEntity.setNumarCamere(imobilModel.getNumarCamere());
            imobileEntity.setCoordonate(imobilModel.getCoordonate());
            imobileEntity.setDescriere(imobilModel.getDescriere());
            AnuntStatusEntitate anuntStatus = session.find(AnuntStatusEntitate.class,imobilModel.getAnuntStatus());
            imobileEntity.setAnuntStatus(anuntStatus);
            CompartimentareEntitate compartimentare = session.find(CompartimentareEntitate.class, imobilModel.getCompartimentare());
            imobileEntity.setCompartimentare(compartimentare);
            ValutaEntitate currency = session.find(ValutaEntitate.class,imobilModel.getCurrency());
            imobileEntity.setCurrency(currency);
            OrasEntitate oras = session.find();
            transaction = session.beginTransaction();
            session.save(imobileEntity);
            transaction.commit();
            session.close();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
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
