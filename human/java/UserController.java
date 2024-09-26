import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    MyUserDetailsService userdetailservice;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserView home(Principal principal) {
        if (principal != null) {
            User user = (User) userdetailservice.loadUserByUsername(principal.getName());
            return new UserView(user);
        }
        return null;
    }
}

// Assuming MyUserDetailsService is implemented as follows
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement user loading logic here, e.g., from a database
        return new User(username, "password", new ArrayList<>());
    }
}

// Assuming UserView is implemented as follows
public class UserView {
    private String username;

    public UserView(User user) {
        this.username = user.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}