import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import javax.servlet.Filter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public Filter ajaxTimeOutRedirectFilter() {
        AjaxTimeOutRedirectFilter f = new AjaxTimeOutRedirectFilter();
        // f.setCustomSessionExpiredErrorCode(901);
        return f;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(ajaxTimeOutRedirectFilter(), ExceptionTranslationFilter.class);
        // Add other configurations here
    }

    // Dummy class to illustrate the example
    public static class AjaxTimeOutRedirectFilter implements Filter {
        // Implement the necessary methods here
    }
}