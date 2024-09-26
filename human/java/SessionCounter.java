import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {
    private int counter = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        counter++;
        System.out.println("Total sessions created " + counter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Implement logic for session destruction if needed
    }

    public static void main(String[] args) {
        // Since this code is meant to run in a servlet container, 
        // the main method typically won't be used. 
        // HttpSessionListener methods are called by the servlet container.
    }
}