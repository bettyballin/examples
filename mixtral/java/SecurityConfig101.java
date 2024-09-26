import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    // This configuration will be applied for /rest/**

    @Order(1)
    @Configuration
    public static class RestApiSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception 
        {
            http
               .antMatcher("/rest/**")
               .authorizeRequests()
                   .anyRequest().hasRole("SUPER_ADMIN")
               .and()
               .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            // This is to ignore the security for static resources
            web
              .ignoring().antMatchers("/rest/**");
         }
    }

   // This configuration will be applied for other requests

    @Order(2)
    @Configuration
    public class FormLoginSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception 
        {
            http
               .authorizeRequests()
                   .anyRequest().fullyAuthenticated()
               .and()
               .sessionManagement()
                    // Use stateful session management
                    .maximumSessions(-1);

           http
              .formLogin();
        }

       @Override
      public void configure(WebSecurity web) throws Exception {
          // This is to ignore the security for static resources
         web
            .ignoring().antMatchers("/css/**", "/js/**");
     }
    }
}