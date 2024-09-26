import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {

    private final String bearerToken;

    public FeignInterceptor(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer " + bearerToken);
    }
}