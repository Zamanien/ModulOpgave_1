package databaseviewer;

import databaseviewer.database.DBConnector;
import databaseviewer.utilities.console.SystemLog;
import databaseviewer.utilities.console.SystemLog.Severity;

public final class Program 
{
    public static void main(String[] args) 
    {
        if (tryConnect())
        {
            //TODO: Launch menu
        } 
        else
        {
            SystemLog.logEndl("Failed to establish connection to the MySQL database..", Severity.ERROR);    
        }
    }

    /**
     * Tries to establish a connection to the MySQL database 
     * @return True if connection is established
     */
    //TODO: Handle connection loss during session for user?
    private static boolean tryConnect()
    {
        DBConnector dbConnector = DBConnector.getInstance();
        return dbConnector.connect() ? true : false;
    }
}
