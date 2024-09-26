import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForgotPasswordForcePasswordChangeEventHandler {
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        // ... all your password change logic

        try {
            // Redirect to the restore password page
            response.sendRedirect("/path-to-restore-password-page");
        } catch (IOException e) {
            // Handle the exception (logging, etc.)
        }
    }
}