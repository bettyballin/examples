import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Temp962 {

    @Autowired
    private UserService userService; // Assuming you have a UserService to fetch user details

    @RequestMapping(value = "/api/admin/logout/{username}", method = RequestMethod.POST)
    public ResponseEntity<?> logoutUser(@PathVariable String username, HttpServletResponse response) {
        User userToLogout = userService.findByUsername(username);

        if (userToLogout == null || !SecurityContextHolder.getContext().getAuthentication().getName().equals(userToLogout.getUsername())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Invalidate the session
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(false);
        SecurityContext securityContext = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);

        if (securityContext != null && userToLogout.getUsername().equals(securityContext.getAuthentication().getName())) {
            session.invalidate();

            // Optionally you can also remove the remember-me cookie
            Cookie rememberMeCookie = new Cookie("remember-me", "");
            rememberMeCookie.setMaxAge(0);
            rememberMeCookie.setPath("/"); // Set the path to avoid duplicate cookie creation
            response.addCookie(rememberMeCookie);
        }

        return ResponseEntity.ok().build();
    }

    public static void main(String[] args) {
        // You can use this main method to run the application if needed
        org.springframework.boot.SpringApplication.run(Temp962.class, args);
    }
}

// Assuming UserService interface and User class are defined elsewhere
interface UserService {
    User findByUsername(String username);
}

class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}