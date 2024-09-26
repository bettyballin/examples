import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp182Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp182Application.class, args);
    }
}

@RestController
class Temp182Controller {

    @GetMapping("/url")
    @ResponseBody
    public DTO method(@RequestHeader(name = "My-Custom-Header") String headerValue) {
        DTO dto = new DTO();
        return dto;
    }
}

class DTO {
    private String data;

    public DTO() {}

    public DTO(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}