package databaseviewer;

<<<<<<< HEAD
import databaseviewer.menus.MenuNavigator;
=======
import databaseviewer.database.DBConnector;
import databaseviewer.menus.ScreenNavigator;
>>>>>>> 8ea84a6f40f975a8408d99c248a7a13c56c58d74
import databaseviewer.menus.application_menus.LoginMenu;
import databaseviewer.utilities.console.SystemLog;
import databaseviewer.utilities.console.SystemLog.Severity;
import databaseviewer.utilities.settings.UserSettings;

public final class Program 
{
    public static void main(String[] args) 
    {
        try 
        {
            new ProcessBuilder("cmd", "/c", "title Database Application").inheritIO().start().wait();
        } 
        catch (Exception e) 
        {
            
        }

        UserSettings.collect();
        handleArgs(args);
        ScreenNavigator navigator = ScreenNavigator.getInstance();
        navigator.navigate(new LoginMenu());
    }

    /**
     * Handles arguments from user when launching
     * @param args The arguments passed from Main
     */
    private static void handleArgs(String[] args)
    {
        if (args.length > 0) 
        {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    //debug mode flag
                    case "-d": 
                        SystemLog.setSeverity(Severity.DEBUG);
                        SystemLog.logEndl("Log severity set to debug", Severity.DEBUG);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
