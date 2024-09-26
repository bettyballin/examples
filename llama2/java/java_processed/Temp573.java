import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;

@SpringBootApplication
public class Temp573 {

    public static void main(String[] args) {
        SpringApplication.run(Temp573.class, args);
    }

    @FeignClient(name = "service-core", url = "https://service-core.com")
    public interface ServiceCoreClient {

        @PostMapping("/insertData")
        public Response insertData(@RequestHeader("Authorization") String bearerToken, @RequestBody Data data);
    }

    @RestController
    public static class Temp573Controller {
        private final ServiceCoreClient serviceCoreClient;

        public Temp573Controller(ServiceCoreClient serviceCoreClient) {
            this.serviceCoreClient = serviceCoreClient;
        }

        // Example endpoint to use the Feign client
        @PostMapping("/useFeignClient")
        public Response useFeignClient(@RequestHeader("Authorization") String bearerToken, @RequestBody Data data) {
            return serviceCoreClient.insertData(bearerToken, data);
        }
    }

    // Example Data class
    public static class Data {
        private String field1;
        private String field2;

        // getters and setters
        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }

    // Example Response class
    public static class Response {
        private String status;

        // getters and setters
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}