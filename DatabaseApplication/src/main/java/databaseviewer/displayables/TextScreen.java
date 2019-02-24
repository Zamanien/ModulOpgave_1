package databaseviewer.displayables;

import databaseviewer.displayables.interfaces.IDisplayable;

public abstract class TextScreen implements IDisplayable 
{
    private final char lineChar = '│';

    public abstract String[] getText();
    
    @Override
    public void display() 
    {
        for (int i = 0; i < getText().length; i++) 
        {
            System.out.printf(" %s %s\n", lineChar, getText()[i]);  
        }
    }

    public static String[] toStringArray(String text, String token)
    {
        return text.split(token);
    }
}