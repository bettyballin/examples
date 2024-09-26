import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp2225 {
    public static void main(String[] args) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        List<SimpleGrantedAuthority> authorities = Arrays.asList(simpleGrantedAuthority);
        System.out.println(authorities);
    }
}