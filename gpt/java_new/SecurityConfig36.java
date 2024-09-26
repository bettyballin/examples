public class SecurityConfig36 extends WebSecurityConfig36urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configurations ...
            .authorizeRequests()
                .antMatchers("/index.html").authenticated()
                .anyRequest().permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .csrf().disable(); // Add this line if CSRF protection is not needed
    }
}