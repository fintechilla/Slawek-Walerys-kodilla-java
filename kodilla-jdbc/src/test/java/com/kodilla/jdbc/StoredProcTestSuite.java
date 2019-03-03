package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevel()throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE  READERS SET Vip_Level=\'Not set\'";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "call UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "select count(*) as how_many from readers where" +
                " vip_level = \'Not set\'";
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        int howMany = -1;
        if(rs.next()){
            howMany = rs.getInt("how_many");
        }
        dbManager.closeConnection();
        assertEquals(0, howMany);
    }
    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE  books SET bestseller = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "call UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "select count(*) as how_many from books where bestseller = 1";
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        int howMany = -1;
        if(rs.next()){
            howMany = rs.getInt("how_many");
        }
        dbManager.closeConnection();
        assertEquals(5, howMany);
    }
}
