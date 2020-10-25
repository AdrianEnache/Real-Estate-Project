package com.sda.practical;

import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.models.FiltrerModel;
import com.sda.practical.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

public class HibernateUtilTest {

    @Test

    public void testFiltrerSQL(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        FiltrerModel filtrerModel = new FiltrerModel();
        filtrerModel.setSuprfata(100);
        String sql = databaseHandler.createFiltrerSQL(filtrerModel);
        Assert.assertEquals("select * from imobile where suprafata = 100",sql);
        //HQL "from ImobilEntity where suprafata = 100 and oras.oras = 'Timisoara' "

    }
}
