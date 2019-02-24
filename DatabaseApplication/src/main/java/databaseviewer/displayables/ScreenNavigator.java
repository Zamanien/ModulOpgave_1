package databaseviewer.displayables;

import databaseviewer.utilities.console.ConsoleManager;
import databaseviewer.utilities.console.InputManager;

public class ScreenNavigator 
{
    private Screen currentScreen;
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

    public Screen getCurrentScreen() 
    {
        return currentScreen;
    }
    private void setCurrentDisplay(Screen screen)
    {
        this.currentScreen = screen;
        
        this.cmdsLength = screen.commandsCount()-1;
        
    }
    
    public void start(Screen startScreen)
    {
        //init
        setCurrentDisplay(startScreen);
        
        startScreen.display();

        //Program loop
        while (true) 
        {
            loop(); 
        }
    }

    /**
     * This function switches between menus, that will be drawn to screen and interacted with.
     * @param screen The desired menu to be navigated to
     */
    public void navigate(Screen screen)
    {
        setCurrentDisplay(screen);
        redrawScreen();
        waitForUserCmd();
    }
    
    public void redrawScreen()
    {
        ConsoleManager.clearScreen();
        currentScreen.display();
    }

    private void loop()
    {
        redrawScreen();
        waitForUserCmd();
    }

    private void waitForUserCmd()
    {
        currentScreen.runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength)); 
    }
}