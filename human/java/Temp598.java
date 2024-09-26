import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MySessionListener implements ServletContextListener {

    private HttpSessionEventPublisher publisher = new HttpSessionEventPublisher();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        publisher.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        publisher.contextDestroyed(sce);
    }
}