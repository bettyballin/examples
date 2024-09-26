import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig77 {

    public static final String LOGIN_PAGE = "/login";
    public static final String LOGIN_PROCESSING_URL = "/authenticate";
    public static final String FAILURE_URL = "/login?error";

    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/").permitAll()
                                .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin
                                .loginPage(LOGIN_PAGE)
                                .loginProcessingUrl(LOGIN_PROCESSING_URL)
                                .failureUrl(FAILURE_URL)
                                .permitAll())
                .build();
    }
}