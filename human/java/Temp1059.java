import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Temp1059 {
    private static final Logger logger = LoggerFactory.getLogger(Temp1059.class);

    public static void main(String[] args) {
        logger.debug("Invalid CSRF token found for http://localhost:8080/meltdown/bo/createnews");
    }
}


Make sure you have the SLF4J library in your classpath to run the code successfully.