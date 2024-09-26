public class Temp2837 {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Principal principal = new Principal();
        Response response = new Response();
        String OVERVIEW_PAGE = "http://example.com/overview";

        if (auth.isAuthenticated() && principal != null) {
            response.sendRedirect(OVERVIEW_PAGE);
            return;
        }
    }
}

class Auth {
    public boolean isAuthenticated() {
        // Mock authentication logic
        return true;
    }
}

class Principal {
    // Principal class implementation
}

class Response {
    public void sendRedirect(String url) {
        System.out.println("Redirecting to: " + url);
    }
}