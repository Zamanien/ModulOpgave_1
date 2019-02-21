package databaseviewer.utilities.console;

import java.util.Scanner;

import databaseviewer.menus.ScreenNavigator;

public final class InputManager 
{
    private static final int WRONG_COUNT_BEFORE_CLEAR = 4;

    private static Scanner scanner = new Scanner(System.in);
    private static int wrongs = 0;

    private InputManager() {}

    public static String getInput()
    {
        System.out.print("> ");
        return scanner.nextLine();
    }

    public static void continuePrompt()
    {
        System.out.print("Continue. . .");
        try 
        {
            System.in.read();
        } 
        catch (Exception e) 
        {
            
        }
    }

    public static int getInteger()
    {
        String input = getInput();

        while (true) 
        {
            try 
            {
                return Integer.parseInt(input);  
            } 
            catch (Exception e) {}

            if (++wrongs >= WRONG_COUNT_BEFORE_CLEAR) { 
                wrongs = 0; 
                ScreenNavigator.getInstance().redrawMenu(); 
            }
            System.out.println("Input must be of type integer i.e 0,1,2..");
            input = getInput();
        }
    }

    public static int getFloat()
    {
        String input = getInput();

        while (true) 
        {
            try 
            {
                return Integer.parseInt(input);  
            } 
            catch (Exception e) {}

            if (++wrongs >= WRONG_COUNT_BEFORE_CLEAR) { 
                wrongs = 0; 
                ScreenNavigator.getInstance().redrawMenu(); 
            }
            System.out.println("Input must be of type float i.e 0.175f, 3.1415f");
            input = getInput();
        }
    }

    public static byte getByteInput() 
    {
        String input = getInput();
        
        while (true) 
        {
            try 
            {
                return Byte.parseByte(input);  
            } 
            catch (Exception e) {}

            if (++wrongs >= WRONG_COUNT_BEFORE_CLEAR) { 
                wrongs = 0; 
                ScreenNavigator.getInstance().redrawMenu(); 
            }
            System.out.println("Input must be of type signed-byte i.e 0 to 127");
            input = getInput();
        }
    }
    
    public static byte getByteInputRange(byte min, byte max)
    {
        String input = getInput();
        
        while (true) 
        {
            try 
            {
                byte val = Byte.parseByte(input);  
                if (val >= min && val <= max) 
                {
                    return val; 
                }
            } 
            catch (Exception e) 
            {
            }
            if (++wrongs >= WRONG_COUNT_BEFORE_CLEAR) { 
                wrongs = 0; 
                ScreenNavigator.getInstance().redrawMenu();
            }
            System.out.println(String.format("Input must be in the range of %s to %s", min, max));
            input = getInput();
        }
    }
}