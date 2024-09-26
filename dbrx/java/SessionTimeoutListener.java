import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;

public class SessionTimeoutListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {}

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        HttpServletRequest req = (HttpServletRequest) context.getAttribute("javax.servlet.request");
        HttpServletResponse resp = (HttpServletResponse) context.getAttribute("javax.servlet.response");

        if (req != null && resp != null) {
            try {
                String contextPath = context.getContextPath();
                req.setAttribute("message", "Session Expired");
                resp.sendRedirect(contextPath + "/login.jsp?message=Session%20Expired");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}