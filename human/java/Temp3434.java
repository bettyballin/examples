import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp3434 {
    public static void main(String[] args) {
        System.out.println("Application started");
    }

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.html").permitAll().loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/bookmarks-app/index.html", true)
                .failureUrl("/login.html").permitAll()
                .and()
                .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        }
    }
}