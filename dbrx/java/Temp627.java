import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SpringBootApplication
@RestController
public class Temp627 {

    public static void main(String[] args) {
        SpringApplication.run(Temp627.class, args); 
        System.out.println("Application started");
    }

    @RequestMapping(value = "/your-endpoint", method = RequestMethod.GET)
    public ResponseEntity<String> handleRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId(); 

        return ResponseEntity.ok("Session ID: " + sessionId);
    }
}