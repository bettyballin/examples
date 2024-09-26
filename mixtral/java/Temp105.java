import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;
import org.springframework.security.oauth.consumer.OAuthConsumerSupport;
import org.springframework.security.oauth.consumer.OAuthConsumerToken;
import org.springframework.security.oauth.consumer.client.CoreOAuthConsumerSupport;
import org.springframework.security.oauth.consumer.token.OAuthConsumerTokenServices;
import org.springframework.security.oauth.consumer.token.OAuthTokenFactory;
import org.springframework.security.oauth.consumer.token.OAuthTokenServices;
import org.springframework.security.oauth.consumer.token.OAuthToken;

import java.util.ArrayList;
import java.util.List;

public class OAuthExample {

    public static void main(String[] args) {
        String consumerKey = "your-consumer-key";
        String consumerSecret = "your-consumer-secret";

        OAuthConsumerToken accessToken = new OAuthConsumerToken();
        accessToken.setValue("existing_token");
        accessToken.setSecret("existing_token_secret");

        OAuthRestTemplate restTemplate = new OAuthRestTemplate();
        restTemplate.setMessageConverters(messageConverters());

        // Set the consumer key and secret
        OAuthConsumerSupport support = new CoreOAuthConsumerSupport();
        support.setConsumerKey(consumerKey);
        support.setConsumerSecret(consumerSecret);

        OAuthConsumerTokenServices tokenServices = new OAuthTokenServices();
        tokenServices.setTokenFactory(new OAuthTokenFactory());
        tokenServices.setOAuthConsumerSupport(support);

        restTemplate.setRequestFactory(new OAuth1RequestFactory(support, accessToken));

        // Make authenticated requests
        String response = restTemplate
                .exchange("https://api-url/resource", HttpMethod.GET, null, String.class)
                .getBody();

        System.out.println(response);
    }

    private static List<HttpMessageConverter<?>> messageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new StringHttpMessageConverter());
        return converters;
    }
}