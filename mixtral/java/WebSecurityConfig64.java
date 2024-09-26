import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // In-memory authentication
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password")
                .roles("USER");

        /*
         * If you want to use a custom UserDetailsService
         * replace the above with:

           // Database authentication
          auth.jdbcAuthentication()
              .dataSource(dataSource)
                  .usersByUsernameQuery("<your_query>")
                      .authoritiesByUsernameQuery("<your_query>");

        */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       // Enable Basic Authentication
       http.httpBasic();

       /*
         * If you want to secure specific URLs
         * replace the above with:

           http
               .authorizeRequests()
                   .antMatchers("/api/**").hasRole("USER")
                        .anyRequest().authenticated()

            // Enable Basic Authentication
             .and()
             .httpBasic();

       */
    }
}


Note: To make this code work in a real-world scenario, you need to have the appropriate Spring Security dependencies in your `pom.xml` or `build.gradle` file. Here is an example for `pom.xml`:

xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
</dependency>


Or for `build.gradle`:

groovy
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.security:spring-security-config'
implementation 'org.springframework.security:spring-security-web'