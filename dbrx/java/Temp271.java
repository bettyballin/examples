import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp271 {
    private static final String CONSUMER_KEY = "your_consumer_key_here";
    private static final String CONSUMER_SECRET = "your_consumer_secret_here";

    public static void main(String[] args) {
        try {
            String authCredentials = authorizeDiscogs();
            System.out.println("Authorization credentials: " + authCredentials);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String authorizeDiscogs() throws Exception {
        // Step 1: Request a verification URL and pin from Discogs API.
        OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        OAuthProvider provider = new DefaultOAuthProvider(
                "http://api.discogs.com/oauth/request_token",
                "http://api.discogs.com/oauth/access_token",
                "http://www.discogs.com/oauth/authorize");
        String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);

        // Step 2: Redirect user to authorization URL and get a verifier PIN after successful login on Discogs website.
        System.out.println("Please visit the following url in your browser:");
        System.out.println(authUrl);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pin = "";
        while (pin.isEmpty()) {
            System.out.print("Enter verification code: ");
            pin = br.readLine();

            try {
                // Step 3: Exchange temporary credentials for permanent access token.
                provider.retrieveAccessToken(consumer, pin);
            } catch (OAuthNotAuthorizedException e) {
                System.out.println("Invalid verification code. Please try again.");
                pin = "";
            } catch (OAuthExpectationFailedException | OAuthCommunicationException | OAuthMessageSignerException e) {
                throw new Exception("Error retrieving access token", e);
            }
        }

        return consumer.getToken() + ":" + consumer.getTokenSecret();
    }
}