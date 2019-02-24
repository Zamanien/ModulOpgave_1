package databaseviewer.displayables.application_menus;

import java.util.Arrays;

import databaseviewer.displayables.MenuScreen;
import databaseviewer.displayables.interfaces.IMenuCommand;
import databaseviewer.displayables.application_menus.OptionsMenu;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.utilities.settings.UserSettings;

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
                    
                }

                @Override
                public String getName(){
                    return "Connect to database";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run(){
                    ScreenNavigator.getInstance().navigate(new OptionsMenu());
                }

                @Override
                public String getName(){
                    return "Options";
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
                public void run()
                {
                    UserSettings.wipeSessionInfo();
                    ScreenNavigator.getInstance().navigate(new LoginMenu());
                }

                @Override
                public String getName(){
                    return "Logout";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run(){
                    System.exit(0);
                }

                @Override
                public String getName(){
                    return "Exit";
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