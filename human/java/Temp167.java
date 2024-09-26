import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp167 {
    public static void main(String[] args) {
        // You can invoke the testSpEL method here, perhaps in a Spring context.
    }

    @PreAuthorize("testBean.getTestValue()")
    public String testSpEL() {
        return "Method executed";
    }
}

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}

class TestBean {
    public boolean getTestValue() {
        return true; // or some access logic
    }
}