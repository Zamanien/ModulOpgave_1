package databaseviewer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector
{
    public static void connect()
    {

        try 
        {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://mysql69.unoeuro.com/unotest_ga_db", "unotest_ga", "kr4wc5pm");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();   
        }
    }
}