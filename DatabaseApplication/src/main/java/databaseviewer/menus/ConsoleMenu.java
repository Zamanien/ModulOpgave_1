package databaseviewer.menus;

import java.util.ArrayList;
import java.util.List;

public abstract class ConsoleMenu 
{
    protected List<IMenuCommand> commandList;
    protected int longestIndex;

    public ConsoleMenu() 
    {
        commandList = new ArrayList<IMenuCommand>();
        setCommandList();
        setLongestIndex();
    }

    protected abstract String getName();
    protected abstract void setCommandList();
    
    public boolean runCommand(byte c)
    {
        try 
        {
            if (commandList.size() >= c) 
            {
                commandList.get(c).run();
                return true;
            }
        } 
        catch (Exception e) 
        {
            
        }
        return false;
    }


    public void prompt()
    {
        System.out.printf("\n    ░▒▒▓▓ %s ▓▓▒▒░\n\n", getName());
        for (int i = 0; i < commandList.size(); i++) 
        {
            if (i == longestIndex) 
            {
                System.out.println(String.format("░ [%s] ░ %s ░", i, commandList.get(i).getName()));
            } 
            else
            {
                int diff = commandList.get(longestIndex).getName().length() - commandList.get(i).getName().length();
                System.out.print(String.format("░ [%s] ░ %s" + new String(new char[diff+1]).replace('\0', ' ') + "░" + "\n" , i, commandList.get(i).getName()));
            }

        }
        System.out.println();
    }

    private void setLongestIndex()
    {
        int index = 0;

        for (int i = 0; i < commandList.size(); i++) 
        {
            if (commandList.get(index).getName().length() < commandList.get(i).getName().length()) {
                index = i;
            }    
        }
        longestIndex = index;
    }
}