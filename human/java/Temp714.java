import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Temp714 {
    public static void main(String[] args) {
        // Mocking HttpServletRequest for demonstration purposes
        HttpServletRequest request = new MockHttpServletRequest();

        HttpSession session = request.getSession(true);
        System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
    }

    // Mock implementation of HttpServletRequest for demonstration purposes
    static class MockHttpServletRequest implements HttpServletRequest {
        private final MockHttpSession session = new MockHttpSession();

        @Override
        public HttpSession getSession(boolean create) {
            return session;
        }

        // Implement other methods from HttpServletRequest as no-op or return default values
        // ...

        // Example of a simplified mock HttpSession
        static class MockHttpSession implements HttpSession {
            @Override
            public Object getAttribute(String name) {
                if ("SPRING_SECURITY_CONTEXT".equals(name)) {
                    return "MockSecurityContext";
                }
                return null;
            }

            // Implement other methods from HttpSession as no-op or return default values
            // ...
        }
    }
}