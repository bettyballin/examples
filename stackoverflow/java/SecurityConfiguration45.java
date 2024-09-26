import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration45 extends WebSecurityConfigurerAdapter {

    private String[] publicResources = new String[]{"/", "/home", "/about"};
    private String[] userAccess = new String[]{"/dashboard/**"};
    private String[] dataAccess = new String[]{"/data/**"};
    private String[] adminAccess = new String[]{"/admin/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers(publicResources).permitAll()
            .antMatchers(userAccess).hasAnyRole("USER", "DATA", "ADMIN")
            .antMatchers(dataAccess).hasAnyRole("DATA", "ADMIN")
            .antMatchers(adminAccess).hasRole("ADMIN")
            .anyRequest().authenticated();
    }
}