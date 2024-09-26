import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityContext {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private boolean authenticated = false;

    public SecurityContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void authenticate(String username, String password) throws IOException {
        // Implement authentication logic here
        // For demonstration purposes, assume successful authentication if username and password are not empty
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            authenticated = true;
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
        }
    }

    public void logout() throws IOException {
        // Implement logout logic here
        authenticated = false;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getRole() {
        // For demonstration purposes, return a dummy role
        return authenticated ? "USER" : "GUEST";
    }

    public static void main(String[] args) {
        // This main method is for demonstration and testing purposes only
        // In a real application, SecurityContext would be used within a servlet context
        HttpServletRequest request = null; // Mocked or real HttpServletRequest
        HttpServletResponse response = null; // Mocked or real HttpServletResponse

        SecurityContext securityContext = new SecurityContext(request, response);
        try {
            securityContext.authenticate("user", "password");
            System.out.println("Authenticated: " + securityContext.isAuthenticated());
            System.out.println("Role: " + securityContext.getRole());
            securityContext.logout();
            System.out.println("Authenticated after logout: " + securityContext.isAuthenticated());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}