import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("RealUser", "RealPassword").build();
        int port = 8080; // Specify the port number your server is running on
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:" + port + "/employee", List.class);

        System.out.println(response.getBody());
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}