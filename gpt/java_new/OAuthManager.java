import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

public class OAuthManager {

    private static final String CONSUMER_KEY = "yourConsumerKey";
    private static final String CONSUMER_SECRET = "yourConsumerSecret";
    private static final String REQUEST_TOKEN_URL = "http://your.request.token.url";
    private static final String ACCESS_TOKEN_URL = "http://your.access.token.url";
    private static final String AUTHORIZE_URL = "http://your.authorize.url";

    public static OAuthConsumer getAccessToken() throws Exception {
        OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        OAuthProvider provider = new DefaultOAuthProvider(
            REQUEST_TOKEN_URL,
            ACCESS_TOKEN_URL,
            AUTHORIZE_URL
        );

        // You would need to add the proper handling here to work with the OAuth flow
        // For example:
        // String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
        // Then direct the user to authUrl, get the verifier, and retrieve the access token:
        // provider.retrieveAccessToken(consumer, verifier);

        return consumer;
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        try {
            OAuthConsumer consumer = getAccessToken();
            System.out.println("OAuth consumer obtained: " + consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}