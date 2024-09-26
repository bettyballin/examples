import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig218 {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .authorizeRequests()
                .antMatchers("/", "/index.html", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole("STUDENT")
                .anyRequest().authenticated()
                .and()
            // Add your custom JwtUserNameAndPasswordAuthFilter here if needed
            // .addFilterBefore(new JwtUserNameAndPasswordAuthFilter(authenticationManagerBean()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}