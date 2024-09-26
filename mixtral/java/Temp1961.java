import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp1961 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers("/thirdparty/**", "/webjars/**", "/sessionerror").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/")
                .failureUrl("/?error")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // override default of only allowing POST for logout so we can use a GET
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .permitAll()
            .and().sessionManagement()
                .maximumSessions(1).expiredUrl("/?sessExpired").maxSessionsPreventsLogin(false);
    }
}