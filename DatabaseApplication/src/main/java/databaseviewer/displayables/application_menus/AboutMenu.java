package databaseviewer.displayables.application_menus;

import java.util.Arrays;

import databaseviewer.displayables.MenuScreen;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.displayables.interfaces.IMenuCommand;

public class AboutMenu extends MenuScreen 
{

    public AboutMenu() {
        groupIndexes.add(2);
    }

    @Override
    protected String getName() {
        return "ABOUT";
    }

    @Override
    protected void addCommands() 
    {
        commands.addAll(Arrays.asList(
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                   
                }
            
                @Override
                public String getName() {
                    return "About program";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run() {
                    
                }
            
                @Override
                public String getName() {
                    return "About the database";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    ScreenNavigator.getInstance().navigate(new StartMenu());
                }   
            
                @Override
                public String getName() {
                    return "Back";
                }
            }
        ));
    }


}