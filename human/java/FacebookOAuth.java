import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import com.google.gson.Gson;

public class FacebookOAuth extends Oauth {

    public FacebookOAuth() {
        Authorize = "https://graph.facebook.com/oauth/authorize";
        AccessToken = "https://graph.facebook.com/oauth/access_token";
        CallbackUrl = "http://<YourURLHere>/Authenticate";
        AttributesBaseUrl = "https://graph.facebook.com/me/?access_token=";

        Properties properties = new Properties();
        try (InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/config.properties"))) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConsumerKey = properties.getProperty("FacebookConsumerKey"); // Your Consumer Key goes here
        ConsumerSecret = properties.getProperty("FacebookConsumerSecret"); // Your Consumer secret goes here
        Provider = "Facebook";
    }

    @Override
    public String AuthorizationLinkGet() {
        return String.format("%s?client_id=%s&redirect_uri=%s&scope=email,user_education_history,user_location,user_hometown",
                Authorize, ConsumerKey, CallbackUrl);
    }

    public User GetAttributes() throws IOException {
        String attributesUrl = String.format("%s%s", AttributesBaseUrl, Token);
        String attributes = WebRequest("GET", attributesUrl, "");

        Gson gson = new Gson();
        FacebookUser facebookUser = gson.fromJson(attributes, FacebookUser.class);

        return new User(
                facebookUser.first_name,
                facebookUser.middle_name,
                facebookUser.last_name,
                facebookUser.locale,
                facebookUser.email,
                Provider,
                Token
        );
    }

    private String WebRequest(String method, String urlStr, String body) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1) {
            buffer.append(chars, 0, read);
        }

        return buffer.toString();
    }

    class FacebookUser {
        String first_name;
        String middle_name;
        String last_name;
        String locale;
        String email;
    }

    class User {
        String firstName;
        String middleName;
        String lastName;
        String locale;
        String userEmail;
        String authProvider;
        String authToken;

        public User(String firstName, String middleName, String lastName, String locale, String userEmail, String authProvider, String authToken) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.locale = locale;
            this.userEmail = userEmail;
            this.authProvider = authProvider;
            this.authToken = authToken;
        }
    }

    abstract class Oauth {
        protected String Authorize;
        protected String AccessToken;
        protected String CallbackUrl;
        protected String AttributesBaseUrl;
        protected String ConsumerKey;
        protected String ConsumerSecret;
        protected String Provider;
        protected String Token;

        public abstract String AuthorizationLinkGet();
    }
}