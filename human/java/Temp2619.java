import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Temp2619 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2619.class, args);
    }

    @FeignClient("your-project-name")
    public interface YourProjectClient {
        @GetMapping("your-endpoint")
        JsonObject getSomething();
    }

    @RestController
    public class YourController {
        @Autowired
        private YourProjectClient yourProjectClient;

        @GetMapping("/call-endpoint")
        public JsonObject callEndpoint() {
            return yourProjectClient.getSomething();
        }
    }
}