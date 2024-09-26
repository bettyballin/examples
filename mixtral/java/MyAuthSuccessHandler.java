import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class MyAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Simulating retrieval of CustomUser from the database
        CustomUser customUser = retrieveCustomUserFromDatabase();

        OAuth2AccessToken accessToken = (OAuth2AccessToken) ((OAuth2AuthenticatedPrincipal) authentication.getPrincipal()).getAttribute("access_token");

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // Simulating adding roles/authorities to the custom user
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(customUser, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(token);
    }

    // Simulated method to retrieve CustomUser from the database
    private CustomUser retrieveCustomUserFromDatabase() {
        return new CustomUser("username", "password", new ArrayList<>());
    }

    // Simulated CustomUser class
    public class CustomUser {
        private String username;
        private String password;
        private Collection<GrantedAuthority> authorities;

        public CustomUser(String username, String password, Collection<GrantedAuthority> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Collection<GrantedAuthority> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(Collection<GrantedAuthority> authorities) {
            this.authorities = authorities;
        }
    }
}