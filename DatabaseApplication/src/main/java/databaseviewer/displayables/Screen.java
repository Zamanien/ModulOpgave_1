package databaseviewer.displayables;

import java.util.ArrayList;

import databaseviewer.displayables.interfaces.ICommandable;
import databaseviewer.displayables.interfaces.IDisplayable;
import databaseviewer.displayables.interfaces.IMenuCommand;
import databaseviewer.settings.UserSettings;
import databaseviewer.settings.UserSettings.UserRights;
import databaseviewer.utils.console.InputManager;
import databaseviewer.utils.console.LogManager;
import databaseviewer.utils.console.LogManager.Severity;

public abstract class Screen implements IDisplayable, ICommandable
{
    protected ArrayList<IMenuCommand> commands;

    public Screen() 
    {
        commands = new ArrayList<IMenuCommand>();
        addCommands();
    }

    protected abstract void addCommands();

    public int commandsCount()
    {
        return commands.size();
    }

    @Override
    public boolean runCommand(byte c) 
    {
        IMenuCommand cmd = commands.get(c);
        ScreenNavigator.getInstance().redrawScreen();

        //Check if user is authorized to run cmd
        if (cmd.isAdminOnly() && UserSettings.getUserRights() != UserRights.ADMIN)  
        {
            LogManager.logEndl("You need admin rights to do this!", Severity.INFO);
            InputManager.continuePrompt();
            return false;
        }
        
        try 
        {
            cmd.run();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }

}