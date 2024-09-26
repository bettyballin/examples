import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.profile.UserProfile;
import org.pac4j.core.store.SessionStore;

public class TestAuthenticator implements Authenticator {
  private static final String TEST_TOKEN = "test_token";

  @Override
  public void validate(Credentials credentials, WebContext context, SessionStore sessionStore) {
    TokenCredentials tokenCredentials = (TokenCredentials) credentials;
    if (TEST_TOKEN.equals(tokenCredentials.getToken())) {
      tokenCredentials.setUserProfile(mockUserProfile());
    }
  }

  private UserProfile mockUserProfile() {
    UserProfile userProfile = new UserProfile();
    userProfile.setId("mockUser");
    userProfile.addAttribute("username", "mockUser");
    return userProfile;
  }

  public static void main(String[] args) {
    TestAuthenticator authenticator = new TestAuthenticator();
    TokenCredentials credentials = new TokenCredentials("test_token");
    authenticator.validate(credentials, null, null);
    UserProfile profile = credentials.getUserProfile();
    if (profile != null) {
      System.out.println("Authenticated user: " + profile.getId());
    } else {
      System.out.println("Authentication failed.");
    }
  }
}