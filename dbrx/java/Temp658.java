import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class Temp658 extends WebSecurityConfigurerAdapter {

    @Autowired
    private YourDatabaseRepository repository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        List<YourEntity> entities = repository.findAll();
        
        for (YourEntity entity : entities) {
            String antMatcher = entity.getAntMatchers();
            String scope = entity.getScopes();

            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl = registry.antMatchers(antMatcher);
            
            if (!scope.isEmpty()) {
                authorizedUrl.access("#oauth2.hasScope('" + scope + "')");
            }
        }
        registry.anyRequest().authenticated().and().oauth2Login();
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp658.class, args);
    }
}