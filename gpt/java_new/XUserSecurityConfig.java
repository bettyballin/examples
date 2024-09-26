import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class XUserSecurityConfig extends WebSecurityConfigurerAdapter {
    // Configure for XUser
}

@Configuration
@Order(2)
public class YUserSecurityConfig extends WebSecurityConfigurerAdapter {
    // Configure for YUser
}