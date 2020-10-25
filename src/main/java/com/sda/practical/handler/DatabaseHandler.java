package com.sda.practical.handler;

<<<<<<< HEAD
import com.sda.practical.entities.imobile.ImobilEntity;
import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.entities.users.UserTypesEntity;
import com.sda.practical.models.FiltrerModel;
=======
import com.sda.practical.entities.imobile.ImobileEntity;
import com.sda.practical.entities.users.UserEntity;
import com.sda.practical.model.FilterModel;
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
import com.sda.practical.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Date;
=======
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
import java.util.List;

public class DatabaseHandler {


<<<<<<< HEAD
        public void createUser(String name, String surname, String password, String email,String phoneNumber, Integer userTypeId){
            Transaction transaction =null;
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                UserEntity userEntity = new UserEntity();

                userEntity.setName(name);
                userEntity.setSurname(surname);
                userEntity.setPassword(password);
                userEntity.setEmail(email);
                userEntity.setPhoneNumber(phoneNumber);
                UserTypesEntity userTypesEntity = session.find(UserTypesEntity.class,userTypeId);
                userEntity.setUserType(Arrays.asList(userTypesEntity));





                userEntity.setUserType(typeUser);// imi trebuie un string nu o lista
                transaction = session.beginTransaction();
                session.save(userEntity);
                transaction.commit();
                session.close();
            }catch (Exception ex){
                if (transaction != null){
                    transaction.rollback();
                }
                System.out.println(ex.getMessage());
=======
    public void createAccount(String name, String surname, String password, String email, String phoneNumber) {
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
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
            }
            System.out.println(ex.getMessage());
        }
    }

    public List<ImobileEntity> getImobils(FilterModel filterModel) {
        String sql = createFilterSql(filterModel);

<<<<<<< HEAD
    public void addImobil(Date date, Double suprafata, Double pret, Integer etaj, Integer an, Integer nrCamere, String coordonate, String descriere){
            Transaction transaction = null;
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                ImobilEntity imobilEntity = new ImobilEntity();
                imobilEntity.setDataPostariiAnuntului(date);
                imobilEntity.setPret(pret);
                imobilEntity.setSuprafata(suprafata);
                imobilEntity.setEtaj(etaj);
                imobilEntity.setAnConstructii(an);
                imobilEntity.setNumarCamere(nrCamere);
                imobilEntity.setCoordonate(coordonate);
                imobilEntity.setDescriere(descriere);
                transaction = session.beginTransaction();
                session.save(imobilEntity);
                transaction.commit();
                session.close();
            }catch (Exception ex){
                if (transaction != null){
                    transaction.rollback();
                }
                System.out.println(ex.getMessage());
            }
    }


    public List<ImobilEntity> getIimobils(FiltrerModel filtrerModel){
            String sql = createFiltrerSQL(filtrerModel);
            return null;
=======
        return null;
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
    }

    public String createFilterSql(FilterModel filterModel) {
        String sql = "Select * imobile where ";
        if (filterModel.getOras() != null) {
            sql += "suprafata = " + filterModel.getSuprafata();
        }
        return sql;
    }

    public String createFiltrerSQL(FiltrerModel filtrerModel){
        String sql = "select * from Imobile where ";
        if (filtrerModel.getSuprfata() != null){
            sql+="suprafata = " + filtrerModel.getSuprfata();
        }
        return sql;
    }

}
