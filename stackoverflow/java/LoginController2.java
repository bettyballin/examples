import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginController2 {

    private final TeacherRepository teacherRepository;
    private final PasswordEncoder encoder;

    public LoginController2(TeacherRepository teacherRepository, PasswordEncoder encoder) {
        this.teacherRepository = teacherRepository;
        this.encoder = encoder;
    }

    @PostMapping(value = "/validateLogin")
    public ResponseEntity<Object> validateLogin(@RequestBody Map<String, String> user, HttpServletRequest request) {
        try {
            Teacher t = teacherRepository.findUser(user.get("name"), user.get("email"));
            if (t != null && encoder.matches(user.get("password"), t.getPassword())) {
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