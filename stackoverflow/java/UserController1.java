import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController1 {

    @Autowired
    private UserDetailsManager users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/createUser")
    public String handle(Model model, String username, String password, List<String> roles) {
        User user = new User(username, passwordEncoder.encode(password), roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList()));
        users.createUser(user);
        return "view";
    }
}