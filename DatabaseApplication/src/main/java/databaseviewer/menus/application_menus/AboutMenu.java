package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.ScreenNavigator;
import databaseviewer.menus.interfaces.IMenuCommand;

public class AboutMenu extends ConsoleMenu 
{

    public AboutMenu() {
        groupIndexes.add(2);
    }

    @Override
    protected String getName() {
        return "ABOUT";
    }

    @Override
    protected void setCommandList() 
    {
        commandList.addAll(Arrays.asList(
            new IMenuCommand(){
            
                @Override
                public void run() {
                    
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