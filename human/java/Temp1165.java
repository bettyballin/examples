import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.springframework.security.core.AuthenticationException;

public class Temp1165 {

    private String defaultFailureUrl;
    private boolean forwardToDestination;
    private RedirectStrategy redirectStrategy;
    private Logger logger = LoggerFactory.getLogger(Temp1165.class);

    public static void main(String[] args) {
        // Main method implementation here if needed
    }

    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        if (this.defaultFailureUrl == null) {
            this.logger.debug("No failure URL set, sending 401 Unauthorized error");
            response.sendError(401, "Authentication Failed: " + exception.getMessage());
        } else {
            saveException(request, exception);

            if (this.forwardToDestination) {
                this.logger.debug("Forwarding to " + this.defaultFailureUrl);
                request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
            } else {
                this.logger.debug("Redirecting to " + this.defaultFailureUrl);
                this.redirectStrategy.sendRedirect(request, response,
                        this.defaultFailureUrl);
            }
        }
    }

    private void saveException(HttpServletRequest request, AuthenticationException exception) {
        // Implement save exception logic here
    }

    interface RedirectStrategy {
        void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException;
    }

    interface Logger {
        void debug(String message);
    }

    static class LoggerFactory {
        public static Logger getLogger(Class<?> clazz) {
            return new Logger() {
                @Override
                public void debug(String message) {
                    System.out.println("DEBUG: " + message);
                }
            };
        }
    }
}