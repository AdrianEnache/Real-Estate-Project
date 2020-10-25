package com.sda.practical;

import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.models.FilterModel;
import org.junit.Assert;
import org.junit.Test;

public class HibernateUtilTest {

    @Test
    public void testFilterSql() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        FilterModel filterModel = new FilterModel();
        filterModel.setSuprafata(100);
        String sql = databaseHandler.createFilterSql(filterModel);
        Assert.assertEquals("select * from imobile where suprafata = 100", sql);
    }
}
