package databaseviewer.displayables.menus;

import java.util.Arrays;

import databaseviewer.displayables.menus.MenuScreen;
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

                @Override
                public boolean isAdminOnly() {
                    return false;
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run()
                {
                    changeUserSettings();
                }
            
                @Override
                public String getName() {
                    return "User options";
                }

                @Override
                public boolean isAdminOnly() {
                    return false;
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

                @Override
                public boolean isAdminOnly() {
                    return false;
                }
            }
        )

        );
    }

    public void changeUserSettings()
    {

    }

}