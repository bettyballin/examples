import java.util.Collection;

public class UserDetails {
    private Collection<? extends GrantedAuthority> authorities;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

interface GrantedAuthority {
}

public class Main {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        userDetails.setAuthorities(authorities);
    }
}