public class Temp1076 {
    public static void main(String[] args) {
        CustomAuthentication auth = new CustomAuthentication("user", "pass");
        System.out.println("Credentials: " + auth.getCredentials());
        System.out.println("Principal: " + auth.getPrincipal());
    }
}

class CustomAuthentication {
    private String username;
    private String password;

    public CustomAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Object getCredentials() {
        return password;
    }

    public Object getPrincipal() {
        // Add the necessary information from the request header here.
        return username; // Assuming username is the principal
    }
}