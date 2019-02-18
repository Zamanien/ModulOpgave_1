package databaseviewer.database;

public class DBConnector
{
    //Singleton pattern for DBConnector
    private static DBConnector instance = null;

    private DBConnector(){}

    public static DBConnector getInstance()
    {
        if (instance == null) 
        {
            instance = new DBConnector();
        }
        return instance;
    }

    public void connect()
    {

    }
}