package databaseviewer.services.login;

import databaseviewer.utils.console.LogManager;
import databaseviewer.utils.console.LogManager.Severity;

public final class LoginService {
    private LoginService() {
    }

    public static boolean login(UserCredentials credentials) {
        try 
        {
            System.out.println();
            LogManager.logEndl("Authenticating user credentials.", Severity.INFO);

            if (credentials.getUsername().equals("Frederik") &&
            credentials.getPassword().equals("hemmeligtkodeord")) 
            {
                LogManager.logEndl("Authentication was successful!", Severity.INFO);
                System.out.printf("\nWelcome %s.\n", credentials.getUsername());
                Thread.sleep(3000);
                return true;
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean logout()
    {
        return false;
    }
}