import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig198urerAdapter;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

@Configuration
@EnableWebSecurity
public class SecurityConfig198 extends WebSecurityConfig198urerAdapter {

    @Value("${ifttt.service-key}")
    private String myIftttServiceKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorize -> {
                AuthorizedUrl authorizedUrl = authorize
                    .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll();
                authorizedUrl.antMatchers("/your-secure-endpoint/**").authenticated();
                authorizedUrl.anyRequest().permitAll();
            })
            .addFilterBefore(new IFTTTServiceKeyFilter(myIftttServiceKey), UsernamePasswordAuthenticationFilter.class)
            .csrf().disable();
    }
}