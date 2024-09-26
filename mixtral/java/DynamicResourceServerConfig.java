import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class DynamicResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomScopeService scopeService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> antMatchers = scopeService.getAntMatchers();
        Map<String, String> scopesByUrl = scopeService.getScopesByUrl(antMatchers);

        for (String antMatcher : antMatchers) {
            String scope = scopesByUrl.get(antMatcher);
            if (scope != null) {
                http.authorizeRequests()
                        .antMatchers(antMatcher).hasAuthority(scope);
            }
        }
    }
}

interface CustomScopeService {

    List<String> getAntMatchers();

    Map<String, String> getScopesByUrl(List<String> antMatchers);
}