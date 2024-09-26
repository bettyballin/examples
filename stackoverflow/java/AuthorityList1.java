import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;

public class AuthorityList1 {
    public static void main(String[] args) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}