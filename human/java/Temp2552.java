import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
public class UserRestFullEndPointApp {
    public static void main(String[] args) {
        SpringApplication.run(UserRestFullEndPointApp.class, args);
    }
}

@RestController
@RequestMapping("/account")
class UserRestFullEndPoint {

    @GetMapping("/userInfo")
    public Principal userInfo(Principal principal) {
        return principal;
    }
}