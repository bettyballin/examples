import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogoutController2 {

    @RequestMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        // Your logout logic here
        // ...

        return ResponseEntity.ok().headers(headers).build();
    }
}