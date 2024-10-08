import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
        String emailAddress = principal.getFirstAttribute("emailAddress");
        model.addAttribute("emailAddress", emailAddress);
        model.addAttribute("userAttributes", principal.getAttributes());
        return "index";
    }
}