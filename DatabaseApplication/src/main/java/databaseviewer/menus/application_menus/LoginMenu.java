package databaseviewer.menus.application_menus;

import java.util.Arrays;

import databaseviewer.menus.ConsoleMenu;
import databaseviewer.menus.IMenuCommand;

public class LoginMenu extends ConsoleMenu
{

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
                    return "Login as admin";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run() {
                    
                }
            
                @Override
                public String getName() {
                    return "Login as guest";
                }
            },
            new IMenuCommand(){
            
                @Override
                public void run() {
                    System.exit(0);
                }
            
                @Override
                public String getName() {
                    return "Exit";
                }
            }
        ));
    }

    @Override
    public boolean runCommand(byte c) 
    {
        return false;
    }

    @Override
    public void prompt() {

    }

    @Override
    public void exit() {

    }

}