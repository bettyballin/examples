import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.ArrayList;
import java.util.List;

public class Temp1415 {
    public static void main(String[] args) {
        String userId = "user_id";
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        CustomJwtAuthenticationToken authentication = new CustomJwtAuthenticationToken(userId, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

class CustomJwtAuthenticationToken implements Authentication {
    private String userId;
    private List<GrantedAuthority> authorities;
    private boolean authenticated = true;

    public CustomJwtAuthenticationToken(String userId, List<GrantedAuthority> authorities) {
        this.userId = userId;
        this.authorities = authorities;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userId;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        this.authenticated = false;
    }

    @Override
    public String getName() {
        return userId;
    }
}