import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Temp138 {
    private static final Logger LOG = Logger.getLogger(Temp138.class.getName());

    public static void main(String[] args) {
        // Example usage
    }

    public static String safeGetParameter(final HttpServletRequest request, final String parameter) {
        // Add this line
        if (!"logoutRequest".equals(parameter)) {
            return request.getParameter(parameter);
        }

        if ("POST".equals(request.getMethod()) && "logoutRequest".equals(parameter)) {
            LOG.warning("safeGetParameter called on a POST HttpServletRequest for LogoutRequest. Cannot complete check safely. Reverting to standard behavior for this Parameter");
            return request.getParameter(parameter);
        }

        // Rest of the code
        return null; // Placeholder return statement
    }
}