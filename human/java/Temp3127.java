import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;

@SpringBootApplication
public class Temp3127 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3127.class, args);
    }
}

@Controller
class MyController {
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
        if (principal != null) {
            String emailAddress = principal.getFirstAttribute("emailAddress");
            model.addAttribute("emailAddress", emailAddress);
            model.addAttribute("userAttributes", principal.getAttributes());
        }
        return "index";
    }
}