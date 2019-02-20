package databaseviewer.menus;

import databaseviewer.utilities.console.ConsoleManager;
import databaseviewer.utilities.console.InputManager;

public class MenuNavigator 
{
    
    private ConsoleMenu currentMenu;
    private int cmdsLength;
    
    private static MenuNavigator instance = null;

    private MenuNavigator() {}

    public static MenuNavigator getInstance()
    {
        if (instance == null) 
        {
            instance = new MenuNavigator();    
        }
        return instance;
    }

    public ConsoleMenu getCurrentMenu() 
    {
        return currentMenu;
    }
    private void setCurrentMenu(ConsoleMenu menu)
    {
        this.currentMenu = menu;
        cmdsLength = menu.commandList.size()-1;
    }
    
    /**
     * This function switches between menus, that will be drawn to screen and interacted with.
     * @param menu The desired menu to be navigated to
     */
    public void navigate(ConsoleMenu menu)
    {
        setCurrentMenu(menu);
        ConsoleManager.clearScreen();    
        menu.prompt();
        menu.runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength));
    }

    public void redrawMenu()
    {
        ConsoleManager.clearScreen();
        currentMenu.prompt();
        currentMenu.runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength));
    }
}