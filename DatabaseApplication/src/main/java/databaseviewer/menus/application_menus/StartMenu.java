package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.IMenuCommand;

public class StartMenu extends ConsoleMenu 
{
    @Override
    protected void setCommandList() 
    {
        commandList.addAll(Arrays.asList(

            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    
                }
            }
            ,
            new IMenuCommand(){
            
                @Override
                public void run() 
                {
                    
                }
            }

        ));
    }

    @Override
    public boolean runCommand(byte c) 
    {
        if (commandList.size() >= c) 
        {
            commandList.get(c).run();
            return true;
        }
        return false;
    }

    @Override
    public void prompt() 
    {

    }

    @Override
    public void exit() {

    }

}