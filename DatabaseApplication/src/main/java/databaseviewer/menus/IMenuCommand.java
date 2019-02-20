package databaseviewer.menus;

public interface IMenuCommand 
{
    abstract String getName();
    abstract void run();
}