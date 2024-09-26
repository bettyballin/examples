import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class Temp1521 {

    @GetMapping("/dashboard")
    public String showDashboard(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        // Access the required data
        String username = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        // You can add attributes to the model if needed
        model.addAttribute("username", username);
        model.addAttribute("authorities", authorities);

        return "dashboard";
    }
}