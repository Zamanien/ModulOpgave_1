package databaseviewer.utilities.console;

import java.io.IOException;
import java.util.Scanner;

import databaseviewer.utilities.console.SystemLog.Severity;
import databaseviewer.utilities.settings.UserSettings;
import databaseviewer.utilities.settings.UserSettings.OSType;

public final class ConsoleManager 
{
    private static Scanner scanner = new Scanner(System.in);

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
    private static String getInput()
    {
        System.out.print("> ");
        return scanner.next();
    }

    public static int getInteger()
    {
        String input = getInput();

        while (true) 
        {
            try 
            {
                return Integer.parseInt(input);  
            } 
            catch (Exception e) 
            {
                System.out.println("Input must be of type integer i.e 0,1,2..");
            }
        }
    }

    public static int getFloat()
    {
        String input = getInput();

        while (true) 
        {
            try 
            {
                return Integer.parseInt(input);  
            } 
            catch (Exception e) 
            {
                System.out.println("Input must be of type float i.e 0.175f, 3.1415f");
            }
        }
    }
}