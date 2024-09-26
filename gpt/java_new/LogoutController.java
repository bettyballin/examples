import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @Value("${siteminder.logout.url}")
    private String siteminderLogoutUrl;

    @RequestMapping("/siteminder-logout")
    public String logoutFromSiteminder() {
        // Redirect to the Siteminder logout URL
        return "redirect:" + siteminderLogoutUrl;
    }
}