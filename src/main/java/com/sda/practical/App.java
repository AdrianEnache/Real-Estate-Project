package com.sda.practical;


import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;


public class App
{
    public static void main( String[] args )
    {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        new ConsoleView().startApp();



    }
}
