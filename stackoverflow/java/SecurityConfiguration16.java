import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

@EnableWebSecurity
public class SecurityConfiguration16 {

    @Configuration
    @Order(1)
    public static class ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean<GenericFilterBean> customApiAuthenticationFilterRegistration() {
            FilterRegistrationBean<GenericFilterBean> registration = new FilterRegistrationBean<>();
            registration.setFilter(customApiAuthenticationFilter());
            registration.setEnabled(false);
            return registration;
        }

        @Bean
        public GenericFilterBean customApiAuthenticationFilter() {
            return new CustomApiAuthenticationFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**")
                .addFilterAfter(customApiAuthenticationFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest().hasRole("API")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }

    @Configuration
    @Order(2)
    public static class WebSecurityConfiguration16 extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean<GenericFilterBean> customWebAuthenticationFilterRegistration() {
            FilterRegistrationBean<GenericFilterBean> registration = new FilterRegistrationBean<>();
            registration.setFilter(customWebAuthenticationFilter());
            registration.setEnabled(false);
            return registration;
        }

        @Bean
        public GenericFilterBean customWebAuthenticationFilter() {
            return new CustomWebAuthenticationFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")
                .addFilterAfter(customWebAuthenticationFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/").hasRole("USER");
        }
    }
}