import org.springframework.security.access.AccessDeniedException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingConfiguration {
    private static final Logger logger = LogManager.getLogger(LoggingConfiguration.class);

    public static void main(String[] args) {
        // Assuming there is a logger configuration that allows setting the level programmatically:
        logger.atLevel(Level.OFF).log(() -> new AccessDeniedException("Access is denied"));
    }
}