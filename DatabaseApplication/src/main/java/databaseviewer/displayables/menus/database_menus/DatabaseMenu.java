package databaseviewer.displayables.menus.database_menus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import databaseviewer.displayables.menus.MenuScreen;
import databaseviewer.utils.console.InputManager;
import databaseviewer.utils.console.LogManager;
import databaseviewer.utils.console.LogManager.Severity;
import databaseviewer.utils.mysql.ResultSetDisplayer;
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
                            
                            //Display table
                            ResultSetDisplayer.display(rs);

                            st.close();
                            rs.close();
                            
                            InputManager.continuePrompt();
                        } 
                        catch (SQLException e) 
                        {
                            LogManager.logEndl("Something went wrong executing the SQL script!", Severity.ERROR);
                            InputManager.continuePrompt();
                        }
                }

                @Override
                public boolean isAdminOnly() {
                    return true;
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

                @Override
                public boolean isAdminOnly() {
                    return false;
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

                @Override
                public boolean isAdminOnly() {
                    return false;
                }
            }
        ));
    }
    
}