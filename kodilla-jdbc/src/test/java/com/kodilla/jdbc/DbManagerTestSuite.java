package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
        @Test
    public void testConnect()throws SQLException {
            //Give
            //When
            DbManager dbManager = DbManager.getInstance();
            //Then
            Assert.assertNotNull(dbManager.getConnection());
        }
        @Test
    public void testSelectUsers()throws SQLException{
            //Given
            DbManager dbManager = DbManager.getInstance();
            //When
            String sqlQuery = "SELECT * from users";
            Statement statement = dbManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);

            //Then
            int counter = 0;
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "' " + rs.getString("firstName")
                        + ", " + rs.getString("lastName"));
                counter ++;
            }
            rs.close();
            statement.close();
            Assert.assertEquals(5, counter);
    }
    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "select u.id , u. lastName, u. firstName, count(*) as no_posts\n" +
                "from users u, posts p\n" +
                "where p.user_id = u.id\n" +
                "group by u.id\n" +
                "having count(*) >= 2\n" +
                ";"
                ;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("id") + "' " + rs.getString("firstName")
                    + ", " + rs.getString("lastName"));
            counter ++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(2, counter);
    }

}
