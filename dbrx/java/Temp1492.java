import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class Temp1492 {

    private final UserRepository userRepository;

    public Temp1492(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/wallet")
    public String wallet(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String regName = authentication.getName();

        Optional<User> optionalUser = userRepository.findByRegName(regName);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            int totalBitcoins = userRepository.sumBitcoinBySameEmail(user.getEmail());

            model.addAttribute("user", user);
            model.addAttribute("totalBitcoins", totalBitcoins);
        }

        return "wallet";
    }

    public static void main(String[] args) {
        // Spring Boot application entry point (if required)
        // SpringApplication.run(Temp1492.class, args);
    }

}


Note: This assumes that `UserRepository` is properly defined elsewhere in the project. Also, the return type of `findByRegName` method should be `Optional<User>` or `User` if you're sure that it will never return null. 

If `UserRepository` is a Spring Data JPA Repository, you can define it like this:


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRegName(String regName);
    int sumBitcoinBySameEmail(String email);
}