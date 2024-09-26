import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
public class UserController {

    @RequestMapping("/username")
    public String currentUserName(@AuthenticationPrincipal Principal userDetails) {
        return ((MyAppUserDetails) userDetails).getUsername();
    }
}

// MyAppUserDetails is your custom UserDetails implementation
class MyAppUserDetails implements UserDetails {
    private String username;

    public MyAppUserDetails(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}