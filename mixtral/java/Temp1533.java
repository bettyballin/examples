import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

public class Temp1533 {
    private static StringRedisTemplate redisTemplate = new StringRedisTemplate();
    private static RestTemplate template = new RestTemplate();

    public static void main(String[] args) {
        String cachedAccessToken = redisTemplate.opsForValue().get("access_token");
        if (cachedAccessToken != null) {
            template.getInterceptors().add((request, body, execution) -> {
                request.getHeaders().add("Authorization", "Bearer " + cachedAccessToken);
                return execution.execute(request, body);
            });
        }
    }
}