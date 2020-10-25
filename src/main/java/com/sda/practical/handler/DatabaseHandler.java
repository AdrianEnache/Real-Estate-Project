package com.sda.practical.handler;

import com.sda.practical.entities.imobile.ImobileEntity;
import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.models.FilterModel;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseHandler {


    public void createUser(String name, String surname, String password, String email, String phoneNumber) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UserEntity userEntity = new UserEntity();
            userEntity.setName(name);
            userEntity.setSurname(surname);
            userEntity.setPassword(password);
            userEntity.setEmail(email);
            userEntity.setPhoneNumber(phoneNumber);
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
