import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.SecurityContextRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().securityContext().securityContextRepository(new TestSecurityContextRepository());
    }

    private static class TestSecurityContextRepository implements SecurityContextRepository {
        @Override
        public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
            return SecurityContextHolder.createEmptyContext();
        }

        @Override
        public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        }

        @Override
        public boolean containsContext(HttpServletRequest request) {
            return false;
        }
    }
}