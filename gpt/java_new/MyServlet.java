import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.login("runAsUser", "runAsUserPassword");
            // Perform operations under the new user context
        } catch (ServletException e) {
            // Handle login failure
            throw new ServletException("Login failed", e);
        }
    }
}