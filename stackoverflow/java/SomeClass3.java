import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class SomeClass3 {
    
    private final UserDetailsService myCustomUserDetailsService;

    @Autowired
    public SomeClass3(UserDetailsService myCustomUserDetailsService) {
        this.myCustomUserDetailsService = myCustomUserDetailsService;
    }
    
    // Rest of the class implementation
}