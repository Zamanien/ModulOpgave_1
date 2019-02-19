package databaseviewer.utilities;

public final class SystemLog 
{
    private SystemLog() {}

    /**
     * Prompts messages to the console based on severity setting.
     * @param msg Message to be prompted
     * @param severity The severity/importance of the message
     */
    public static void logEndl(String msg, Severity severity)
    {
        String sevStamp = "";
        switch (severity) {
            case FATAL:
                sevStamp = "[FATAL]: ";
                break;
            case ERROR:
                sevStamp = "[ERROR]: ";
                break;
            case WARNING:
                sevStamp = "[WARNING]: ";
                break;
            case INFO:
                sevStamp = "[INFO]: ";
                break;
            case DEBUG:
                sevStamp = "[DEBUG]: ";
                break;
            default:
                break;
        }
        System.out.printf("%s%s\n", sevStamp, msg);
    }

    public enum Severity
    {
        FATAL,
        ERROR,
        WARNING,
        INFO,
        DEBUG
    }
}