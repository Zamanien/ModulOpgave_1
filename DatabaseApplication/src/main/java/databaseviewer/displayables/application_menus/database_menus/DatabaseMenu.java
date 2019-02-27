package databaseviewer.displayables.application_menus.database_menus;

import java.util.Arrays;

import databaseviewer.displayables.MenuScreen;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.displayables.interfaces.IMenuCommand;

public class DatabaseMenu extends MenuScreen
{
    public DatabaseMenu() {
        groupIndexes.add(1);
    }

    @Override
    protected String getName() {
        return "Database Menu";
    }

    @Override
    protected void addCommands() {
        commands.addAll(Arrays.asList(

            new IMenuCommand()
            {

                    @Override
                    public String getName() {
                        return "Run SQL script";
                    }

                    @Override
                    public void run() {

                    }
                
            },
            new IMenuCommand()
            {

                    @Override
                    public String getName() {
                        return "Back";
                    }

                    @Override
                    public void run() {
                        ScreenNavigator.getInstance().goBack();
                    }
                
            }
        ));
    }
    
}