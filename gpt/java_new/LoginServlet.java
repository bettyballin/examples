import javax.servlet.http.HttpSession;
import your.package.User;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ... your user authentication logic here

        // Assuming 'user' is fetched from database after successful authentication
        User user = // ... fetch user from database
        
        // Get the session from request, create one if not present
        HttpSession session = request.getSession(true);
        
        // Store the user object in the session
        session.setAttribute("user", user);
        
        // ... rest of the login logic
    }
}