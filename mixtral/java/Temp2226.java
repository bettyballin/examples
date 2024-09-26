import java.util.Arrays;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp2226 {
    public static void main(String[] args) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        System.out.println(authority.getAuthority());
    }
}