package databaseviewer.services.login;

import databaseviewer.utilities.console.SystemLog;
import databaseviewer.utilities.console.SystemLog.Severity;

public final class LoginService {
    private LoginService() {
    }

    public static boolean login(UserCredentials credentials) {
        try 
        {
            System.out.println();
            SystemLog.logEndl("Authenticating user credentials.", Severity.INFO);

            if (credentials.getUsername().equals("Frederik") &&
            credentials.getPassword().equals("hemmeligtkodeord")) 
            {
                SystemLog.logEndl("Authentication was successful!", Severity.INFO);
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