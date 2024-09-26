public class SessionCredentials {

    String apiKey;
    String accessToken;

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

    public static void main(String[] args) {
        SessionCredentials credentials = new SessionCredentials("myApiKey", "myAccessToken");
        System.out.println("API Key: " + credentials.getApiKey());
        System.out.println("Access Token: " + credentials.getAccessToken());
    }
}