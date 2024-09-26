import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.ArrayList;

public class YourController2 {

    public void addAuthority(List<SimpleGrantedAuthority> authorities) {
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        // ... your code ...
        return "users";
    }
}