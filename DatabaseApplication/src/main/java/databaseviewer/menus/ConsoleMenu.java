package databaseviewer.menus;

import java.util.ArrayList;
import java.util.List;

import databaseviewer.menus.interfaces.IDisplayable;
import databaseviewer.menus.interfaces.IMenuCommand;

public abstract class ConsoleMenu implements IDisplayable
{
    public static final int MIN_NAME_SPACE = 15; 

    protected List<IMenuCommand> commandList;
    protected List<Integer>  groupIndexes;
    private int longestIndex;
    private int longestIndexLength;

    public ConsoleMenu() 
    {
        commandList = new ArrayList<IMenuCommand>();
        groupIndexes = new ArrayList<Integer>();
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

    @Override
    public void display()
    {
        System.out.printf("\n    ░▒▒▓▓ %s ▓▓▒▒░\n\n", getName());

        for (int i = 0; i < commandList.size(); i++) 
        {
            //Handles grouping rows
            if (groupIndexes.contains(i))
            {
                String grouping = "├";
                for (int j = 0; j < longestIndexLength + 8; j++) 
                {
                    if (j == 5) 
                    {
                        grouping += "┼";
                        continue;    
                    }
                    grouping += "─";
                }
                grouping += "┤";

                System.out.println(grouping);
            }

            //Handles individual command rows
            if (i == longestIndex) 
            {
                System.out.println(String.format("│ [%s] │ %s │", i, commandList.get(i).getName()));
            } 
            else
            {
                int diff = longestIndexLength - commandList.get(i).getName().length();
                System.out.print(String.format("│ [%s] │ %s" + new String(new char[diff+1]).replace('\0', ' ') + "│" + "\n" , i, commandList.get(i).getName()));
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
        longestIndexLength = commandList.get(longestIndex).getName().length();
    }
}