package databaseviewer.displayables;

import java.util.ArrayList;

import databaseviewer.displayables.interfaces.ICommandable;
import databaseviewer.displayables.interfaces.IDisplayable;
import databaseviewer.displayables.interfaces.IMenuCommand;

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
        try 
        {
            ScreenNavigator.getInstance().redrawScreen();
            commands.get(c).run();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }

}