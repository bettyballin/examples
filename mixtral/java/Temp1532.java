import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Date;

public class Temp1532 {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // Mock OAuth2AccessToken class
    static class OAuth2AccessToken {
        private long expiresIn;

        public OAuth2AccessToken(long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getExpiresIn() {
            return expiresIn;
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("your.package.name"); // Replace with your package name
        context.refresh();
        
        Temp1532 temp1532 = context.getBean(Temp1532.class);
        temp1532.run();
        context.close();
    }

    public void run() {
        String cacheKey = "access_token";
        String accessToken = "yourAccessToken"; // Replace with your actual access token
        OAuth2AccessToken oAuth2AccessToken = new OAuth2AccessToken(3600); // Example expiration time in seconds

        redisTemplate.opsForValue().set(cacheKey, accessToken);
        long expiresInMillis = oAuth2AccessToken.getExpiresIn() * 1000;
        redisTemplate.expireAt(cacheKey, new Date(System.currentTimeMillis() + expiresInMillis));
    }
}