import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Temp462 {
    public static void main(String[] args) {
        // Mock objects to simulate HttpServletRequest and HttpSession
        HttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = new MockHttpSession();

        if ((request.getUserPrincipal().getName()) != null) {
            String userName = request.getUserPrincipal().getName().trim();
            session.setAttribute("userName", userName);
            // Additional code here...
            if (request.isUserInRole("ADMINS")) {
                // Do actions here
                System.out.println("User is in role ADMINS.");
            }
        }
    }
}

// Mock classes to simulate HttpServletRequest and HttpSession
class MockHttpServletRequest implements HttpServletRequest {
    public java.security.Principal getUserPrincipal() {
        return () -> "mockUser";
    }

    public boolean isUserInRole(String role) {
        return "ADMINS".equals(role);
    }

    // Other methods can be implemented as needed
}

class MockHttpSession implements HttpSession {
    public void setAttribute(String name, Object value) {
        System.out.println("Session attribute set: " + name + " = " + value);
    }

    // Other methods can be implemented as needed
}