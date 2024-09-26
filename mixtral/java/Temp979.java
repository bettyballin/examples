import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class Temp979 {
    public static void main(String[] args) {
        Temp979 instance = new Temp979();
        Authentication auth = instance.getAuth("user");
        System.out.println("Authentication: " + auth);
    }

    private Authentication getAuth(String username) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Add any necessary GrantedAuthorities here

        UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken(username, "password", authorities);

        return auth;
    }
}