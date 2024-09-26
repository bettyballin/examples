import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers()
                .frameOptions().sameOrigin()
                .contentTypeOptions();

        if (env.getRequiredProperty("server.ssl.enabled") != null && env.getProperty("server.ssl.enabled").equalsIgnoreCase("true")) {
            // Enable HSTS
            http
                .headers()
                    .httpStrictTransportSecurity()
                        .includeSubDomains(true)
                        .maxAgeInSeconds((int) TimeUnit.DAYS.toSeconds(365));
        }
    }
}