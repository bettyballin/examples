import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class Temp89 {

    @Autowired
    @Qualifier("jdbcUserService")  // <-- this references the bean id
    private UserDetailsManager userDetailsManager;

    public static void main(String[] args) {
        Temp89 temp89 = new Temp89();
        // Use temp89.userDetailsManager as needed
    }
}