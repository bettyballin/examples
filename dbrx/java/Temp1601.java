import java.util.logging.Logger;

public class Temp1601 {
    private static final Logger logger = Logger.getLogger(Temp1601.class.getName());

    public static void main(String[] args) {
        String username = "exampleUser";  // Assuming you have a username to log
        logger.info(String.format("User %s has a password", username));
    }
}