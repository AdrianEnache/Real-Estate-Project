package com.sda.practical.util;

import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.temporaryEntities.*;
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
                Configuration configuration = new Configuration();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(UserEntity.class);
                configuration.addAnnotatedClass(AnuntStatusEntity.class);
                configuration.addAnnotatedClass(CurrencyEntity.class);
                configuration.addAnnotatedClass(ImobilEntity.class);
                configuration.addAnnotatedClass(TipCompartimentareEntity.class);
                configuration.addAnnotatedClass(TipImobilEntity.class);
                configuration.addAnnotatedClass(TipUserEntity.class);
                configuration.addAnnotatedClass(ListaOrasEentity.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return sessionFactory;
    }
}
