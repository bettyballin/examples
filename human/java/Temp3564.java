import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class Temp3564 {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping(value = "/validateLogin")
    public ResponseEntity<Object> validateLogin(@RequestBody Map<String, String> user, HttpServletRequest request) {
        try {
            Teacher t = teacherRepository.findUser(user.get("name"), user.get("email"));
            if (t != null && encoder.matches(user.get("password"), t.getPassword())) {
                // store the object in session
                request.getSession().setAttribute("teacher", t);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(Map.of("result", "ok", "details", "login approved"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("result", "error", "details", "login denied"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("result", "error", "details", e.getMessage()));
        }
    }
}