package databaseviewer.displayables.menus;

import java.util.Arrays;

import databaseviewer.database.DBConnector;
import databaseviewer.displayables.menus.MenuScreen;
import databaseviewer.displayables.interfaces.IMenuCommand;
import databaseviewer.displayables.menus.OptionsMenu;
import databaseviewer.displayables.menus.database_menus.DatabaseMenu;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.utils.console.InputManager;
import databaseviewer.settings.UserSettings;

public class StartMenu extends MenuScreen 
{
    public StartMenu() {
        groupIndexes.add(3);
    }

    @Override
    protected void addCommands() 
    {
        commands.addAll(Arrays.asList(

            new IMenuCommand(){
            
                @Override
                public void run(){
                    DBConnector.connect();
                    InputManager.continuePrompt();
                    ScreenNavigator.getInstance().navigate(new DatabaseMenu());
                }

                @Override
                public String getName(){
                    return "Connect to database";
                }
            },
            new IMenuCommand(){
            
                @Override
                public String getName(){
                    return "Options";
                }
                
                @Override
                public void run(){
                    ScreenNavigator.getInstance().navigate(new OptionsMenu());
                }
            },
            new IMenuCommand(){
                
                @Override
                public String getName() {
                    return "About";
                }
                
                @Override
                public void run() 
                {
                    ScreenNavigator.getInstance().navigate(new AboutMenu());
                }
                
            },
            new IMenuCommand(){
            
                @Override
                public String getName(){
                    return "Logout";
                }
                
                @Override
                public void run()
                {
                    UserSettings.wipeSessionInfo();
                    ScreenNavigator.getInstance().navigate(new LoginMenu());
                }
            },
            new IMenuCommand(){
            
                @Override
                public String getName(){
                    return "Exit";
                }

                @Override
                public void run(){
                    System.exit(0);
                }
            }
        ));
    }

    @Override
    protected String getName() 
    {
        return "START MENU";
    }

}