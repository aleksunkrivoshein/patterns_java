package patterns.chain_of_responsibility;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {

        SMSLogger logger0 = new SMSLogger(Level.ERROR);
        FileLogger logger1 = new FileLogger(Level.DEBUG);
        EmailLogger logger2 = new EmailLogger(Level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("All right", Level.INFO);
        logger0.writeMessage("Debug", Level.DEBUG);
        logger0.writeMessage("THE END", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger {
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger {
    int priority;
    Logger next;

    public SMSLogger(int priority) {
        this.priority = priority;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("SMS: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    public void setNext(Logger next) {
        this.next = next;
    }
}

class FileLogger implements Logger {
    int priority;
    Logger next;

    public FileLogger(int priority) {
        this.priority = priority;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Writes in file: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    public void setNext(Logger next) {
        this.next = next;
    }
}

class EmailLogger implements Logger {
    int priority;
    Logger next;

    public EmailLogger(int priority) {
        this.priority = priority;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Email: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    public void setNext(Logger next) {
        this.next = next;
    }
}
