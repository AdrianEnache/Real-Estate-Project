package com.sda.practical.handler;

import com.sda.practical.entities.imobile.*;
import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.entities.users.UserTypesEntity;
import com.sda.practical.models.FilterModel;
import com.sda.practical.models.ImobilModel;
import com.sda.practical.models.UserModel;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class DatabaseHandler {


    public void createUser(UserModel userModel) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UserEntity userEntity = new UserEntity();
            userEntity.setName(userModel.getName());
            userEntity.setSurname(userModel.getSurname());
            userEntity.setPassword(userModel.getPassword());
            userEntity.setEmail(userModel.getEmail());
            userEntity.setPhoneNumber(userModel.getPhoneNumber());
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
            ImobileEntity imobileEntity = new ImobileEntity();
            imobileEntity.setDataPostariiAnuntului(imobilModel.getDataPostariiAnuntului());
            imobileEntity.setPret(imobilModel.getPret());
            imobileEntity.setSuprafata(imobilModel.getSuprafata());
            imobileEntity.setEtaj(imobilModel.getEtaj());
            imobileEntity.setAnConstructii(imobilModel.getAnConstructie());
            imobileEntity.setNumarCamere(imobilModel.getNumarCamere());
            imobileEntity.setCoordonate(imobilModel.getCoordonate());
            imobileEntity.setDescriere(imobilModel.getDescriere());
            AnuntStatusEntity anuntStatus = session.find(AnuntStatusEntity.class,imobilModel.getIdAnuntStatusEntity());
            imobileEntity.setAnuntStatusEntity(anuntStatus);
            CompartimentareEntity compartimentare = session.find(CompartimentareEntity.class, imobilModel.getIdCompartimentareEntity());
            imobileEntity.setCompartimentareEntity(compartimentare);
            CurrencyEntity currency = session.find(CurrencyEntity.class,imobilModel.getIdCurrencyEntity());
            imobileEntity.setCurrencyEntities(Arrays.asList(currency));
            OrasEntity oras = session.find(OrasEntity.class,imobilModel.getIdOras());
            imobileEntity.setOrasEntity(oras);
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



    public List<ImobileEntity> getImobils(FilterModel filterModel) {
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
