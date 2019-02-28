package databaseviewer.displayables.menus;

import java.util.Arrays;

import databaseviewer.displayables.interfaces.IMenuCommand;
import databaseviewer.services.login.LoginService;
import databaseviewer.services.login.UserCredentials;
import databaseviewer.displayables.menus.MenuScreen;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.utils.console.InputManager;
import databaseviewer.settings.UserSettings;
import databaseviewer.settings.UserSettings.UserRights;

public class LoginMenu extends MenuScreen
{
    public LoginMenu() 
    {
        groupIndexes.add(2);
    }

    @Override
    protected void addCommands() 
    {
        commands.addAll(Arrays.asList(
            new IMenuCommand(){
                
                // LOGGING IN AS ADMIN 
                @Override
                public String getName() {
                    return "As admin";
                }
            
                @Override
                public void run() 
                {
                    ScreenNavigator.getInstance().redrawScreen();

                    String username = null, password = null;

                    //USERNAME
                    System.out.print("Username: ");
                    username = System.console().readLine();

                    //PASSWORD
                    System.out.print("Password: ");
                    password = new String(System.console().readPassword());
                        
                        
                    
                    if (LoginService.login(new UserCredentials(username, password)))
                    {
                        UserSettings.setUserRights(UserRights.ADMIN);
                        ScreenNavigator.getInstance().navigate(new StartMenu());
                    } 
                    else
                    {
                        System.out.println("Authentication failed!");
                        InputManager.continuePrompt();
                        ScreenNavigator.getInstance().redrawScreen();
                    }
                }

                @Override
                public boolean isAdminOnly() {
                    return false;
                }

            },
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    ScreenNavigator.getInstance().navigate(new StartMenu());
                }
            
                @Override
                public String getName() 
                {
                    return "As guest";
                }

				@Override
				public boolean isAdminOnly() {
					return false;
				}
            },
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    System.exit(0);
                }
            
                @Override
                public String getName() {
                    return "Exit";
                }

                @Override
                public boolean isAdminOnly() {
                    return false;
                }
            }
        ));
    }

    @Override
    protected String getName() 
    {
        return "LOGIN";
    }

}