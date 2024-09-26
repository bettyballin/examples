public class AuthProviderConfig {
    private String clientName;
    private String clientId;
    private String clientSecret;
    private String clientAuthenticationMethod;
    private String authorizationGrantType;
    private String redirectUri;

    public AuthProviderConfig() {
        this.clientName = "myAuthProvider";
        this.clientId = "ABCID";
        this.clientSecret = "XYZSECRET";
        this.clientAuthenticationMethod = "basic";
        this.authorizationGrantType = "authorization_code";
        this.redirectUri = "{baseUrl}/welcome/login/oauth2/code/{registrationId}";
    }

    // Getters and setters for each field
    // ...
}