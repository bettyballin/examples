public class Temp79 {
    public static void main(String[] args) {
        System.out.println("Session management simulation:");
        sessionManagement()
            .sessionIdUrlParameter("jsessionid")
            .sessionIdCookie(true)
            .maxSessions(10);
    }

    public static SessionManager sessionManagement() {
        return new SessionManager();
    }
}

class SessionManager {
    public SessionManager sessionIdUrlParameter(String parameter) {
        System.out.println("Session ID URL Parameter: " + parameter);
        return this;
    }

    public SessionManager sessionIdCookie(boolean useCookie) {
        System.out.println("Session ID Cookie enabled: " + useCookie);
        return this;
    }

    public SessionManager maxSessions(int maxSessions) {
        System.out.println("Max Sessions: " + maxSessions);
        return this;
    }
}