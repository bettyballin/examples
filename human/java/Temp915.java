import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.annotation.WebListener;

@WebListener
public class CustomHttpSessionEventPublisher extends HttpSessionEventPublisher {
    // Additional custom methods or overrides can be placed here if needed
}