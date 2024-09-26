import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

public class Temp598 {

    public static void main(String[] args) {
        // Example usage
        AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(new InMemoryUserDetailsManager());
        configure(auth);
    }

    public static void configure(AuthenticationManagerBuilder auth) {
        MyAuthenticationProvider provider = new MyAuthenticationProvider();
        provider.setUsername("user");
        provider.setPassword("password");
        auth.authenticationProvider(provider);
    }

    static class MyAuthenticationProvider implements AuthenticationProvider {

        private String username;
        private String password;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String name = authentication.getName();
            String credentials = authentication.getCredentials().toString();

            if (username.equals(name) && password.equals(credentials)) {
                UserDetails user = User.withUsername(username).password(password).authorities(Collections.singletonList(new SimpleGrantedAuthority("USER"))).build();
                return new UsernamePasswordAuthenticationToken(user, credentials, user.getAuthorities());
            } else {
                return null;
            }
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }
    }
}