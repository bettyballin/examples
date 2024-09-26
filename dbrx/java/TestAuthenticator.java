import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.profile.UserProfile;
import org.pac4j.core.store.SessionStore;
import org.pac4j.core.credentials.authenticator.Authenticator;

public class Main {
    private static final String TEST_TOKEN = "test-token";

    public static void main(String[] args) {
        // Example usage
        TestAuthenticator authenticator = new TestAuthenticator();
        TokenCredentials credentials = new TokenCredentials(TEST_TOKEN);
        authenticator.validate(credentials, null, null);
        
        if (credentials.getUserProfile() != null) {
            System.out.println("User authenticated.");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    private static class TestAuthenticator implements Authenticator {
        @Override
        public void validate(Credentials credentials, WebContext context, SessionStore sessionStore) {
            if (credentials instanceof TokenCredentials tokenCredentials && TEST_TOKEN.equals(tokenCredentials.getToken())) {
                UserProfile userProfile = mockUserProfile();
                ((TokenCredentials) credentials).setUserProfile(userProfile);
            }
        }

        private UserProfile mockUserProfile() {
            UserProfile userProfile = new UserProfile();
            userProfile.setId("1");
            userProfile.addAttribute("username", "testUser");
            return userProfile;
        }
    }
}