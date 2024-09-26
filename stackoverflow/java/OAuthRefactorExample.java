// Assuming googleOAuthUri and googleOAuth2Details are defined with valid types somewhere in the surrounding context

public class OAuthRefactorExample {
    private String googleOAuthUri; // Assuming this is initialized somewhere
    private GoogleOAuth2Details googleOAuth2Details; // Assuming this is a defined class with the setUserAuthorizationUri method

    public void updateOAuthUri() {
        googleOAuthUri = googleOAuthUri + "?access_type=offline";
        googleOAuth2Details.setUserAuthorizationUri(googleOAuthUri);
    }

    // ... rest of the class
}

class GoogleOAuth2Details {
    public void setUserAuthorizationUri(String uri) {
        // logic to set user authorization URI
    }
    // ... rest of the class
}