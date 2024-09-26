import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Controller
public class Temp567 {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/wallet")
    public String wallet(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String regName = authentication.getName();
        User user = userRepository.findByRegName(regName);
        Long totalBitcoins = userRepository.getTotalBitcoinsForEmail(user.getEmail());
        model.addAttribute("totalBitcoins", totalBitcoins);
        return "wallet";
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp567.class, args);
    }
}

interface UserRepository {
    User findByRegName(String regName);
    Long getTotalBitcoinsForEmail(String email);
}

class User {
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}