import java.util.ArrayList;
import java.util.List;

class GrantedAuthority {
    // Assuming some properties and methods for the sake of example
}

class UserDetailsImpl {
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

public class Temp1800 {
    public static void main(String[] args) {
        UserDetailsImpl u = new UserDetailsImpl();
        u.getAuthorities().add(new GrantedAuthority());
    }
}