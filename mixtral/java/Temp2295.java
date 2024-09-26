import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;

@FeignClient(name = "service-core", url = "http://localhost:8091/api", configuration = FeignClientConfiguration.class)
public interface ServiceCore {

    // Your methods here

}

@Configuration
public class FeignClientConfiguration {
    // Your configurations here
}