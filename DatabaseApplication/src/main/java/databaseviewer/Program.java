package databaseviewer;

import databaseviewer.database.DBConnector;

public final class Program 
{
    public static void main(String[] args) 
    {
        boot();
    }

    private static void boot()
    {
        DBConnector dbConnector = DBConnector.getInstance();
        dbConnector.connect();
    }
}
