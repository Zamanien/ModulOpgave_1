package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.ScreenNavigator;
import databaseviewer.menus.interfaces.IMenuCommand;

public class OptionsMenu extends ConsoleMenu
{
    public OptionsMenu() {
        groupIndexes.add(2);
    }

    @Override
    protected String getName() 
    {
        return "OPTIONS";
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
                public void run(){

                }
            
                @Override
                public String getName() {
                    return "User options";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run(){
                    ScreenNavigator.getInstance().navigate(new StartMenu());
                }
            
                @Override
                public String getName() {
                    return "Back";
                }
            }
        )

        );
    }
}