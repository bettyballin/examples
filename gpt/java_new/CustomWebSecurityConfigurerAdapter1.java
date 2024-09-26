import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter1 extends WebSecurityConfigurerAdapter {

    private static class ClientRequestMatcher implements RequestMatcher {
        private String clientName;
        private int port;

        public ClientRequestMatcher(String clientName, int port) {
            this.clientName = clientName;
            this.port = port;
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            // Insert match logic here
            return request.getServerName().equalsIgnoreCase(clientName)
                    && request.getServerPort() == port;
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/health").permitAll()
            .anyRequest().authenticated()
            .and()
            .requestMatcher(new ClientRequestMatcher("clientA", 8080))
            .authorizeRequests()
            .anyRequest().permitAll();
    }
}