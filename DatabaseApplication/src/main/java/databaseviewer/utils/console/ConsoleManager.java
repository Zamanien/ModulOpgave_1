package databaseviewer.utils.console;

import java.io.IOException;

import databaseviewer.utils.console.LogManager.Severity;
import databaseviewer.settings.UserSettings;
import databaseviewer.settings.UserSettings.OSType;

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
                LogManager.logEndl("Couldn't clear screen", Severity.ERROR);
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