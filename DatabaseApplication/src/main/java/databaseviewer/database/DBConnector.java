package databaseviewer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import databaseviewer.utilities.console.SystemLog;
import databaseviewer.utilities.console.SystemLog.Severity;

public class DBConnector
{
    private static final String DB_HOST = "mysql69.unoeuro.com";
    private static final String DB_NAME = "unotest_ga_db";
    private static final String DB_USER = "unotest_ga";
    private static final String DB_PASS = "kr4wc5pm";

    public static Connection connection;

    public static void connect()
    {
        String url = String.format("jdbc:mysql://%s/%s?autoReconnect=true&useSSL=false", DB_HOST, DB_NAME);
        

        try
        {
            SystemLog.logEndl("Establishing connection to database..", Severity.INFO);

            connection = DriverManager.getConnection(url, DB_USER, DB_PASS);

            SystemLog.logEndl("Connection was successful!", Severity.INFO);

        } 
        catch (Exception e) 
        {
            e.printStackTrace();   
        }
    }
}