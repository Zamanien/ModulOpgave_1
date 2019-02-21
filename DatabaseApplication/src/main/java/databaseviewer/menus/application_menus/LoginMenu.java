package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.interfaces.IDisplayable;
import databaseviewer.menus.interfaces.IMenuCommand;
import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.ScreenNavigator;
import databaseviewer.services.login.LoginService;
import databaseviewer.utilities.console.InputManager;

public class LoginMenu extends ConsoleMenu
{

    @Override
    protected void setCommandList() 
    {
        commandList.addAll(Arrays.asList(
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    String username, password;
                    System.out.print(" Username: ");
                    username = InputManager.getInput();
                    System.out.print(" Password: ");
                    password = InputManager.getInput();

                    if (LoginService.authenticate(username, password))
                    {

                    }
                    System.out.println("Authentication failed!");
                    InputManager.continuePrompt();
                    ScreenNavigator.getInstance().redrawMenu();
                }

                @Override
                public String getName() {
                    return "As admin";
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
    protected String getName() {
        return "Login";
    }

}