// Assuming this is within a method of a configuration class that extends WebSecurityConfigurerAdapter
public void configure9(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers(PUBLIC_MATCHERS).permitAll()
            .anyRequest().authenticated();
    // Additional configuration can be added here
}