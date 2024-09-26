import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class Temp9 {

    @Autowired
    @Qualifier("jdbcUserService")
    public UserDetailsManager userDetailsManager;

    public static void main(String[] args) {
        // Spring Boot applications should be started with a SpringApplication.run call,
        // but for simplicity in this example, we will just instantiate the class.
        Temp9 temp9 = new Temp9();
        System.out.println("Temp9 class instantiated.");
    }
}