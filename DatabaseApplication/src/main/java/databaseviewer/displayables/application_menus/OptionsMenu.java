package databaseviewer.displayables.application_menus;

import java.util.Arrays;

import databaseviewer.displayables.MenuScreen;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.displayables.interfaces.IMenuCommand;

public class OptionsMenu extends MenuScreen
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
                    ScreenNavigator.getInstance().goBack();
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