import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SessionController {
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(value = "/endsession", method = RequestMethod.GET)
    public String endSession(String sessionId, Principal principal) {
        logger.info("Removing sessionID = {}", sessionId);
        sessionRegistry.getSessionInformation(sessionId).expireNow();

        return "activeusers";
    }
}