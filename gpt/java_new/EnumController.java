import fr.model.enumeration.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnumController {

    @GetMapping("/countries")
    public String getCountries(Model model) {
        model.addAttribute("countries", Country.values());
        return "accountRequestForm";
    }
}