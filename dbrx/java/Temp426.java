import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp426 {
    public static void main(String[] args) {
        SpringApplication.run(Temp426.class, args);
    }
}

@RestController
@RequestMapping("/userInfo")
class UserInfoController {

    @GetMapping
    public ResponseEntity<UserInfo> getUserInfo() {
        UserInfo userInfo = new UserInfo();
        // Set user info here
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }
}

class UserInfo {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}