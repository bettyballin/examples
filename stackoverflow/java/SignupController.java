import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);

    @GetMapping("/signup")
    public String signup(Model model,
                         @RequestParam(value = "color", required = false) String color,
                         @RequestParam(value = "error", required = false) String error,
                         @ModelAttribute("account") AccountDTO dto) {
        log.info(dto.getEmail());
        model.addAttribute("account", dto != null ? dto : new AccountDTO());
        model.addAttribute("cssPath", "../css/index.css");
        model.addAttribute("title", "Welcome To Expense Tracker");
        model.addAttribute("error", error != null ? error : ".");
        model.addAttribute("color", color != null ? color : Color.LIGHT_BACKGROUND.getColor());
        return "signup/signup";
    }
    
    enum Color {
        LIGHT_BACKGROUND("#F0F0F0"); // Placeholder color value
        
        private String color;
        
        Color(String color) {
            this.color = color;
        }
        
        public String getColor() {
            return color;
        }
    }
    
    static class AccountDTO {
        private String email;
        
        public String getEmail() {
            return email;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
    }
}