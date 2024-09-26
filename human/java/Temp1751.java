public class Temp1751 {

    public static void main(String[] args) {
        Authentication auth = new Authentication("username", "password");
        Authentication result = authenticate(auth);
        if (result != null) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }

    public static Authentication authenticate(Authentication authentication) {
        // Example authentication logic
        if ("username".equals(authentication.getUsername()) && "password".equals(authentication.getPassword())) {
            return authentication;
        }
        return null;
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