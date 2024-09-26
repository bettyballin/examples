import java.util.HashSet;
import java.util.Set;

interface GrantedAuthority {
    String getAuthority();
}

class OAuth2Authentication {
    private Set<GrantedAuthority> authorities;

    public OAuth2Authentication(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

class User {
    private Set<GrantedAuthority> authorities;

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

public class Temp2744 {
    public static void main(String[] args) {
        // Create some sample authorities
        Set<GrantedAuthority> sampleAuthorities = new HashSet<>();
        sampleAuthorities.add(() -> "ROLE_USER");
        sampleAuthorities.add(() -> "ROLE_ADMIN");

        // Create an OAuth2Authentication object with the sample authorities
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(sampleAuthorities);

        // Create a User object
        User user = new User();

        // Set user's authorities from the OAuth2Authentication object
        user.setAuthorities(new HashSet<GrantedAuthority>(oAuth2Authentication.getAuthorities()));

        // Print out the authorities to verify
        for (GrantedAuthority authority : user.authorities) {
            System.out.println(authority.getAuthority());
        }
    }
}