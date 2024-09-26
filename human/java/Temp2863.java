import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.List;

public class Temp2863 {
    public static void main(String[] args) {
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        roleList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        System.out.println("Role added: " + roleList.get(0).getAuthority());
    }
}