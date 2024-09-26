import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp1052 {
    public static void main(String[] args) {
        // Spring application context setup should be here
    }

    @Bean
    @Order(1)
    public SecurityFilterChain securedResources(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain unSecuredResources(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(new AntPathRequestMatcher("/unsecured/**"))
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()
                )
                .build();
    }
}