package databaseviewer.menus;

import java.util.List;

public abstract class ConsoleMenu 
{
    protected List<IMenuCommand> commandList;

    protected abstract void setCommandList();
    public abstract boolean runCommand(byte c);
    public abstract void exit();

    public void prompt()
    {
        
    }
}