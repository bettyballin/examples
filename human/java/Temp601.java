import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Temp601 {

    public static void main(String[] args) {
        Temp601 temp = new Temp601();
        Collection<GrantedAuthority> authorities = temp.getAuthorities(1);
        for (GrantedAuthority authority : authorities) {
            System.out.println(authority.getAuthority());
        }
    }

    public Collection<GrantedAuthority> getAuthorities(Integer access) {
        List<GrantedAuthority> authList = new ArrayList<>(2);

        if (access.compareTo(1) == 0) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }
}

interface GrantedAuthority {
    String getAuthority();
}

class SimpleGrantedAuthority implements GrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}