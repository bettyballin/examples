import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> ipAddresses = Arrays.asList("127.0.0.1", "192.168.1.0/24", "::1");

        String accessExpression = "hasRole('admin') and (";

        for(int i=0; i<ipAddresses.size(); ++i) {
            if(i > 0){
                accessExpression += " or ";
            }

            // Add single quotes around the IP address
            String ip = "'" + ipAddresses.get(i).replace("'", "") + "'";

            accessExpression += "hasIpAddress(" + ip + ")";
        }

        accessExpression += ")";

        http
            .authorizeRequests()
                // Use single antMatcher for all IP addresses
                .antMatchers("/admin/**").access(accessExpression);
    }

    // some other configurations
}