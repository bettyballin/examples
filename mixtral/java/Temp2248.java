import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Temp2248 {

    private final UserRepository userRepository;

    public Temp2248(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/wallet")
    public String wallet(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get authenticated user
        User currentUser = userRepository.findByRegName(authentication.getName());

        Long totalBitcoins = sumBitcoinsByEmail(currentUser.getEmail());

        model.addAttribute("user", currentUser);
        model.addAttribute("totalBitcoins", totalBitcoins);

        return "wallet";
    }

    private Long sumBitcoinsByEmail(String email) {
        // Implement the logic to sum bitcoins by email
        return 0L; // Placeholder implementation
    }

    // Assuming User and UserRepository are defined elsewhere in your codebase
}