import org.springframework.security.oauth.common.signature.SharedConsumerSecret;
import org.springframework.security.oauth.consumer.BaseProtectedResourceDetails;
import org.springframework.security.oauth.consumer.OAuthConsumerSupport;
import org.springframework.security.oauth.consumer.OAuthConsumerToken;
import org.springframework.security.oauth.consumer.ProtectedResourceDetails;
import org.springframework.security.oauth.consumer.client.CoreOAuthConsumerSupport;
import org.springframework.web.client.RestTemplate;

import org.springframework.security.oauth.consumer.client.OAuthConsumerInterceptor;

public class Temp290 {
    public static void main(String[] args) {
        String consumerKey = "yourConsumerKey";
        String consumerSecret = "yourConsumerSecret";
        String accessToken = "yourAccessToken";
        String accessTokenSecret = "yourAccessTokenSecret";

        ProtectedResourceDetails resourceDetails = new BaseProtectedResourceDetails();
        resourceDetails.setConsumerKey(consumerKey);
        resourceDetails.setSharedSecret(new SharedConsumerSecret(consumerSecret));
        
        OAuthConsumerToken accessTokenDetails = new OAuthConsumerToken();
        accessTokenDetails.setValue(accessToken);
        accessTokenDetails.setSecret(accessTokenSecret);

        OAuthConsumerSupport support = new CoreOAuthConsumerSupport();
        RestTemplate restTemplate = new RestTemplate();
        ((CoreOAuthConsumerSupport) support).setRestTemplate(restTemplate);

        // Add the OAuth consumer support to the RestTemplate
        restTemplate.getInterceptors().add(new OAuthConsumerInterceptor(resourceDetails, support, accessTokenDetails));

        // Now you can use the restTemplate to make requests
        // For example:
        // String result = restTemplate.getForObject("https://api.example.com/resource", String.class);
        // System.out.println(result);
    }
}