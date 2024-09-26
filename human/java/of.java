import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/me")
    public void getUserProfile(@AuthenticationPrincipal UserDetails user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("principal : " + authentication.getPrincipal());
        System.out.println("Implementing class of UserDetails: " + authentication.getPrincipal().getClass());
        System.out.println("Implementing class of UserDetailsService: " + userDetailsService.getClass());
    }
}