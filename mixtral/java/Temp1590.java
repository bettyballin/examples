import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1590 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // X509Configurer x509Configurer = http.authorizeRequests().anyRequest().authenticated().and().x509();

        http
            .csrf()
                .disable()
            .cors()
                .and()
            .authorizeRequests()
                // Remove antMatcher for OPTIONS requests
                //.antMatchers(HttpMethod.OPTION \"/**\").permitAll()
                .anyRequest().authenticated()
                .and()
            .x509()
                .subjectPrincipalRegex("(.*?)")
                .userDetailsService(ourUserDetailsService);
    }

    // Assuming ourUserDetailsService is defined somewhere
    private final OurUserDetailsService ourUserDetailsService = new OurUserDetailsService();

    public static void main(String[] args) {
        // Start the application context
        org.springframework.boot.SpringApplication.run(Temp1590.class, args);
    }

    // Placeholder for the actual user details service
    public class OurUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
        @Override
        public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
            // Implement your user details loading logic here
            return new org.springframework.security.core.userdetails.User() {
                @Override
                public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
                    return Collections.emptyList();
                }

                @Override
                public String getPassword() {
                    return "password";
                }

                @Override
                public String getUsername() {
                    return "user";
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        }
    }
}