import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
@Scope("session")
@Component
public class MyBean {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostConstruct
    public void init() {
        String username = getConnectedUser();
        User user = (User) userDetailsService.loadUserByUsername(username);
        // Use the 'user' object to retrieve the desired details
    }

    public String getConnectedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal();
        return principal != null ? principal.toString() : null;
    }
}