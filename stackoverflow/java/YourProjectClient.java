import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.gson.JsonObject;

@FeignClient(name = "your-project-name")
public interface YourProjectClient {
    @GetMapping("/your-endpoint")
    JsonObject getSomething();
}