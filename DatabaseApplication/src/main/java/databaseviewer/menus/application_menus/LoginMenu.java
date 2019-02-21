package databaseviewer.menus.application_menus;

import java.io.IOException;
import java.util.Arrays;

import databaseviewer.menus.interfaces.IMenuCommand;
import databaseviewer.services.login.LoginService;
import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.ScreenNavigator;
import databaseviewer.utilities.console.InputManager;
import databaseviewer.utilities.settings.UserSettings;
import databaseviewer.utilities.settings.UserSettings.UserRights;
import jline.ConsoleReader;


public class LoginMenu extends ConsoleMenu
{
    private static final Character P_MASK = '*';

    public LoginMenu() 
    {
        groupIndexes.add(2);
    }

    @Override
    protected void setCommandList() 
    {
        commandList.addAll(Arrays.asList(
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

                    try 
                    {
                        //USERNAME
                        System.out.print("Username: ");
                        username = System.console().readLine();

                        //PASSWORD
                        ConsoleReader reader = new ConsoleReader();
                        password = reader.readLine("Password: ", P_MASK);  
                    } 
                    catch (IOException e) {}
                    
                   if (LoginService.authenticate(username, password))
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
            }
        ));
    }

    @Override
    protected String getName() 
    {
        return "LOGIN";
    }

}