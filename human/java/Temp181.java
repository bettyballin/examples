import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain springSecurityFilterChain() {
        SecurityContextPersistenceFilter securityContextPersistenceFilter = new SecurityContextPersistenceFilter();

        FilterChainProxy filterChainProxy = new FilterChainProxy(Collections.singletonList(
                new DefaultSecurityFilterChain(new AntPathRequestMatcher("/messagebroker/**"), securityContextPersistenceFilter)
        ));

        return filterChainProxy;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(springSecurityFilterChain(), SecurityContextPersistenceFilter.class);
    }
}