import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.json.BasicJsonParser;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
public class RandomApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    OAuth2RestTemplate oAuth2RestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    Random random() {
        return new SecureRandom();
    }
}

@RestController
class RandomController {

    private final OAuth2RestTemplate oAuth2RestTemplate;
    private final Random random;

    public RandomController(OAuth2RestTemplate oAuth2RestTemplate, Random random) {
        this.oAuth2RestTemplate = oAuth2RestTemplate;
        this.random = random;
    }

    @RequestMapping(value = "/get", method = GET)
    public int random() {
        int[] bounds = getBounds();
        return computeRandom(bounds[0], bounds[1]);
    }

    private int[] getBounds() {
        ResponseEntity<String> res = oAuth2RestTemplate.getForEntity(
                "https://configurations.com/bounds", String.class);
        Map<String, Object> map = new BasicJsonParser().parseMap(res.getBody());
        Map<String, Long> value = (Map<String, Long>) map.get("value");
        int lowerBound = value.get("lower").intValue();
        int upperBound = value.get("upper").intValue();
        return new int[]{lowerBound, upperBound};
    }

    private int computeRandom(int lowerBound, int upperBound) {
        int difference = upperBound - lowerBound;
        int raw = random.nextInt(difference);
        return raw + lowerBound;
    }
}