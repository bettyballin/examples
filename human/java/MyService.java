import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private UserDetailsService myCustomUserDetailsService;

    // other methods and logic here
}