import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp91 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        Temp91 temp = new Temp91();
        temp.someMethod();
    }

    @PreAuthorize("hasRole(@role)")
    public void someMethod() {
        // ...
        System.out.println("Executing someMethod");
    }
}