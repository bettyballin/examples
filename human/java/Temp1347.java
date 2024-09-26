class SecurityFilter {
    public void authenticateNextRequestAs(String username) {
        System.out.println("Authenticating next request as: " + username);
    }
}

public class Temp1347 {
    public static void main(String[] args) {
        SecurityFilter testSecurityFilter = new SecurityFilter();
        testSecurityFilter.authenticateNextRequestAs("username");
    }
}