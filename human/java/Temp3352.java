import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Temp3352 {

    @GetMapping("/signup")
    @PreAuthorize("permitAll()")
    public String signup(Model model, @RequestParam(value = "color", required = false) String color, @RequestParam(value = "error", required = false) String error, @ModelAttribute("account") AccountDTO dto) {
        if (dto != null) {
            System.out.println(dto.getEmail());
        } else {
            dto = new AccountDTO();
        }
        
        model.addAttribute("account", dto);
        model.addAttribute("cssPath", "../css/index.css");
        model.addAttribute("title", "Welcome To Expense Tracker");
        model.addAttribute("error", error == null ? "." : error);
        model.addAttribute("color", color == null ? Color.LIGHT_BACKGROUND.getColor() : color);
        return "signup/signup";
    }

    public static void main(String[] args) {
        // This is just a placeholder to make this class executable.
        // Spring Boot Application should be started using SpringApplication.run
    }
}

class AccountDTO {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

enum Color {
    LIGHT_BACKGROUND("#FFFFFF");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}