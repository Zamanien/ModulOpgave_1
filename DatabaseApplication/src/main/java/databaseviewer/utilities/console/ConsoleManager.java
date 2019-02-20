package databaseviewer.utilities.console;

import java.io.IOException;

import databaseviewer.utilities.console.SystemLog.Severity;
import databaseviewer.utilities.settings.UserSettings;
import databaseviewer.utilities.settings.UserSettings.OSType;

/**
 * ConsoleManager
 */
public final class ConsoleManager 
{
    private ConsoleManager() {}

    public static void clearScreen()
    {
        if (UserSettings.getOSType() == OSType.WINDOWS) 
        {
            try
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            catch(IOException | InterruptedException e)
            {
                SystemLog.logEndl("Couldn't clear screen", Severity.ERROR);
            }
        }
        //If console supports ansi escape characters 
        else
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}