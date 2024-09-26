import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/is_auth")
    public void ping() {
        // log ?
    }
}