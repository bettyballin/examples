import javax.servlet.http.*;
import javax.servlet.annotation.WebListener;

@WebListener
public final class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(final HttpSessionEvent se) {
        // Log session creation if needed
    }

    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
        // Log the event here
        System.out.println("Session destroyed: " + se.getSession().getId());

        /*
         * You can also log additional information like user details
         * timestamps and other relevant data to help debug your issue
         */
    }
}