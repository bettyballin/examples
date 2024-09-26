public class SessionCredentials {

    private String apiKey;
    private String accessToken;

    public SessionCredentials(String apiKey, String accessToken) {
        this.apiKey = apiKey;
        this.accessToken = accessToken;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAccessToken() {
        return accessToken;
    }
}