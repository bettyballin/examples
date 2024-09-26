import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class Temp3452 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Spring Boot applications should be started with SpringApplication.run()
        // However, the WebSecurityConfigurerAdapter doesn't need a main method to run.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/new/**", "/edit/**", "/create/**", "/save/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/", "/registration/**", "/view/**").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/loggingOut").permitAll();
    }
}