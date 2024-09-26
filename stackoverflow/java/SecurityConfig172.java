import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.handler.ServletRequestPathUtils;
import org.springframework.web.util.pattern.PathPatternParser;

@EnableWebSecurity
public class SecurityConfig172 {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
            .requestMatchers(customMatcher("/togglz-console"), 
                             customMatcher("/togglz-console/*"))
            .permitAll()
            .antMatchers("/public/**")
            .permitAll()
            .anyRequest()
            .authenticated())
            .formLogin(form -> form.loginPage("/login").permitAll())
            .build();
    }

    private RequestMatcher customMatcher(String pattern) {
        return request -> {
            var matcher = new PathPatternParser().parse(pattern);
            var path = ServletRequestPathUtils.parseAndCache(request);
            return matcher.matches(path);
        };
    }
}