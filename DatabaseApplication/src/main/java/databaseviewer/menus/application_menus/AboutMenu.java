package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.interfaces.IMenuCommand;

public class AboutMenu extends ConsoleMenu {

    @Override
    protected String getName() {
        return "About";
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
            }
        ));
    }


}