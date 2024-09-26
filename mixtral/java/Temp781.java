public class Temp781 {
    public static void main(String[] args) {
        Temp781 temp = new Temp781();
        boolean isAuthenticated = temp.authenticateUser("user", "pass");
        System.out.println("Authentication successful: " + isAuthenticated);
    }

    public boolean authenticateUser(String username, String password) {
        AuthenticationService auth = new WrapperAuthenticationService();
        return auth.authenticate(username, password);
    }
}

interface AuthenticationService {
    boolean authenticate(String username, String password);
}

class WrapperAuthenticationService implements AuthenticationService {
    @Override
    public boolean authenticate(String username, String password) {
        // Dummy authentication logic
        return "user".equals(username) && "pass".equals(password);
    }
}