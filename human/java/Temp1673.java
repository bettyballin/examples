import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Temp1673 implements ServletContextListener {
    public static void main(String[] args) {
        // This is not how a ServletContextListener is usually executed.
        // Normally, the web container will call the methods.
        System.out.println("This is a ServletContextListener example.");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        boolean secure = true; // Set this to whatever value you need
        sce.getServletContext().getSessionCookieConfig().setSecure(secure);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup code can go here
    }
}