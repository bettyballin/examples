import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Temp1743 {

    @Autowired
    private Authentication authentication;

    public static void main(String[] args) {
        Temp1743 temp = new Temp1743();
        temp.printAuthorities();
    }

    public void printAuthorities() {
        // Simulate setting the authentication object for the sake of example
        authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            System.out.println("authority: " + authority);
        }
    }
}