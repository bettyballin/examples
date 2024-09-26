import javax.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Your user retrieval logic

        // Access the current request attributes
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        // Get the session from the current request attributes (true means create a new session if one doesn't exist)
        HttpSession session = attr.getRequest().getSession(true);

        // Now you can place user information in the session
        session.setAttribute("yourAttribute", "yourValue");
        
        // Dummy UserDetails object for demonstration; replace with actual user retrieval logic
        UserDetails userDetails = null; // = yourUserDetailsRetrievalMethod(username);

        // Return the UserDetails object
        return userDetails;
    }
}