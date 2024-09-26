import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class Temp708 {

    @Autowired
    private YourRepository yourRepo;

    @GetMapping("/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Get the user object from database using Spring Data JPA
        Optional<YourEntity> optionalUser = this.yourRepo.findById(auth.getName());

        if (!optionalUser.isPresent())
            throw new UsernameNotFoundException("User not found");

        YourEntity yourEntity = optionalUser.get();

        // Add the first name to model
        String username = auth.getName();
        model.addAttribute("username", username);

        return "index";
    }
}