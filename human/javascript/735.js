This is not JavaScript code, it's Java code. Here is the corrected version:

java
@Configuration
@Slf4j
@Order(99)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .requestMatchers()
                .antMatchers("/api/**")
                .and()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .httpBasic(); // <-- use HTTP basic
    }
}


Note: There is no equivalent executable JavaScript code for this Java configuration class as it's a part of the Spring Security framework which is specific to Java.