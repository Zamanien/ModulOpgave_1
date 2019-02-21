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
    
    public void start(IDisplayable startDisplay)
    {
        //init
        this.currentDisplay = startDisplay;
        this.cmdsLength = ((ConsoleMenu)currentDisplay).commandList.size()-1;
        startDisplay.display();

        //Program loop
        while (true) 
        {
            loop(); 
        }
    }

    /**
     * This function switches between menus, that will be drawn to screen and interacted with.
     * @param display The desired menu to be navigated to
     */
    public void navigate(IDisplayable display)
    {
        this.currentDisplay = display;
        this.cmdsLength = ((ConsoleMenu)currentDisplay).commandList.size()-1;
        redrawScreen();
        waitForUserCmd();
    }
    
    public void redrawScreen()
    {
        ConsoleManager.clearScreen();
        currentDisplay.display();
    }

    private void loop()
    {
        redrawScreen();
        waitForUserCmd();
    }

    private void waitForUserCmd()
    {
        ((ConsoleMenu)currentDisplay).runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength));
    }
}