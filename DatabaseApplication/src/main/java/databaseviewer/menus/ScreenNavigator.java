package databaseviewer.menus;

import databaseviewer.menus.interfaces.IDisplayable;
import databaseviewer.utilities.console.ConsoleManager;
import databaseviewer.utilities.console.InputManager;

public class ScreenNavigator 
{
    
    private IDisplayable currentDisplay;
    private int cmdsLength;
    
    private static ScreenNavigator instance = null;

    private ScreenNavigator() {}

    public static ScreenNavigator getInstance()
    {
        if (instance == null) 
        {
            instance = new ScreenNavigator();    
        }
        return instance;
    }

    public IDisplayable getCurrentMenu() 
    {
        return currentDisplay;
    }
    private void setCurrentMenu(IDisplayable display)
    {
        this.currentDisplay = display;
        cmdsLength = ((ConsoleMenu)display).commandList.size()-1;
    }
    
    /**
     * This function switches between menus, that will be drawn to screen and interacted with.
     * @param display The desired menu to be navigated to
     */
    public void navigate(IDisplayable display)
    {
        setCurrentMenu(display);
        ConsoleManager.clearScreen();    
        display.display();
        display.runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength));
    }

    public void redrawMenu()
    {
        ConsoleManager.clearScreen();
        currentDisplay.display();
        currentDisplay.runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength));
    }
}