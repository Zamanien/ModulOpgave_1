package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.IMenuCommand;
import databaseviewer.menus.MenuNavigator;
import databaseviewer.utilities.settings.UserSettings;

public class StartMenu extends ConsoleMenu 
{
    @Override
    protected void setCommandList() 
    {
        commandList.addAll(Arrays.asList(

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
                    MenuNavigator.getInstance().navigate(new OptionsMenu());
                }

                @Override
                public String getName(){
                    return "Options";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run()
                {
                    UserSettings.wipeSessionInfo();
                    MenuNavigator.getInstance().navigate(new LoginMenu());
                }

                @Override
                public String getName(){
                    return "Logout";
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
                        MenuNavigator.getInstance().navigate(new AboutMenu());
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
        return "Start Menu";
    }

}