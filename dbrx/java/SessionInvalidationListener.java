import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionInvalidationListener implements HttpSessionListener {
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpServletRequest request = (HttpServletRequest) se.getSession().getAttribute("request");
        if (request != null && !request.getRequestURI().contains("/login")) {  
            HttpServletResponse response = (HttpServletResponse) se.getSession().getAttribute("response");
            if(response != null) {
                try {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");  
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("request", null);
        se.getSession().setAttribute("response", null);
    }
}