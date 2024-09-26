import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2960 extends WebSecurityConfigurerAdapter {
    private String userAccess[] = new String[]{"/dashboard/**"};
    private String dataAccess[] = new String[]{"/data/**"};
    private String adminAccess[] = new String[]{"/admin/**"};
    private String publicResources[] = new String[]{"/public/**"};

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

    public static void main(String[] args) {
        // This is just a placeholder. Normally, Spring Boot applications
        // are started with SpringApplication.run(Application.class, args);
    }
}