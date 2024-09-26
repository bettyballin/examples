import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class Temp508 {

    private final UserDetailsService userDetailsService;

    public Temp508(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp508.class, args);
    }

    @RequestMapping("/automatic/login/test")
    public @ResponseBody String automaticLoginTest(HttpServletRequest request) {
        String username = "anyUserName@YourSite.com";

        Boolean result = authenticateUserAndInitializeSessionByUsername(username, userDetailsService, request);

        return result.toString();
    }

    public boolean authenticateUserAndInitializeSessionByUsername(String username, UserDetailsService userDetailsService, HttpServletRequest request) {
        boolean result = true;

        try {
            // generate session if one doesn't exist
            request.getSession();

            // Authenticate the user
            UserDetails user = userDetailsService.loadUserByUsername(username);
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            result = false;
        }

        return result;
    }
}