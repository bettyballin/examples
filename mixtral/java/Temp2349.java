import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class Temp2349 {

    public static void main(String[] args) {
        // Spring Boot application entry point (if needed)
    }

    @GetMapping("/index")
    public String homePage(@RequestParam(value = "showDialog", defaultValue = "false") boolean showDialog, HttpSession httpSession) {
        // ...

        if (showDialog) {
            httpSession.setAttribute("dialogShown", true);
        }

        return "redirect:/login";
    }
}