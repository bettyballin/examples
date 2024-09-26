import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter1 implements HttpSessionListener {
    private static int counter = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent event) {
        counter++;
        System.out.println("Total sessions created: " + counter);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent event) {
        counter--;
        System.out.println("Total sessions destroyed: " + counter);
    }

    public static synchronized int getActiveSessions() {
        return counter;
    }
}