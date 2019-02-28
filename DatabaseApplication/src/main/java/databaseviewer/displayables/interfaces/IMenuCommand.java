package databaseviewer.displayables.interfaces;

public interface IMenuCommand 
{
    public abstract boolean isAdminOnly();
    public abstract String getName();
    public abstract void run();
}