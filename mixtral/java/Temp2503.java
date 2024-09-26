public class Temp2503 {
    public static void main(String[] args) {
        // Example usage of the validate method
        Temp2503 validator = new Temp2503();
        Credentials credentials = new TokenCredentials("TEST_TOKEN");
        WebContext context = new WebContext();
        SessionStore sessionStore = new SessionStore();
        validator.validate(credentials, context, sessionStore);

        if (credentials.getUserProfile() != null) {
            System.out.println("User profile set successfully.");
        } else {
            System.out.println("User profile not set.");
        }
    }

    public void validate(Credentials credentials, WebContext context, SessionStore sessionStore) {
        if (credentials instanceof TokenCredentials && "TEST_TOKEN".equals(((TokenCredentials) credentials).getToken())) {
            ((TokenCredentials) credentials).setUserProfile(mockUserProfile());
        }
    }

    // Mock method to create a user profile
    private UserProfile mockUserProfile() {
        return new UserProfile("MockUser");
    }
}

// Mock classes for demonstration purposes
class Credentials {
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}

class TokenCredentials extends Credentials {
    private String token;

    public TokenCredentials(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

class WebContext {
    // Mock implementation
}

class SessionStore {
    // Mock implementation
}

class UserProfile {
    private String username;

    public UserProfile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}