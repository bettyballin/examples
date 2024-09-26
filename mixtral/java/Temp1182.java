import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1182 {
    public static void main(String[] args) {
        // Spring Boot applications typically don't use the main method for logic
        // The application would be run through Spring Boot's SpringApplication.run() method
    }

    @RequestMapping("/logoout")
    public String logoOut(HttpServletRequest req) {
        HttpSession ses = req.getSession();
        if (ses != null)
            ses.invalidate();

        return "redirect:/login";
    }
}