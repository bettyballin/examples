import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyHttpSessionEventPublisher extends HttpSessionEventPublisher implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Custom initialization logic if needed
        super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Custom cleanup logic if needed
        super.contextDestroyed(sce);
    }
}