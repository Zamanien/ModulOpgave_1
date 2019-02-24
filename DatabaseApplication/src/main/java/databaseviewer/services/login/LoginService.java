package databaseviewer.services.login;

public final class LoginService {
    private LoginService() {
    }

    public static boolean login(UserCredentials credentials) {
        try 
        {
            System.out.println("\nAuthenticating user credentials.");

            if (credentials.getUsername().equals("Frederik") &&
            credentials.getPassword().equals("hemmeligtkodeord")) 
            {
                System.out.println("Authentication was successful!");
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