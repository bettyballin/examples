import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.ArrayList;

// Assuming User_Authority is a custom class and user is an instance of another class with getAuthorities method.

List<GrantedAuthority> authorities = new ArrayList<>();
for (User_Authority auth : user.getAuthorities()) {
    authorities.add(new SimpleGrantedAuthority(auth.getRoleName()));
}