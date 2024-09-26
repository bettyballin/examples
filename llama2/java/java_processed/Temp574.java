import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Temp574 {
    public static void main(String[] args) {
        SpringApplication.run(Temp574.class, args);
    }

    @FeignClient(name = "service-core", url = "https://service-core.com")
    public interface ServiceCoreClient {

        @PostMapping("/insertData")
        public Response insertData(@RequestBody Data data);
    }

    public static class Data {
        private String id;
        private String name;

        public Data() {}

        public Data(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Response {
        private String status;
        private String message;

        public Response() {}

        public Response(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}