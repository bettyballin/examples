import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp477 {
    public static void main(String[] args) {
        // Main method is left empty as the main execution part is in onAuthenticationSuccess method.
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException {
        String context = request.getContextPath();
        String fullURL = request.getRequestURI();
        String url = fullURL.substring(fullURL.indexOf(context) + context.length());

        // Redirect to the original URL
        response.sendRedirect("/" + url);
    }

    // Authentication class stub to make the code compile
    public class Authentication {
        // Add authentication properties and methods if needed
    }
}