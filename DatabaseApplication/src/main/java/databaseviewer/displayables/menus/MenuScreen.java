package databaseviewer.displayables.menus;

import java.util.ArrayList;
import java.util.List;

import databaseviewer.displayables.Screen;

public abstract class MenuScreen extends Screen
{
    public static final int MIN_NAME_SPACE = 15; 

    protected List<Integer>  groupIndexes;
    private int longestIndex;
    private int longestIndexLength;

    public MenuScreen() 
    {
        groupIndexes = new ArrayList<Integer>();
        setLongestIndex();
    }

    protected abstract String getName();

    @Override
    public void display()
    {
        System.out.printf("\n    ░▒▒▓▓ %s ▓▓▒▒░\n\n", getName());

        for (int i = 0; i < commands.size(); i++) 
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
                System.out.println(String.format("│ [%s] │ %s │", i, commands.get(i).getName()));
            } 
            else
            {
                int diff = longestIndexLength - commands.get(i).getName().length();
                System.out.print(String.format("│ [%s] │ %s" + new String(new char[diff+1]).replace('\0', ' ') + "│" + "\n" , i, commands.get(i).getName()));
            }

        }
        System.out.println();
    }

    private void setLongestIndex()
    {
        int index = 0;

        for (int i = 0; i < commands.size(); i++) 
        {
            if (commands.get(index).getName().length() < commands.get(i).getName().length()) {
                index = i;
            }    
        }
        
        longestIndex = index;
        longestIndexLength = commands.get(longestIndex).getName().length();
    }
}