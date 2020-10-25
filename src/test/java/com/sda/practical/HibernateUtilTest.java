package com.sda.practical;

import com.sda.practical.handler.DatabaseHandler;
<<<<<<< HEAD
import com.sda.practical.models.FiltrerModel;
import com.sda.practical.util.HibernateUtil;
=======
import com.sda.practical.model.FilterModel;
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
import org.junit.Assert;
import org.junit.Test;

public class HibernateUtilTest {

    @Test
<<<<<<< HEAD

    public void testFiltrerSQL(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        FiltrerModel filtrerModel = new FiltrerModel();
        filtrerModel.setSuprfata(100);
        String sql = databaseHandler.createFiltrerSQL(filtrerModel);
        Assert.assertEquals("select * from imobile where suprafata = 100",sql);
        //HQL "from ImobilEntity where suprafata = 100 and oras.oras = 'Timisoara' "

=======
    public void testFilterSql() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        FilterModel filterModel = new FilterModel();
        filterModel.setSuprafata(100);
        String sql = databaseHandler.createFilterSql(filterModel);
        Assert.assertEquals("select * from imobile where suprafata = 100", sql);
>>>>>>> 8c8904627ba5d1cecd97188e1b44e4f0193dbc61
    }
}
