import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.store.Store;

private static class TestAuthenticator implements Authenticator {
  private static final String TEST_TOKEN = "testToken";
  
  @Override
  public void validate(Credentials credentials, WebContext context, Store<String, CommonProfile> sessionStore) {
    TokenCredentials tokenCredentials = (TokenCredentials) credentials;
    if (TEST_TOKEN.equals(tokenCredentials.getToken())) {
      tokenCredentials.setUserProfile(mockUserProfile());
    }
  }

  private CommonProfile mockUserProfile() {
    CommonProfile userProfile = new CommonProfile();
    userProfile.setId("mockId");
    userProfile.addAttribute("name", "Mock User");
    return userProfile;
  }
}