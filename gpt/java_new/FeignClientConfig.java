import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.openfeign.FeignClient;

public class FeignClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = "your_jwt_token_here"; // Replace with code to retrieve the token
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}

@FeignClient(name = "service-core", configuration = FeignClientConfig.class)
interface ServiceCoreClient {
    // Define methods to interact with service-core
}