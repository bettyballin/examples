import java.util.List;
import java.util.ArrayList;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp1930 {
    public static void main(String[] args) {
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        roleList.add(new SimpleGrantedAuthority("ADMIN"));
        
        // Print the roles to verify the output
        roleList.forEach(role -> System.out.println(role.getAuthority()));
    }
}