package com.sda.practical.handler;

import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseHandler {


        public void createAccount(String name, String surname, String parola, String email, ){
            Transaction transaction =null;
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                UserEntity userEntity = new UserEntity();
                userEntity.setName();


            }

        }



}
