import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new session cookie with the HttpOnly flag
        Cookie cookie = new Cookie("JSESSIONID", "mySessionId");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        // Rest of your code
    }
}