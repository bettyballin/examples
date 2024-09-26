import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;

@RestController
public class Temp674 {

    private static final Logger logger = LoggerFactory.getLogger(Temp674.class);

    @Autowired
    private SessionRegistry sessionRegistry;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Temp674.class, args);
    }

    @GetMapping(value="/endsession")
    public String endSession(@RequestParam String sessionId, Principal principal) {
        logger.info("Removing sessionID = " + sessionId);       
        sessionRegistry.getSessionInformation(sessionId).expireNow();

        return "activeusers";
    }
}