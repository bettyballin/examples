import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class Temp1995 {
    public static void main(String[] args) {
        String name = "user";
        String password = "password";

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        User user = null; // This would typically come from your user service or repository

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            user == null ? new User(name, "", new ArrayList<>()) : user,
            password,
            authorities
        );

        System.out.println(token);
    }
}