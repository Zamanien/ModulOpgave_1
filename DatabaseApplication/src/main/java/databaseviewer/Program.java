package databaseviewer;

import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.displayables.menus.LoginMenu;
import databaseviewer.utils.console.LogManager;
import databaseviewer.utils.console.LogManager.Severity;
import databaseviewer.settings.UserSettings;

public final class Program {
    public static void main(String[] args) {
        
        try 
        { 
            new ProcessBuilder("cmd", "/c", "title Database Application").inheritIO().start().wait();
        } 
        catch (Exception e) {}

        UserSettings.collect(); 
        handleArgs(args); 
        ScreenNavigator navigator = ScreenNavigator.getInstance(); 
        navigator.start(new LoginMenu());

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
                        LogManager.setSeverity(Severity.DEBUG);
                        LogManager.logEndl("Log severity set to debug", Severity.DEBUG);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
