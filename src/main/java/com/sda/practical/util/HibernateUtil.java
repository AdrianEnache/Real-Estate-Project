package com.sda.practical.util;

import com.sda.practical.entities.imobile.*;
import com.sda.practical.entities.users.ListaFavoriteEntitate;
import com.sda.practical.entities.users.ImobilTypeEntity;
import com.sda.practical.entities.users.UtilizatorEntitate;
import com.sda.practical.entities.users.UserTypesEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/imobiliare?serverTimezone=UTC");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "Adrian@91");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "update");

                //TODO de modificat user si pasw cand se doreste conectarea la baza de date

                Configuration configuration = new Configuration();
                configuration.setProperties(properties);

                configuration.addAnnotatedClass(OrasEntitate.class);
                configuration.addAnnotatedClass(AnuntStatusEntitate.class);
                configuration.addAnnotatedClass(ValutaEntitate.class);
                configuration.addAnnotatedClass(ImobileEntitate.class);
                configuration.addAnnotatedClass(CompartimentareEntitate.class);
                configuration.addAnnotatedClass(ImobilTypeEntity.class);
                configuration.addAnnotatedClass(UtilizatorEntitate.class);
                configuration.addAnnotatedClass(UserTypesEntity.class);
                configuration.addAnnotatedClass(ListaFavoriteEntitate.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception ex) {
                System.out.println("Conectare fara succes!");
                System.out.println(ex.getMessage());
            }
        }
        return sessionFactory;
    }
}
