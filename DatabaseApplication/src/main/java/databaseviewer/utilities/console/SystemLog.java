package databaseviewer.utilities.console;

public final class SystemLog 
{
    private static Severity severity = Severity.INFO;

    private SystemLog() {}

    public static Severity getSeverity() {
        return severity;
    }

    public static void setSeverity(Severity severity) {
        SystemLog.severity = severity;
    }

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
        //Check if user severity level is higher or equal to the log severity. 
        if (SystemLog.getSeverity().getNum() >= severity.getNum()) 
        {
            System.out.printf("%s%s\n", sevStamp, msg);
        }
    }

    public enum Severity
    {
        DEBUG(4),
        FATAL(3),
        WARNING(2),
        ERROR(1),
        INFO(0);

        private int level;

        Severity(int num)
        {
            this.level = num;
        }

        public int getNum() 
        {
            return level;
        }
    }
}