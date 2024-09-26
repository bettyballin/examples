import org.springframework.security.authentication.AbstractAuthenticationEvent;
import org.springframework.context.ApplicationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAppplicationListener implements ApplicationListener<AbstractAuthenticationEvent> {
    private static final Logger logger = LoggerFactory.getLogger(MyAppplicationListener.class);

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        // Handle the authentication event
        logger.info("Authentication event: " + event.toString());
    }
}