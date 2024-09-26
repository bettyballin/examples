import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp969 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // To run this code, you would typically need to set up a Spring Boot application.
        // Here, we are just showing the configuration part of the security setup.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String roles[] = new String[]{"ROLE_EDITOR", "ROLE_AUTHORISER"};

        // Permit these resources
        http.httpBasic()
            .and().authorizeRequests()
            .antMatchers("/login", "/4_security/login.html", "/bower_components/**",
                    "/0_common/*.html", "/1_reportingEntities/*.js",
                    "/2_dataCollections/*.js", "/3_calendar/*.js",
                    "/4_security/*.js").permitAll()
            .and().authorizeRequests()
            // Allow only if has certain roles
            .antMatchers("/1_reportingEntities/*.html")
            .hasAnyRole(roles)

            // All other requests need authentication
            .anyRequest().authenticated();

        http
            .csrf()
            // Enable CSRF protection
            .and();

        // Enable HTTPS
        http.requiresChannel().anyRequest().requiresSecure();
    }
}