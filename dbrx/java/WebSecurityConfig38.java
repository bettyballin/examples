import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUrlNormalizationFilter urlNormalizationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(urlNormalizationFilter, ChannelProcessingFilter.class)
            .authorizeRequests()
                .regexMatchers("/admin/.*").hasRole("VIEW_ADMIN_PARTNER_LIST")
                .anyRequest().authenticated()
            .and()
            .csrf().disable();
    }
}