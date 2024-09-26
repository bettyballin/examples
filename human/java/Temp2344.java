import java.util.ArrayList;
import java.util.List;

class User_Authority {
    private String roleName;

    public User_Authority(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

interface GrantedAuthority {
    String getAuthority();
}

class SimpleGrantedAuthority implements GrantedAuthority {
    private String roleName;

    public SimpleGrantedAuthority(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}

class User {
    private List<User_Authority> authorities;

    public User(List<User_Authority> authorities) {
        this.authorities = authorities;
    }

    public List<User_Authority> getAuthorities() {
        return authorities;
    }
}

public class Temp2344 {
    public static void main(String[] args) {
        List<User_Authority> userAuthorities = new ArrayList<>();
        userAuthorities.add(new User_Authority("ROLE_USER"));
        userAuthorities.add(new User_Authority("ROLE_ADMIN"));

        User user = new User(userAuthorities);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (User_Authority auth : user.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(auth.getRoleName()));
        }

        for (GrantedAuthority authority : authorities) {
            System.out.println(authority.getAuthority());
        }
    }
}