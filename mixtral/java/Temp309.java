import oauth.signpost.OAuth;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class Temp309 {
    private static final String CONSUMER_KEY = "your_consumer_key";
    private static final String CONSUMER_SECRET = "your_consumer_secret";
    private static final String REQUEST_TOKEN_URL = "http://api.example.com/oauth/request_token";
    private static final String ACCESS_TOKEN_URL = "http://api.example.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "http://api.example.com/oauth/authorize";

    public static void main(String[] args) {
        OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        DefaultOAuthProvider provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZE_URL);

        try {
            String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
            System.out.println("Authorization URL: " + authUrl);
        } catch (OAuthMessageSignerException | OAuthCommunicationException | OAuthExpectationFailedException e) {
            e.printStackTrace();
        }
    }
}