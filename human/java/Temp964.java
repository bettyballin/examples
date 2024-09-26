import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;

public class Temp964 {
    private static final Logger logger = Logger.getLogger(Temp964.class);

    public static void main(String[] args) {
        // Configure logger
        BasicConfigurator.configure();
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);

        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setTarget("System.out");
        consoleAppender.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));
        consoleAppender.activateOptions();
        rootLogger.addAppender(consoleAppender);

        Logger springSecurityLogger = Logger.getLogger("org.springframework.security");
        springSecurityLogger.setLevel(Level.DEBUG);

        // Test log messages
        logger.info("This is an info message.");
        springSecurityLogger.debug("This is a debug message from Spring Security logger.");
    }
}