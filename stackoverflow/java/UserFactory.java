import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserFactory {
    public UserDetails createUser(org.example.UserEntity userEntity) {
        List<SimpleGrantedAuthority> roleList = userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        
        return new User(userEntity.getUsername(), userEntity.getPassword(), roleList);
    }
}