import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public void configure(HttpSecurity http) throws Exception {
    // ...

    http.authorizeRequests()
        .requestMatchers(new AntPathRequestMatcher("/**", HttpMethod.GET.name())).permitAll();

    // ...
}