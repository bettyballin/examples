import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Controller
public class CustomErrorPageController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping("/error/404")
    public String handleNotFoundException() {
        // Log the remote IP address here

        return "custom-page-not-found";
    }

}