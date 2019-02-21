package databaseviewer.services.login;

public final class LoginService {
    private LoginService() {
    }

    public static boolean authenticate(String username, String password) {
        System.out.println("\nAuthenticating credentials...");

        // TEST
        // TODO: Find safe way to check against stored user/pass pairs ?
        if (username.equals("Frederik") && password.equals("hemmeligtkodeord")) {
            System.out.printf("Authentication successful!\nWelcome %s\n", username);

            try 
            {
                Thread.sleep(2000);
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}