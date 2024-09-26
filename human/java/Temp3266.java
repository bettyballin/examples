import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp3266 {
    public static void main(String[] args) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_MY_USER");
        System.out.println(authority.getAuthority());
    }
}