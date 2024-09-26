import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class FrameworkWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private Filter reallyImportantFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add your filter here before the authorizeRequests() method.
        http.addFilterBefore(reallyImportantFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().authenticated();
    }

    @Bean
    public Filter reallyImportantFilter() {
        return new ReallyImportantFilter();
    }

    private static class ReallyImportantFilter implements Filter {

        @Override
        public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)
                throws java.io.IOException, javax.servlet.ServletException {
            // Implement filter logic here
            chain.doFilter(request, response);
        }
    }
}