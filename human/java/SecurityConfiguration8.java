import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@SpringBootApplication
public class SecurityConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityConfigurationApplication.class, args);
    }

    @Configuration
    @Order(1)
    public static class ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean<GenericFilterBean> customApiAuthenticationFilterRegistration() {
            FilterRegistrationBean<GenericFilterBean> registration = new FilterRegistrationBean<>(customApiAuthenticationFilter());
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
                .addFilterAfter(customApiAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeRequests()
                .anyRequest()
                .hasRole("API")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }

    @Configuration
    @Order(2)
    public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean<GenericFilterBean> customWebAuthenticationFilterRegistration() {
            FilterRegistrationBean<GenericFilterBean> registration = new FilterRegistrationBean<>(customWebAuthenticationFilter());
            registration.setEnabled(false);
            return registration;
        }

        @Bean
        public GenericFilterBean customWebAuthenticationFilter() {
            return new CustomWebAuthenticationFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/")
                .addFilterAfter(customWebAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeRequests()
                .antMatchers("/")
                .hasRole("USER");
        }
    }

    public static class CustomApiAuthenticationFilter extends GenericFilterBean {
        @Override
        public void doFilter(java.servlet.ServletRequest request, java.servlet.ServletResponse response,
                javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
            // Custom API authentication logic
            chain.doFilter(request, response);
        }
    }

    public static class CustomWebAuthenticationFilter extends GenericFilterBean {
        @Override
        public void doFilter(java.servlet.ServletRequest request, java.servlet.ServletResponse response,
                javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
            // Custom web authentication logic
            chain.doFilter(request, response);
        }
    }
}