import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp79 extends HttpServlet {
    public static void main(String[] args) {
        // No main logic needed for servlet, this is just a placeholder.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");

        try {
            request.login(username, password);
            // Redirect to a protected page or perform other actions after successful login.
        } catch (ServletException e) {
            // Handle the exception and display an error message if necessary.
        }
    }
}