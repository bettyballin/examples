public class Temp816 {
    public static void main(String[] args) {
        Authentication authentication = new Authentication("username", "password");
        AuthenticationManager.authenticate(authentication);
    }
}

class Authentication {
    private String username;
    private String password;

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class AuthenticationManager {
    public static void authenticate(Authentication authentication) {
        if ("username".equals(authentication.getUsername()) && "password".equals(authentication.getPassword())) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}