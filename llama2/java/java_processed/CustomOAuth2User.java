import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {
    private final User user;
    private final OAuth2AccessToken token;

    public CustomOAuth2User(User user, OAuth2AccessToken token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public OAuth2AccessToken getToken() {
        return token;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of(); // Assuming an empty map, replace with actual attributes if needed
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return user.getAuthorities(); // Assuming User class has a method to get authorities
    }

    @Override
    public String getName() {
        return user.getUsername(); // Assuming User class has a method to get the username
    }
}

class User {
    private String username;
    private Collection<GrantedAuthority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

interface GrantedAuthority {
    String getAuthority();
}

interface OAuth2User {
    Map<String, Object> getAttributes();
    Collection<GrantedAuthority> getAuthorities();
    String getName();
}

interface OAuth2AccessToken {
}