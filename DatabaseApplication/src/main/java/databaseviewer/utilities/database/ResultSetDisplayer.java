package databaseviewer.utilities.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetDisplayer 
{
    
    private ResultSetDisplayer() {}
    
    //TODO: Clean up this messy code
    public static void display(ResultSet set) 
    {
        ResultSetMetaData rsmd = null;
        int columnCount;

        System.out.println();

        try 
        {
            rsmd = set.getMetaData();
            columnCount = rsmd.getColumnCount();
            int[] longestDataLength = new int[columnCount];

            //Find longest data length in each column
            set.beforeFirst();
            while (set.next()) 
            {
                for (int i = 0; i < columnCount; i++) 
                {
                    if (longestDataLength[i] < set.getString(i+1).length()) 
                    {
                        longestDataLength[i] = set.getString(i+1).length();
                    }
                }
            }      

            for (int i = 0; i < columnCount; i++) 
            {
                //Check if column name length is longer than longest data
                if (rsmd.getColumnName(i+1).length() > longestDataLength[i]) 
                {
                    longestDataLength[i] = rsmd.getColumnName(i+1).length();
                }

                if (i == columnCount-1) {
                    System.out.printf(" %s\n", rsmd.getColumnName(i+1));
                } 
                else
                {
                    int fillCount = longestDataLength[i] - rsmd.getColumnName(i+1).length();
                    String fill = new String(new byte[fillCount]).replaceAll("\0", " ") + " │";
                    System.out.printf(" %s" + fill, rsmd.getColumnName(i+1));
                }
            }

            //Draw line under column names
            for (int i = 0; i < longestDataLength.length; i++) 
            {
                int fillCount = longestDataLength[i]+1;

                if (i < longestDataLength.length - 1) {
                    System.out.print(new String(new byte[fillCount]).replaceAll("\0", "─") + "─┼");
                    continue;
                }
                System.out.print(new String(new byte[fillCount + 2]).replaceAll("\0", "─"));
            }
            System.out.println();


            String data = null;
            int fillCount = 0;

            set.beforeFirst();
            while (set.next())
            {
                for (int i = 0; i < columnCount; i++) 
                {
                    data = set.getString(i+1);
                    fillCount = longestDataLength[i] - data.length() + 1;
                    String dataLine = String.format(" %s" + new String(new byte[fillCount]).replaceAll("\0", " "), data);

                    if (i < columnCount-1) 
                    {
                        System.out.print(dataLine + "│");
                        continue;
                    }
                    System.out.print(dataLine);
                }
                System.out.println();
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }
}