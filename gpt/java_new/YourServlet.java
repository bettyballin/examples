import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

public class YourServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user principal
        Principal userPrincipal = request.getUserPrincipal();

        // Get the username from the user principal
        String username = null;
        if (userPrincipal != null) {
            username = userPrincipal.getName();
        }

        // Do something with the username
        // ...
    }
}