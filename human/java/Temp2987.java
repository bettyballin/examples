import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter(ObjectMapper mapper) {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(mapper);
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    // To prevent registering the filter in the default filter chain!
    @Bean
    public FilterRegistrationBean<CustomAuthenticationFilter> customAuthenticationFilterRegistration(ObjectMapper mapper) {
        FilterRegistrationBean<CustomAuthenticationFilter> filterReg = new FilterRegistrationBean<>(customAuthenticationFilter(mapper));
        filterReg.setEnabled(false);
        return filterReg;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(customAuthenticationFilter(new ObjectMapper()), UsernamePasswordAuthenticationFilter.class);
        // other config here
    }
}