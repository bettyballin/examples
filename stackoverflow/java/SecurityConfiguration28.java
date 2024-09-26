// Without the context of the surrounding code or the framework, the full refactoring cannot be done.
// However, the method call seems to be related to Spring Security configuration. Here's a possible context where it might be used:

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.http.HttpMethod;

public class SecurityConfiguration28 {

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/path/to/skip/check").permitAll()
            // other security configuration...
            ;
    }
}