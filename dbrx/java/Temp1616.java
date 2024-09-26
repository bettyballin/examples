import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

@SpringBootApplication
@RestController
public class Temp1616 {

    @GetMapping(value = "/api", produces = "application/json")
    public ResponseEntity<String> getApiData(@RequestHeader(name = "X-Frame-Options", required = false) String frameOption) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Referrer-Policy", ReferrerPolicyHeaderWriter.ReferrerPolicy.SAME_ORIGIN.getPolicy());
        // Add other headers as well
        return new ResponseEntity<>("{}", responseHeaders, HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp1616.class, args);
    }
}