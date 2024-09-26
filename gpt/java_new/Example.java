import java.sql.SQLException;
import java.util.logging.Logger;

public class Example {
    private static final Logger logger = Logger.getLogger(Example.class.getName());

    public void exampleMethod() {
        try {
            // Some operation that can throw an SQLException
        } catch (SQLException ex) {
            // Log the stack trace for internal use
            logger.severe(ex.getMessage());
        }
    }
}