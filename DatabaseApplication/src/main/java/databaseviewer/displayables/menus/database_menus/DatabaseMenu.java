package databaseviewer.displayables.menus.database_menus;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import databaseviewer.displayables.menus.MenuScreen;
import databaseviewer.utilities.console.InputManager;
import databaseviewer.utilities.console.SystemLog;
import databaseviewer.utilities.console.SystemLog.Severity;
import databaseviewer.utilities.database.ResultSetDisplayer;
import databaseviewer.database.DBConnector;
import databaseviewer.displayables.ScreenNavigator;
import databaseviewer.displayables.interfaces.IMenuCommand;

public class DatabaseMenu extends MenuScreen {
    public DatabaseMenu() {
        groupIndexes.add(2);
    }

    @Override
    protected String getName() {
        return "Database Menu";
    }

    @Override
    protected void addCommands() {
        commands.addAll(Arrays.asList(

                new IMenuCommand() {
                    @Override
                    public String getName() {
                        return "Run SQL script";
                    }

                    @Override
                    public void run() 
                    {
                        String query = System.console().readLine();

                        try 
                        {
                            Statement st = DBConnector.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = st.executeQuery(query);
                            
                            ResultSetDisplayer.display(rs);

                            st.close();
                            rs.close();
                            
                            InputManager.continuePrompt();
                        } 
                        catch (SQLException e) 
                        {
                            SystemLog.logEndl("Something went wrong executing the SQL script!", Severity.ERROR);
                            InputManager.continuePrompt();
                        }
                }
            },
            new IMenuCommand()
            {
                @Override
                public String getName() {
                    return "test";
                }

                @Override
                public void run() {

                }
            },
            new IMenuCommand()
            {
                @Override
                public String getName() {
                    return "Back";
                }

                @Override
                public void run() {
                    ScreenNavigator.getInstance().goBack();
                }
            }
        ));
    }
    
}