import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configure2rs.ExpressionUrlAuthorizationConfigurer;

// Assuming this is part of a larger configuration method within a class annotated with @EnableWebSecurity
public void configure2(HttpSecurity http) throws Exception {
    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
            .authorizeRequests();
    registry
            .antMatchers(HttpMethod.GET, "/api/**").permitAll();
    // other configurations...
}