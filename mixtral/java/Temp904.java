import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp904 {
    public static void main(String[] args) {
        try {
            configure(new HttpSecurity(null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .and()
            .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/j_spring_security_logout"))
                .logoutSuccessUrl("/login");
    }
}