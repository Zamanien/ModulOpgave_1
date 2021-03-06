package databaseviewer.settings;

import databaseviewer.utils.console.LogManager;
import databaseviewer.utils.console.LogManager.Severity;

public final class UserSettings 
{
    private static OSType ostype;
    private static UserRights userRights;
    private static String name;

    private UserSettings() {}

    public static OSType getOSType()
    {
        return ostype;
    }
    public static UserRights getUserRights()
    {
        return userRights;
    }

    public static void setUserRights(UserRights rights)
    {
        userRights = rights;
    }

    public static void collect()
    {
        try 
        {
            collectOSType();
            collectName();
        } 
        catch (Exception e) 
        {
            LogManager.logEndl("User settings couldn't be collected!", Severity.WARNING);
            LogManager.logEndl("UserRights has been set to USER", Severity.WARNING);
            LogManager.logEndl("OSType has been set to other", Severity.WARNING);
        }
    }

    private static void collectName()
    {
        name = System.getProperty("user.name");
        LogManager.logEndl(String.format("Name: %s", name), Severity.DEBUG);
    }

    private static void collectOSType()
    {
        String os = System.getProperty("os.name").toLowerCase();
        LogManager.logEndl(String.format("OS: %s", os), Severity.DEBUG);
        
        if (os.contains("windows"))
        {
            ostype = OSType.WINDOWS;
        }
        else if (os.contains("mac"))
        {
            ostype = OSType.MAC;
        } 
        else if (os.contains("linux"))
        {
            ostype = OSType.LINUX;
        }
        else 
        {
            ostype = OSType.OTHER;
        }
    }

    public static void wipeSessionInfo()
    {
        userRights = UserRights.USER;
    }

    public static enum OSType
    {
        WINDOWS,
        MAC,
        LINUX,
        OTHER
    }

    //Redundant? binary 
    public static enum UserRights
    {
        USER,
        ADMIN
    }
}