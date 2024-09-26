import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Temp1713 {
    private final Collection<GrantedAuthority> authorities;

    public Temp1713(Collection<GrantedAuthority> authorities) {
        ArrayList<GrantedAuthority> temp = new ArrayList<>(authorities.size());
        temp.addAll(authorities);
        this.authorities = Collections.unmodifiableList(temp);
    }

    public static void main(String[] args) {
        // Example usage
        Collection<GrantedAuthority> exampleAuthorities = new ArrayList<>();
        exampleAuthorities.add(new GrantedAuthority("ROLE_USER"));
        Temp1713 temp1713 = new Temp1713(exampleAuthorities);
        System.out.println(temp1713.getAuthorities());
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

class GrantedAuthority {
    private String authority;

    public GrantedAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "GrantedAuthority{" +
                "authority='" + authority + '\'' +
                '}';
    }
}