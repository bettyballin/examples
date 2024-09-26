import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;

@Configuration
@EnableWebSecurity
public class Temp2763 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
                .withObjectPostProcessor(new ObjectPostProcessor<BasicAuthenticationFilter>() {
                    @Override
                    public BasicAuthenticationFilter postProcess(BasicAuthenticationFilter filter) {
                        return new IgnoreFailuresBasicAuthenticationFilter(filter);
                    }
                });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    public class IgnoreFailuresBasicAuthenticationFilter extends BasicAuthenticationFilter {

        public IgnoreFailuresBasicAuthenticationFilter(BasicAuthenticationFilter filter) {
            super(filter.getAuthenticationManager());
        }

        @Override
        protected void onUnsuccessfulAuthentication(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.AuthenticationException failed) {
            // Ignore failures
        }
    }
}