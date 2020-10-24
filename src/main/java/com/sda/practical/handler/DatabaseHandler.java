package com.sda.practical.handler;

import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseHandler {


        public void createAccount(String name, String surname, String password, String email,String phoneNumber ){
            Transaction transaction =null;
            try{
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
            }catch (Exception ex){
                if (transaction != null){
                    transaction.rollback();
                }
                System.out.println(ex.getMessage());
            }
        }





}
