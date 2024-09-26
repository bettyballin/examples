public class Temp1262 {
    public static void main(String[] args) {
        String googleOAuthUri = "https://accounts.google.com/o/oauth2/auth";
        googleOAuthUri = googleOAuthUri + "?access_type=offline";
        
        GoogleOAuth2Details googleOAuth2Details = new GoogleOAuth2Details();
        googleOAuth2Details.setUserAuthorizationUri(googleOAuthUri);
        
        // Print to verify the final URL
        System.out.println(googleOAuth2Details.getUserAuthorizationUri());
    }
}

class GoogleOAuth2Details {
    private String userAuthorizationUri;

    public String getUserAuthorizationUri() {
        return userAuthorizationUri;
    }

    public void setUserAuthorizationUri(String userAuthorizationUri) {
        this.userAuthorizationUri = userAuthorizationUri;
    }
}