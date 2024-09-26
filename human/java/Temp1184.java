import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.security.web.session.HttpSessionEventPublisher;

public class MyListener implements ServletContextListener {

    private HttpSessionEventPublisher httpSessionEventPublisher = new HttpSessionEventPublisher();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        httpSessionEventPublisher.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        httpSessionEventPublisher.contextDestroyed(sce);
    }

    public static void main(String[] args) {
        // Testing the listener (not typically done in a real application)
        MyListener listener = new MyListener();
        ServletContextEvent event = new ServletContextEvent(null); // null for simplicity
        listener.contextInitialized(event);
        listener.contextDestroyed(event);
    }
}