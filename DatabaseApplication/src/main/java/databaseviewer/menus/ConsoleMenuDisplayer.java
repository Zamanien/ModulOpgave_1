package databaseviewer.menus;

public class ConsoleMenuDisplayer 
{
    private ConsoleMenu currentMenu;

    public ConsoleMenu getCurrentMenu() 
    {
        return currentMenu;
    }

    public ConsoleMenuDisplayer(ConsoleMenu menu) 
    {
        this.currentMenu = menu;
    }

    public void exit()
    {
        
    }
}