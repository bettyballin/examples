import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomOAuth2Controller {

    @GetMapping("/welcome/login/oauth2/code/{registrationId}")
    public String redirectToOAuth2Login(@PathVariable String registrationId, HttpServletRequest request) {
        // Forwarding to the default endpoint without the /welcome part
        return "forward:/login/oauth2/code/" + registrationId;
    }
}