import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class Temp754 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Spring Boot applications typically use SpringApplication.run()
        // This is just a placeholder main method
        // SpringApplication.run(Temp754.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling()
                // this entry point handles when you request a protected page and
                // you are not yet authenticated
                .authenticationEntryPoint(digestEntryPoint())
                .and()
            .authorizeRequests()
                .antMatchers("/firstres/*").permitAll()
                .antMatchers("/secondres/*").permitAll()
                .antMatchers("/resources/*").permitAll()
                .antMatchers("/**").hasAnyAuthority("first_role", "second_role").and()
            // the entry point on digest filter is used for failed authentication attempts
            .addFilter(digestAuthenticationFilter(digestEntryPoint()));
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    public DigestAuthenticationFilter digestAuthenticationFilter(
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint) {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
        digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
        return digestAuthenticationFilter;
    }

    @Bean
    public DigestAuthenticationEntryPoint digestEntryPoint() {
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setRealmName("realm");
        digestAuthenticationEntryPoint.setKey("myKey");
        return digestAuthenticationEntryPoint;
    }
}