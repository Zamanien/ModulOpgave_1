package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.interfaces.IMenuCommand;

public class OptionsMenu extends ConsoleMenu
{
    @Override
    protected String getName() 
    {
        return "Options";
    }

    @Override
    protected void setCommandList() 
    {
        commandList.addAll(Arrays.asList(
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    
                }
            
                @Override
                public String getName() {
                    return "Severity level";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run() 
                {

                }
            
                @Override
                public String getName() {
                    return "User options";
                }
            }
        )

        );
    }
}