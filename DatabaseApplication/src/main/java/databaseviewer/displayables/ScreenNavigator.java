package databaseviewer.displayables;

import java.util.ArrayList;

import databaseviewer.utilities.console.ConsoleManager;
import databaseviewer.utilities.console.InputManager;

public class ScreenNavigator 
{
    private Screen currentScreen;
    private Screen previousScreen;

    private ArrayList<Screen> loadedScreens = new ArrayList<Screen>();

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
        //Initializing prev screen
        if (currentScreen != null) {
            previousScreen = currentScreen;
        }

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
        Screen lScreen = getAlreadyLoadedScreen(screen);
        if (lScreen != null)
        {
            setCurrentDisplay(lScreen);
        } 
        else
        {
            loadedScreens.add(screen);
            setCurrentDisplay(screen);
        }
        redrawScreen();
        waitForUserCmd();
    }

    public void goBack()
    {
        if (previousScreen != null) {
            navigate(previousScreen);
        }
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

    /**
     * Searches through the Arraylist<Screen> loadedScreens, to see if it
     * already contains an object with the same class. If so, we 
     * reuse it.
     */
    private Screen getAlreadyLoadedScreen(Screen screen)
    {
        for (Screen s : loadedScreens) {
            if (screen.getClass().equals(s.getClass())) 
            {
                return s;    
            }
        }
        return null;
    }

    private void waitForUserCmd()
    {
        currentScreen.runCommand(InputManager.getByteInputRange((byte)0, (byte)cmdsLength)); 
    }
}